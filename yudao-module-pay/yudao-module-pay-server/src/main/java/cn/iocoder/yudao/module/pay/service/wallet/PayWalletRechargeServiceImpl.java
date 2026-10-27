package cn.iocoder.yudao.module.pay.service.wallet;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.iocoder.yudao.framework.common.enums.UserTypeEnum;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.pay.api.order.dto.PayOrderCreateReqDTO;
import cn.iocoder.yudao.module.pay.api.refund.PayRefundApi;
import cn.iocoder.yudao.module.pay.api.refund.dto.PayRefundCreateReqDTO;
import cn.iocoder.yudao.module.pay.api.refund.dto.PayRefundRespDTO;
import cn.iocoder.yudao.module.pay.controller.app.wallet.vo.recharge.AppPayWalletRechargeCreateReqVO;
import cn.iocoder.yudao.module.pay.dal.dataobject.order.PayOrderDO;
import cn.iocoder.yudao.module.pay.dal.dataobject.wallet.PayWalletDO;
import cn.iocoder.yudao.module.pay.dal.dataobject.wallet.PayWalletRechargeDO;
import cn.iocoder.yudao.module.pay.dal.dataobject.wallet.PayWalletRechargePackageDO;
import cn.iocoder.yudao.module.pay.dal.mysql.wallet.PayWalletRechargeMapper;
import cn.iocoder.yudao.module.pay.enums.PayChannelEnum;
import cn.iocoder.yudao.module.pay.enums.order.PayOrderStatusEnum;
import cn.iocoder.yudao.module.pay.enums.refund.PayRefundStatusEnum;
import cn.iocoder.yudao.module.pay.enums.wallet.PayWalletBizTypeEnum;
import cn.iocoder.yudao.module.pay.framework.pay.config.PayProperties;
import cn.iocoder.yudao.module.pay.service.order.PayOrderService;
import cn.iocoder.yudao.module.system.api.social.SocialClientApi;
import cn.iocoder.yudao.module.system.api.social.dto.SocialWxaOrderUploadShippingInfoReqDTO;
import cn.iocoder.yudao.module.system.api.social.dto.SocialWxaSubscribeMessageSendReqDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

import static cn.hutool.core.util.ObjectUtil.notEqual;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.addTime;
import static cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString;
import static cn.iocoder.yudao.framework.common.util.number.MoneyUtils.fenToYuanStr;
import static cn.iocoder.yudao.module.pay.convert.wallet.PayWalletRechargeConvert.INSTANCE;
import static cn.iocoder.yudao.module.pay.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.module.pay.enums.MessageTemplateConstants.WXA_WALLET_RECHARGER_PAID;
import static cn.iocoder.yudao.module.pay.enums.refund.PayRefundStatusEnum.*;

/**
 * 钱包充值 Service 实现类
 *
 * @author jason
 */
@Service
@Slf4j
public class PayWalletRechargeServiceImpl implements PayWalletRechargeService {

    private static final String WALLET_RECHARGE_ORDER_SUBJECT = "Wallet top-up";

    @Resource
    private PayWalletRechargeMapper walletRechargeMapper;
    @Resource
    private PayWalletService payWalletService;
    @Resource
    private PayOrderService payOrderService;
    @Resource
    private PayWalletRechargePackageService payWalletRechargePackageService;

    @Resource
    public SocialClientApi socialClientApi;
    @Resource
    private PayRefundApi payRefundApi;

    @Resource
    private PayProperties payProperties;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PayWalletRechargeDO createWalletRecharge(Long userId, Integer userType, String userIp,
                                                    AppPayWalletRechargeCreateReqVO reqVO) {
        // 1.1 计算充值金额
        int payPrice;
        int bonusPrice = 0;
        if (Objects.nonNull(reqVO.getPackageId())) {
            PayWalletRechargePackageDO rechargePackage = payWalletRechargePackageService.validWalletRechargePackage(reqVO.getPackageId());
            payPrice = rechargePackage.getPayPrice();
            bonusPrice = rechargePackage.getBonusPrice();
        } else {
            payPrice = reqVO.getPayPrice();
        }
        // 1.2 插入充值记录
        PayWalletDO wallet = payWalletService.getOrCreateWallet(userId, userType);
        PayWalletRechargeDO recharge = INSTANCE.convert(wallet.getId(), payPrice, bonusPrice, reqVO.getPackageId());
        walletRechargeMapper.insert(recharge);

        // 2.1 create payment order
        Long payOrderId = payOrderService.createOrder(new PayOrderCreateReqDTO()
                .setAppKey(payProperties.getWalletPayAppKey()).setUserIp(userIp)
                .setUserId(userId).setUserType(userType) // User info
                .setMerchantOrderId(recharge.getId().toString()) // Business order code
                .setSubject(WALLET_RECHARGE_ORDER_SUBJECT).setBody("")
                .setPrice(recharge.getPayPrice())
                .setExpireTime(addTime(Duration.ofHours(2L)))); // TODO @芋艿：支付超时时间
        // 2.2 updatewallet top-up record payment
        walletRechargeMapper.updateById(new PayWalletRechargeDO().setId(recharge.getId()).setPayOrderId(payOrderId));
        recharge.setPayOrderId(payOrderId);
        return recharge;
    }

