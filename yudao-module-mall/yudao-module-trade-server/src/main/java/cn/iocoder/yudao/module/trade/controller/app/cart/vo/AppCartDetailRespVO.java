package cn.iocoder.yudao.module.trade.controller.app.cart.vo;

import cn.iocoder.yudao.module.trade.controller.app.base.sku.AppProductSkuBaseRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "User cart detail response VO.")
@Data
public class AppCartDetailRespVO {

    /**
     * 商品分组数组
     */
    private List<ItemGroup> itemGroups;

    /**
     * 费用
     */
    private Order order;

    @Schema(description = "Product group.") // 多个商品，参加同一个活动，从而形成分组
    @Data
    public static class ItemGroup {

        /**
         * 商品数组
         */
        private List<Sku> items;
        /**
         * 营销活动，订单级别
         */
        private Promotion promotion;

    }

    @Schema(description = "Product SKU.")
    @Data
    public static class Sku extends AppProductSkuBaseRespVO {

        /**
         * SPU 信息
         */
        private AppProductSkuBaseRespVO spu;

        // ========== 购物车相关的字段 ==========

        @Schema(description = "Product quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Integer count;
        @Schema(description = "Selected.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
        private Boolean selected;

        // ========== 价格相关的字段，对应 PriceCalculateRespDTO.OrderItem 的属性 ==========

        // TODO 芋艿：后续可以去除一些无用的字段

        @Schema(description = "ProductOriginal Price ( order ).", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
        private Integer originalPrice;
        @Schema(description = "Original product total.", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
        private Integer totalOriginalPrice;
        @Schema(description = "Product-level discount (total).", requiredMode = Schema.RequiredMode.REQUIRED, example = "300")
        private Integer totalPromotionPrice;
        @Schema(description = "Final purchase amount (total).", requiredMode = Schema.RequiredMode.REQUIRED, example = "400")
        private Integer totalPresentPrice;
        @Schema(description = "Final purchase amount (unit).", requiredMode = Schema.RequiredMode.REQUIRED, example = "500")
        private Integer presentPrice;
        @Schema(description = "Amount due (total).", requiredMode = Schema.RequiredMode.REQUIRED, example = "600")
        private Integer totalPayPrice;

        // ========== 营销相关的字段 ==========
        /**
         * 营销活动，商品级别
         */
        private Promotion promotion;

    }

    @Schema(description = "Order.") // 对应 PriceCalculateRespDTO.Order 类，用于费用（合计）
    @Data
    public static class Order {

        // TODO 芋艿：后续可以去除一些无用的字段

        @Schema(description = "Original product total.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
        private Integer skuOriginalPrice;
        @Schema(description = "Product discount (total).", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
        private Integer skuPromotionPrice;
        @Schema(description = "Order discount (total).", requiredMode = Schema.RequiredMode.REQUIRED, example = "300")
        private Integer orderPromotionPrice;
        @Schema(description = "Shipping amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "400")
        private Integer deliveryPrice;
        @Schema(description = "Amount due (total).", requiredMode = Schema.RequiredMode.REQUIRED, example = "500")
        private Integer payPrice;

    }

    @Schema(description = "Campaign.") // Matching PriceCalculateRespDTO.Promotion class attribute
    @Data
    public static class Promotion {

        @Schema(description = "Promotion ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024") // 营销活动的编号、优惠劵的编号
        private Long id;
        @Schema(description = "Campaign name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Xx campaign.")
        private String name;
        @Schema(description = "Promotion type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Integer type;

        // ========== 匹配情况 ==========
        @Schema(description = "Is not meet Discount condition.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
        private Boolean meet;
        @Schema(description = "Meet condition Tip.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Holiday price: save $150.00")
        private String meetTip;

    }

}
