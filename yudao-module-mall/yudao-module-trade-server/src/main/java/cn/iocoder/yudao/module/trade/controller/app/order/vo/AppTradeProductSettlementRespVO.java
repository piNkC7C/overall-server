package cn.iocoder.yudao.module.trade.controller.app.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Schema(description = "Product settlement response VO.")
@Data
public class AppTradeProductSettlementRespVO {

    @Schema(description = "SPU product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long spuId;

    @Schema(description = "SKU Price info Array.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private List<Sku> skus;

    @Schema(description = "Spend-and-save campaign info.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private RewardActivity rewardActivity;

    @Schema(description = "SKU Price info.")
    @Data
    public static class Sku implements Serializable {

        @Schema(description = "Product SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Long id;

        @Schema(description = "Discount after Price, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
        private Integer promotionPrice;

        @Schema(description = "Promotion type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4")
        private Integer promotionType; // 对应 PromotionTypeEnum 枚举，目前只有 4 和 6 两种

        @Schema(description = "Promotion ID.", requiredMode = Schema.RequiredMode.REQUIRED)
        private Long promotionId; // 目前只有限时折扣活动的编号

        @Schema(description = "Campaign end time.", requiredMode = Schema.RequiredMode.REQUIRED)
        private LocalDateTime promotionEndTime;

    }

    @Schema(description = "Spend-and-save campaign info.")
    @Data
    public static class RewardActivity {

        @Schema(description = "Spend-and-save campaign ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Long id;

        @Schema(description = "Condition type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Integer conditionType;

        @Schema(description = "Discount rule Array.", requiredMode = Schema.RequiredMode.REQUIRED)
        private List<RewardActivityRule> rules;

    }

    @Schema(description = "Discount rule.")
    @Data
    public static class RewardActivityRule {

        @Schema(description = "Promo threshold.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100") // 1. 满 N 元，单位：分; 2. 满 N 件
        private Integer limit;

        @Schema(description = "DiscountPrice.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
        private Integer discountPrice;

        @Schema(description = "Free shipping.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
        private Boolean freeDelivery;

        @Schema(description = "Bonus points.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
        private Integer point;

        @Schema(description = "Bonus coupon IDs")
        private Map<Long, Integer> giveCouponTemplateCounts;

    }

}
