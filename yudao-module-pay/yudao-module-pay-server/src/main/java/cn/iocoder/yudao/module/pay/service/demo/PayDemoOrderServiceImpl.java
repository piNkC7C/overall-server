package cn.iocoder.yudao.module.pay.service.demo;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.iocoder.yudao.framework.common.enums.UserTypeEnum;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.pay.api.order.PayOrderApi;
import cn.iocoder.yudao.module.pay.api.order.dto.PayOrderCreateReqDTO;
import cn.iocoder.yudao.module.pay.api.order.dto.PayOrderRespDTO;
import cn.iocoder.yudao.module.pay.api.refund.PayRefundApi;
import cn.iocoder.yudao.module.pay.api.refund.dto.PayRefundCreateReqDTO;
import cn.iocoder.yudao.module.pay.api.refund.dto.PayRefundRespDTO;
import cn.iocoder.yudao.module.pay.controller.admin.demo.vo.order.PayDemoOrderCreateReqVO;
import cn.iocoder.yudao.module.pay.dal.dataobject.demo.PayDemoOrderDO;
import cn.iocoder.yudao.module.pay.dal.mysql.demo.PayDemoOrderMapper;
import cn.iocoder.yudao.module.pay.enums.order.PayOrderStatusEnum;
import cn.iocoder.yudao.module.pay.enums.refund.PayRefundStatusEnum;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static cn.hutool.core.util.ObjectUtil.notEqual;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.addTime;
import static cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString;
import static cn.iocoder.yudao.framework.common.util.servlet.ServletUtils.getClientIP;
import static cn.iocoder.yudao.module.pay.enums.ErrorCodeConstants.*;