    @Override
    public PageResult<PayWalletRechargeDO> getWalletRechargePackagePage(Long userId, Integer userType,
                                                                        PageParam pageReqVO, Boolean payStatus) {
        PayWalletDO wallet = payWalletService.getOrCreateWallet(userId, userType);
        return walletRechargeMapper.selectPage(pageReqVO, wallet.getId(), payStatus);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateWalletRechargerPaid(Long id, Long payOrderId) {
        // 1.1 校验钱包充值是否存在
        PayWalletRechargeDO recharge = walletRechargeMapper.selectById(id);
        if (recharge == null) {
            log.error("[updateWalletRechargerPaid][recharge({}) payOrder({}) was not found top-up order, please process! ].", id, payOrderId);
            throw exception(WALLET_RECHARGE_NOT_FOUND);
        }
        // 1.2 校验钱包充值是否可以支付
        if (recharge.getPayStatus()) {
            // 特殊：支付单号相同，直接返回，说明重复回调
            if (ObjectUtil.equals(recharge.getPayOrderId(), payOrderId)) {
                log.warn("[updateWalletRechargerPaid][recharge({}) 已支付，且支付单号相同({})，直接返回]", recharge, payOrderId);
                return;
            }
            // 异常：支付单号不同，说明支付单号错误
            log.error("[updateWalletRechargerPaid][recharge({}) 已支付，但是支付单号不同({})，请进行处理！]", recharge, payOrderId);
            throw exception(WALLET_RECHARGE_UPDATE_PAID_PAY_ORDER_ID_ERROR);
        }

        // 2. 校验支付订单的合法性
        PayOrderDO payOrderDO = validatePayOrderPaid(recharge, payOrderId);

        // 3. updatewallet top-up payment status
        int updateCount = walletRechargeMapper.updateByIdAndPaid(id, false,
                new PayWalletRechargeDO().setId(id).setPayStatus(true).setPayTime(LocalDateTime.now())
                        .setPayChannelCode(payOrderDO.getChannelCode()));
        if (updateCount == 0) {
            throw exception(WALLET_RECHARGE_UPDATE_PAID_STATUS_NOT_UNPAID);
        }

        // 4. updatewallet balance
        // TODO @jason：这样的话，未来提现会不会把充值的，也提现走哈。类似先充 100，送 110；然后提现 110；
        // TODO 需要钱包中加个可提现余额
        payWalletService.addWalletBalance(recharge.getWalletId(), String.valueOf(id),
                PayWalletBizTypeEnum.RECHARGE, recharge.getTotalPrice());

        // 5. 发送订阅消息
        getSelf().sendWalletRechargerPaidMessage(payOrderId, recharge);
    }

    @Async
    public void sendWalletRechargerPaidMessage(Long payOrderId, PayWalletRechargeDO walletRecharge) {
        // 1. 构建并发送模版消息
        PayWalletDO wallet = payWalletService.getWallet(walletRecharge.getWalletId());
        socialClientApi.sendWxaSubscribeMessage(new SocialWxaSubscribeMessageSendReqDTO()
                .setUserId(wallet.getUserId()).setUserType(wallet.getUserType())
                .setTemplateTitle(WXA_WALLET_RECHARGER_PAID)
                .setPage("pages/user/wallet/money") // 钱包详情界面
                .addMessage("character_string1", String.valueOf(payOrderId)) // Payment order code
                .addMessage("amount2", fenToYuanStr(walletRecharge.getTotalPrice())) // Top-up amount
                .addMessage("time3", LocalDateTimeUtil.formatNormal(walletRecharge.getCreateTime())) // Top-up time
                .addMessage("phrase4", "Top-up succeeded")).checkError(); // Top-up status

        // 2. 调用接口上传虚拟物品发货信息
        // 注意：只有微信小程序支付的订单，才需要同步
        PayOrderDO payOrder = payOrderService.getOrder(payOrderId);
        if (ObjUtil.notEqual(payOrder.getChannelCode(), PayChannelEnum.WX_LITE.getCode())) {
            return;
        }
        SocialWxaOrderUploadShippingInfoReqDTO reqDTO = new SocialWxaOrderUploadShippingInfoReqDTO()
                .setTransactionId(payOrder.getChannelOrderNo())
                .setOpenid(payOrder.getChannelUserId())
                .setItemDesc(payOrder.getSubject())
                .setLogisticsType(SocialWxaOrderUploadShippingInfoReqDTO.LOGISTICS_TYPE_VIRTUAL); // 虚拟物品发货类型
        try {
            socialClientApi.uploadWxaOrderShippingInfo(UserTypeEnum.MEMBER.getValue(), reqDTO).checkError();
        } catch (Exception ex) {
            log.error("[sendWalletRechargerPaidMessage][订单({}) 上传订单物流信息到微信小程序失败]", payOrder, ex);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void refundWalletRecharge(Long id, String userIp) {
        // 1.1 get wallet top-up record
        PayWalletRechargeDO walletRecharge = walletRechargeMapper.selectById(id);
        if (walletRecharge == null) {
            log.error("[refundWalletRecharge][wallet top-up record was not found, wallet top-up record id({})].", id);
            throw exception(WALLET_RECHARGE_NOT_FOUND);
        }
        // 1.2 校验钱包充值是否可以发起退款
        PayWalletDO wallet = validateWalletRechargeCanRefund(walletRecharge);

        // 2. 冻结退款的余额，暂时只处理赠送的余额也全部退回
        payWalletService.freezePrice(wallet.getId(), walletRecharge.getTotalPrice());

        // 3. createrefund
        String walletRechargeId = String.valueOf(id);
        String refundId = walletRechargeId + "-refund";
        Long payRefundId = payRefundApi.createRefund(new PayRefundCreateReqDTO()
                .setAppKey(payProperties.getWalletPayAppKey()).setUserIp(userIp)
                .setUserId(wallet.getUserId()).setUserType(wallet.getUserType()) // User info
                .setMerchantOrderId(walletRechargeId)
                .setMerchantRefundId(refundId)
                .setReason("Request a refund").setPrice(walletRecharge.getPayPrice())).getCheckedData();

        // 4. update top-up recordrefund no
        walletRechargeMapper.updateById(new PayWalletRechargeDO().setPayRefundId(payRefundId)
                .setRefundStatus(WAITING.getStatus()).setId(walletRecharge.getId()));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateWalletRechargeRefunded(Long id, String refundId, Long payRefundId) {
        // 1.1 get wallet top-up record
        PayWalletRechargeDO walletRecharge = walletRechargeMapper.selectById(id);
        if (walletRecharge == null) {
            log.error("[updateWalletRechargerPaid][wallet top-up record was not found, wallet top-up record id({})].", id);
            throw exception(WALLET_RECHARGE_NOT_FOUND);
        }
        // 1.2 校验钱包充值是否可以更新已退款
        PayRefundRespDTO payRefund = validateWalletRechargeCanRefunded(walletRecharge, payRefundId);

        // 2. process refund result
        PayWalletRechargeDO updateObj = new PayWalletRechargeDO().setId(id);
        // 情况一：退款成功
        if (PayRefundStatusEnum.isSuccess(payRefund.getStatus())) {
            // 2.1 updatewallet balance
            payWalletService.reduceWalletBalance(walletRecharge.getWalletId(), id,
                    PayWalletBizTypeEnum.RECHARGE_REFUND, walletRecharge.getTotalPrice());

            updateObj.setRefundStatus(SUCCESS.getStatus()).setRefundTime(payRefund.getSuccessTime())
                    .setRefundTotalPrice(walletRecharge.getTotalPrice()).setRefundPayPrice(walletRecharge.getPayPrice())
                    .setRefundBonusPrice(walletRecharge.getBonusPrice());
        // 情况二：退款失败
        } else if (PayRefundStatusEnum.isFailure(payRefund.getStatus())) {
            // 2.2 解冻余额
            payWalletService.unfreezePrice(walletRecharge.getWalletId(), walletRecharge.getTotalPrice());

            updateObj.setRefundStatus(FAILURE.getStatus());
        }

        // 3. updatewallet top-up refund field
        walletRechargeMapper.updateByIdAndRefunded(id, WAITING.getStatus(), updateObj);
    }

    private PayRefundRespDTO validateWalletRechargeCanRefunded(PayWalletRechargeDO walletRecharge, Long payRefundId) {
        // 1. 校验退款订单匹配
        if (notEqual(walletRecharge.getPayRefundId(), payRefundId)) {
            log.error("[validateWalletRechargeCanRefunded][wallet top-up ({}) refund does not match({}), please process! wallet top-up data is ：{}].",
                    walletRecharge.getId(), payRefundId, toJsonString(walletRecharge));
            throw exception(WALLET_RECHARGE_REFUND_FAIL_REFUND_ORDER_ID_ERROR);
        }

        // 2.1 校验退款订单
        PayRefundRespDTO payRefund = payRefundApi.getRefund(payRefundId).getCheckedData();
        if (payRefund == null) {
            log.error("[validateWalletRechargeCanRefunded][payRefund({}) was not found].", payRefundId);
            throw exception(WALLET_RECHARGE_REFUND_FAIL_REFUND_NOT_FOUND);
        }
        // 2.2 校验退款金额一致
        if (notEqual(payRefund.getRefundPrice(), walletRecharge.getPayPrice())) {
            log.error("[validateWalletRechargeCanRefunded][wallet({}) payRefund({}) refund amount does not match, please process! wallet data is ：{}, payRefund data is ：{}].",
                    walletRecharge.getId(), payRefundId, toJsonString(walletRecharge), toJsonString(payRefund));
            throw exception(WALLET_RECHARGE_REFUND_FAIL_REFUND_PRICE_NOT_MATCH);
        }
        // 2.3 校验退款订单商户退款单是否匹配
        if (notEqual(payRefund.getMerchantRefundId(), walletRecharge.getId() + "-refund")) {
            log.error("[validateWalletRechargeCanRefunded][wallet({}) refund does not match({}), please process! payRefund data is ：{}].",
                    walletRecharge.getId(), payRefundId, toJsonString(payRefund));
            throw exception(WALLET_RECHARGE_REFUND_FAIL_REFUND_ORDER_ID_ERROR);
        }
        return payRefund;
    }

    private PayWalletDO validateWalletRechargeCanRefund(PayWalletRechargeDO walletRecharge) {
        // 校验充值订单是否支付
        if (!walletRecharge.getPayStatus()) {
            throw exception(WALLET_RECHARGE_REFUND_FAIL_NOT_PAID);
        }
        // 校验充值订单是否已退款
        if (walletRecharge.getPayRefundId() != null) {
            throw exception(WALLET_RECHARGE_REFUND_FAIL_REFUNDED);
        }
        // 校验钱包余额是否足够
        PayWalletDO wallet = payWalletService.getWallet(walletRecharge.getWalletId());
        Assert.notNull(wallet, "User wallet ({}) does not exist", wallet.getId());
        if (wallet.getBalance() < walletRecharge.getTotalPrice()) {
            throw exception(WALLET_RECHARGE_REFUND_BALANCE_NOT_ENOUGH);
        }
        // TODO @芋艿：需要考虑下，赠送的金额，会不会导致提现超过；
        return wallet;
    }

    /**
     * 校验支付订单的合法性
     *
     * @param recharge 充值订单
     * @param payOrderId 支付订单编号
     * @return 支付订单
     */
    private PayOrderDO validatePayOrderPaid(PayWalletRechargeDO recharge, Long payOrderId) {
        // 1. 校验支付单是否存在
        PayOrderDO payOrder = payOrderService.getOrder(payOrderId);
        if (payOrder == null) {
            log.error("[validatePayOrderPaid][ top-up order({}) payOrder({}) was not found, please process! ].",
                    recharge.getId(), payOrderId);
            throw exception(PAY_ORDER_NOT_FOUND);
        }

        // 2.1 校验支付单已支付
        if (!PayOrderStatusEnum.isSuccess(payOrder.getStatus())) {
            log.error("[validatePayOrderPaid][ top-up order({}) payOrder({}) unpaid, please process! payOrder data is ：{}].",
                    recharge.getId(), payOrderId, toJsonString(payOrder));
            throw exception(WALLET_RECHARGE_UPDATE_PAID_PAY_ORDER_STATUS_NOT_SUCCESS);
        }
        // 2.2 校验支付金额一致
        if (notEqual(payOrder.getPrice(), recharge.getPayPrice())) {
            log.error("[validatePayOrderPaid][ top-up order({}) payOrder({}) payment amount does not match, please process! wallet data is ：{}, payOrder data is ：{}].",
                    recharge.getId(), payOrderId, toJsonString(recharge), toJsonString(payOrder));
            throw exception(WALLET_RECHARGE_UPDATE_PAID_PAY_PRICE_NOT_MATCH);
        }
        // 2.3 校验支付订单的商户订单匹配
        if (notEqual(payOrder.getMerchantOrderId(), recharge.getId().toString())) {
            log.error("[validatePayOrderPaid][ top-up order({}) payment order does not match({}), please process! payOrder data is ：{}].",
                    recharge.getId(), payOrderId, toJsonString(payOrder));
            throw exception(WALLET_RECHARGE_UPDATE_PAID_PAY_ORDER_ID_ERROR);
        }
        return payOrder;
    }

    /**
     * 获得自身的代理对象，解决 AOP 生效问题
     *
     * @return 自己
     */
    private PayWalletRechargeServiceImpl getSelf() {
        return SpringUtil.getBean(getClass());
    }

}
