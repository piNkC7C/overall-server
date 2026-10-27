package cn.iocoder.yudao.module.trade.service.price.calculator;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.module.promotion.api.bargain.BargainRecordApi;
import cn.iocoder.yudao.module.promotion.api.bargain.dto.BargainValidateJoinRespDTO;
import cn.iocoder.yudao.module.promotion.enums.common.PromotionTypeEnum;
import cn.iocoder.yudao.module.trade.enums.order.TradeOrderTypeEnum;
import cn.iocoder.yudao.module.trade.service.price.bo.TradePriceCalculateReqBO;
import cn.iocoder.yudao.module.trade.service.price.bo.TradePriceCalculateRespBO;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * 砍价活动的 {@link TradePriceCalculator} 实现类
 *
 * @author 芋道源码
 */
@Component
@Order(TradePriceCalculator.ORDER_BARGAIN_ACTIVITY)
public class TradeBargainActivityPriceCalculator implements TradePriceCalculator {

    @Resource
    private BargainRecordApi bargainRecordApi;

    @Override
    public void calculate(TradePriceCalculateReqBO param, TradePriceCalculateRespBO result) {
        // 1. 判断订单类型和是否具有砍价记录编号
        if (ObjectUtil.notEqual(result.getType(), TradeOrderTypeEnum.BARGAIN.getType())) {
            return;
        }
        Assert.isTrue(param.getItems().size() == 1, "Bargain allows only one product");
        Assert.isTrue(param.getItems().get(0).getCount() == 1, "Bargain quantity must be 1");
        // 2. 校验是否可以参与砍价
        TradePriceCalculateRespBO.OrderItem orderItem = result.getItems().get(0);
        BargainValidateJoinRespDTO bargainActivity = bargainRecordApi.validateJoinBargain(
                param.getUserId(), param.getBargainRecordId(), orderItem.getSkuId()).getCheckedData();

        // 3.1 recordDiscountdetail
        Integer discountPrice = orderItem.getPayPrice() - bargainActivity.getBargainPrice() * orderItem.getCount();
        // TODO 芋艿：极端情况，优惠金额为负数，需要处理
        TradePriceCalculatorHelper.addPromotion(result, orderItem,
                bargainActivity.getActivityId(), bargainActivity.getName(), PromotionTypeEnum.BARGAIN_ACTIVITY.getType(),
                StrUtil.format("Bargain: save ${}", TradePriceCalculatorHelper.formatPrice(discountPrice)),
                discountPrice);
        // 3.2 update SKU Discount amount
        orderItem.setDiscountPrice(orderItem.getDiscountPrice() + discountPrice);
        TradePriceCalculatorHelper.recountPayPrice(orderItem);
        TradePriceCalculatorHelper.recountAllPrice(result);
        // 4. 特殊：设置对应的砍价活动编号
        result.setBargainActivityId(bargainActivity.getActivityId());
    }

}
