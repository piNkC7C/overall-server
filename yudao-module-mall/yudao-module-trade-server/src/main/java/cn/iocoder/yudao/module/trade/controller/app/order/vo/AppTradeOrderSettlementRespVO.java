package cn.iocoder.yudao.module.trade.controller.app.order.vo;

import cn.iocoder.yudao.module.trade.controller.app.base.property.AppProductPropertyValueDetailRespVO;
import cn.iocoder.yudao.module.trade.service.price.bo.TradePriceCalculateRespBO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Trade order settlement response VO.")
@Data
public class AppTradeOrderSettlementRespVO {

    @Schema(description = "Trade type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1") // Matching TradeOrderTypeEnum enum
    private Integer type;

    @Schema(description = "Cart items.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Item> items;

    @Schema(description = "CouponArray.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Coupon> coupons; // Can + unavailable

    @Schema(description = "Fee.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Price price;

    @Schema(description = "Shipping address.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Address address;

    @Schema(description = "Already used points.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer usePoint;

    @Schema(description = "Total points.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer totalPoint;

    /**
     * 营销活动数组
     *
     * 只对应 {@link TradePriceCalculateRespBO.Price#items} 商品匹配的活动
     */
    private List<TradePriceCalculateRespBO.Promotion> promotions;

    @Schema(description = "Cart item.")
    @Data
    public static class Item {

        // ========== SPU info ==========

        @Schema(description = "Category ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
        private Long categoryId;
        @Schema(description = "SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
        private Long spuId;
        @Schema(description = "SPU name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Apple iPhone 12")
        private String spuName;

        // ========== SKU info ==========

        @Schema(description = "SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Integer skuId;
        @Schema(description = "Price, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
        private Integer price;
        @Schema(description = "ImageAddress.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/1.png")
        private String picUrl;

        @Schema(description = "Attribute Array.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
        private List<AppProductPropertyValueDetailRespVO> properties;

        // ========== 购物车信息 ==========

        @Schema(description = "Cart ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
        private Long cartId;

        @Schema(description = "Purchase quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Integer count;

    }

    @Schema(description = "Fee (total).")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Price {

        @Schema(description = "Product original price (total) in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "500")
        private Integer totalPrice;

        @Schema(description = "Order discount (total) in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "66")
        private Integer discountPrice;

        @Schema(description = "Shipping amount, in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "50")
        private Integer deliveryPrice;

        @Schema(description = "Coupon discount amount, unit: cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
        private Integer couponPrice;

        @Schema(description = "Points redemption amount, unit: cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "50")
        private Integer pointPrice;

        @Schema(description = "VIP discount amount, unit: cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "30")
        private Integer vipPrice;

        @Schema(description = "Actual paid amount (total) in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "450")
        private Integer payPrice;

    }

    @Schema(description = "Address info.")
    @Data
    public static class Address {

        @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Long id;

        @Schema(description = "Recipient name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alex")
        private String name;

        @Schema(description = "Phone number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15601691300")
        private String mobile;

        @Schema(description = "Region ID", requiredMode = Schema.RequiredMode.REQUIRED)
        private Long areaId;
        @Schema(description = "Region name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Putuo District, Shanghai")
        private String areaName;

        @Schema(description = "Full Address", requiredMode = Schema.RequiredMode.REQUIRED, example = "Building A, Wangjing Plaza")
        private String detailAddress;

        @Schema(description = "Default shipping address.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
        private Boolean defaultStatus;

    }

    @Schema(description = "Coupon info.")
    @Data
    public static class Coupon {

        @Schema(description = "Coupon code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Long id;

        @Schema(description = "Coupon name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "New Year sale")
        private String name;

        @Schema(description = "Minimum spend required.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100") // 单位：分；0 - 不限制
        private Integer usePrice;

        @Schema(description = "Fixed date - effective start.")
        private LocalDateTime validStartTime;

        @Schema(description = "Fixed date - effective end.")
        private LocalDateTime validEndTime;

        @Schema(description = "Discount type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Integer discountType;

        @Schema(description = "Discount percent.", example = "80") //  例如说，80% 为 80
        private Integer discountPercent;

        @Schema(description = "Discount amount.", example = "10")
        private Integer discountPrice;

        @Schema(description = "Discount limit.", example = "100") // 单位：分，仅在 discountType 为 PERCENT 使用
        private Integer discountLimitPrice;

        @Schema(description = "Is not can.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
        private Boolean match;

        @Schema(description = "Unavailable reason.", example = "DiscountcouponExpired")
        private String mismatchReason;

    }

}