/**
 * 示例订单 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
@Slf4j
public class PayDemoOrderServiceImpl implements PayDemoOrderService {

    /**
     * 接入的支付应用标识
     *
     * 从 [支付管理 -> 应用信息] 里添加
     */
    private static final String PAY_APP_KEY = "demo";

    /**
     * 商品信息 Map
     *
     * key：商品编号
     * value：[商品名、商品价格]
     */
    private final Map<Long, Object[]> spuNames = new HashMap<>();

    @Resource
    private PayOrderApi payOrderApi;
    @Resource
    private PayRefundApi payRefundApi;

    @Resource
    private PayDemoOrderMapper payDemoOrderMapper;

    public PayDemoOrderServiceImpl() {
        spuNames.put(1L, new Object[]{"Phone", 1});
        spuNames.put(2L, new Object[]{"TV", 10});
        spuNames.put(3L, new Object[]{"Watch", 100});
        spuNames.put(4L, new Object[]{"Laptop", 1000});
        spuNames.put(5L, new Object[]{"Car", 200000});
    }

    @Override
    public Long createDemoOrder(Long userId, PayDemoOrderCreateReqVO createReqVO) {
        // 1.1 get product
        Object[] spu = spuNames.get(createReqVO.getSpuId());
        Assert.notNull(spu, "Product ({}) does not exist", createReqVO.getSpuId());
        String spuName = (String) spu[0];
        Integer price = (Integer) spu[1];
        // 1.2 插入 demo 订单
        PayDemoOrderDO demoOrder = new PayDemoOrderDO().setUserId(userId)
                .setSpuId(createReqVO.getSpuId()).setSpuName(spuName)
                .setPrice(price).setPayStatus(false).setRefundPrice(0);
        payDemoOrderMapper.insert(demoOrder);

        // 2.1 create payment order
        Long payOrderId = payOrderApi.createOrder(new PayOrderCreateReqDTO()
                .setAppKey(PAY_APP_KEY).setUserIp(getClientIP()) // Payment app
                .setUserId(userId).setUserType(UserTypeEnum.ADMIN.getValue()) // User info
                .setMerchantOrderId(demoOrder.getId().toString()) // Business order code
                .setSubject(spuName).setBody("").setPrice(price) // Price info
                .setExpireTime(addTime(Duration.ofHours(2L)))).getCheckedData(); // Payment Expires at
        // 2.2 update payment order to demo order
        payDemoOrderMapper.updateById(new PayDemoOrderDO().setId(demoOrder.getId())
                .setPayOrderId(payOrderId));
        return demoOrder.getId();
    }

    @Override
    public PayDemoOrderDO getDemoOrder(Long id) {
        return payDemoOrderMapper.selectById(id);
    }

    @Override
    public PageResult<PayDemoOrderDO> getDemoOrderPage(PageParam pageReqVO) {
        return payDemoOrderMapper.selectPage(pageReqVO);
    }

    @Override
    public void updateDemoOrderPaid(Long id, Long payOrderId) {
        // 1.1 校验订单是否存在
        PayDemoOrderDO order = payDemoOrderMapper.selectById(id);
        if (order == null) {
            log.error("[updateDemoOrderPaid][order({}) payOrder({}) was not foundorder, please process! ].", id, payOrderId);
            throw exception(DEMO_ORDER_NOT_FOUND);
        }
        // 1.2 校验订单已支付
        if (order.getPayStatus()) {
            // 特殊：支付单号相同，直接返回，说明重复回调
            if (ObjectUtil.equals(order.getPayOrderId(), payOrderId)) {
                log.warn("[updateDemoOrderPaid][order({}) 已支付，且支付单号相同({})，直接返回]", order, payOrderId);
                return;
            }
            // 异常：支付单号不同，说明支付单号错误
            log.error("[updateDemoOrderPaid][order({}) payment order does not match({}), please process! ].",
                    order, payOrderId);
            throw exception(DEMO_ORDER_UPDATE_PAID_FAIL_PAY_ORDER_ID_ERROR);
        }

        // 2. 校验支付订单的合法性
        PayOrderRespDTO payOrder = validatePayOrderPaid(order, payOrderId);

        // 3. update PayDemoOrderDO status is already payment
        int updateCount = payDemoOrderMapper.updateByIdAndPayed(id, false,
                new PayDemoOrderDO().setPayStatus(true).setPayTime(LocalDateTime.now())
                        .setPayChannelCode(payOrder.getChannelCode()));
        if (updateCount == 0) {
            throw exception(DEMO_ORDER_UPDATE_PAID_STATUS_NOT_UNPAID);
        }
    }

    /**
     * 校验支付订单的合法性
     *
     * @param order 交易订单
     * @param payOrderId 支付订单编号
     * @return 支付订单
     */
    private PayOrderRespDTO validatePayOrderPaid(PayDemoOrderDO order, Long payOrderId) {
        // 1. 校验支付单是否存在
        PayOrderRespDTO payOrder = payOrderApi.getOrder(payOrderId).getCheckedData();
        if (payOrder == null) {
            log.error("[validatePayOrderPaid][order({}) payOrder({}) was not found, please process! ].", order.getId(), payOrderId);
            throw exception(PAY_ORDER_NOT_FOUND);
        }
        // 2.1 校验支付单已支付
        if (!PayOrderStatusEnum.isSuccess(payOrder.getStatus())) {
            log.error("[validatePayOrderPaid][order({}) payOrder({}) unpaid, please process! payOrder data is ：{}].",
                    order.getId(), payOrderId, toJsonString(payOrder));
            throw exception(DEMO_ORDER_UPDATE_PAID_FAIL_PAY_ORDER_STATUS_NOT_SUCCESS);
        }
        // 2.1 校验支付金额一致
        if (notEqual(payOrder.getPrice(), order.getPrice())) {
            log.error("[validatePayOrderPaid][order({}) payOrder({}) payment amount does not match, please process! order data is ：{}, payOrder data is ：{}].",
                    order.getId(), payOrderId, toJsonString(order), toJsonString(payOrder));
            throw exception(DEMO_ORDER_UPDATE_PAID_FAIL_PAY_PRICE_NOT_MATCH);
        }
        // 2.2 校验支付订单匹配（二次）
        if (notEqual(payOrder.getMerchantOrderId(), order.getId().toString())) {
            log.error("[validatePayOrderPaid][order({}) payment order does not match({}), please process! payOrder data is ：{}].",
                    order.getId(), payOrderId, toJsonString(payOrder));
            throw exception(DEMO_ORDER_UPDATE_PAID_FAIL_PAY_ORDER_ID_ERROR);
        }
        return payOrder;
    }

    @Override
    public void refundDemoOrder(Long id, String userIp) {
        // 1. 校验订单是否可以退款
        PayDemoOrderDO order = validateDemoOrderCanRefund(id);

        // 2.1 createrefund no
        // 一般来说，用户发起退款的时候，都会单独插入一个售后维权表，然后使用该表的 id 作为 refundId
        //          这里我们是个简单的 demo，所以没有售后维权表，直接使用订单 id + "-refund" 来演示
        String refundId = order.getId() + "-refund";
        // 2.2 createrefund
        Long payRefundId = payRefundApi.createRefund(new PayRefundCreateReqDTO()
                .setAppKey(PAY_APP_KEY).setUserIp(getClientIP()) // Payment app
                .setUserId(order.getUserId()).setUserType(UserTypeEnum.ADMIN.getValue()) // User info
                .setMerchantOrderId(String.valueOf(order.getId())) // Payment order no
                .setMerchantRefundId(refundId)
                .setReason("Request a refund").setPrice(order.getPrice())).getCheckedData();// Price info
        // 2.3 updaterefund to demo order
        payDemoOrderMapper.updateById(new PayDemoOrderDO().setId(id)
                .setPayRefundId(payRefundId).setRefundPrice(order.getPrice()));
    }

    private PayDemoOrderDO validateDemoOrderCanRefund(Long id) {
        // 校验订单是否存在
        PayDemoOrderDO order = payDemoOrderMapper.selectById(id);
        if (order == null) {
            throw exception(DEMO_ORDER_NOT_FOUND);
        }
        // 校验订单是否支付
        if (!order.getPayStatus()) {
            throw exception(DEMO_ORDER_REFUND_FAIL_NOT_PAID);
        }
        // 校验订单是否已退款
        if (order.getPayRefundId() != null) {
            throw exception(DEMO_ORDER_REFUND_FAIL_REFUNDED);
        }
        return order;
    }

    @Override
    public void updateDemoOrderRefunded(Long id, String refundId, Long payRefundId) {
        // 1. 校验并获得退款订单（可退款）
        PayRefundRespDTO payRefund = validateDemoOrderCanRefunded(id, refundId, payRefundId);
        // 2.2 updaterefund to demo order
        payDemoOrderMapper.updateById(new PayDemoOrderDO().setId(id)
                .setRefundTime(payRefund.getSuccessTime()));
    }

    private PayRefundRespDTO validateDemoOrderCanRefunded(Long id, String refundId, Long payRefundId) {
        // 1.1 校验示例订单
        // 一般来说，这里应该用 refundId 来查询退款单，然后再校验订单是否匹配
        //       这里我们是个简单的 demo，所以没有售后维权表，直接使用订单 id 来查询订单
        PayDemoOrderDO order = payDemoOrderMapper.selectById(id);
        if (order == null) {
            throw exception(DEMO_ORDER_NOT_FOUND);
        }
        // 1.2 校验退款订单匹配
        if (ObjUtil.notEqual(order.getPayRefundId(), payRefundId)) {
            log.error("[validateDemoOrderCanRefunded][order({}) refund does not match({}), please process! order data is ：{}].",
                    id, payRefundId, toJsonString(order));
            throw exception(DEMO_ORDER_REFUND_FAIL_REFUND_ORDER_ID_ERROR);
        }

        // 2.1 校验退款订单
        PayRefundRespDTO payRefund = payRefundApi.getRefund(payRefundId).getCheckedData();
        if (payRefund == null) {
            throw exception(DEMO_ORDER_REFUND_FAIL_REFUND_NOT_FOUND);
        }
        // 2.2 must be refund succeeded status
        if (!PayRefundStatusEnum.isSuccess(payRefund.getStatus())) {
            throw exception(DEMO_ORDER_REFUND_FAIL_REFUND_NOT_SUCCESS);
        }
        // 2.3 校验退款金额一致
        if (notEqual(payRefund.getRefundPrice(), order.getPrice())) {
            log.error("[validateDemoOrderCanRefunded][order({}) payRefund({}) refund amount does not match, please process! order data is ：{}, payRefund data is ：{}].",
                    id, payRefundId, toJsonString(order), toJsonString(payRefund));
            throw exception(DEMO_ORDER_REFUND_FAIL_REFUND_PRICE_NOT_MATCH);
        }
        // 2.4 校验退款订单匹配（二次）
        if (notEqual(payRefund.getMerchantRefundId(), id.toString() + "-refund")) {
            log.error("[validateDemoOrderCanRefunded][order({}) refund does not match({}), please process! payRefund data is ：{}].",
                    id, payRefundId, toJsonString(payRefund));
            throw exception(DEMO_ORDER_REFUND_FAIL_REFUND_ORDER_ID_ERROR);
        }
        return payRefund;
    }

}
