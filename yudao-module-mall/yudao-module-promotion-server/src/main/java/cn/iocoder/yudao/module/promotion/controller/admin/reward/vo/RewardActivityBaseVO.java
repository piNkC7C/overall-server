package cn.iocoder.yudao.module.promotion.controller.admin.reward.vo;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.promotion.enums.common.PromotionConditionTypeEnum;
import cn.iocoder.yudao.module.promotion.enums.common.PromotionProductScopeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 满减送活动 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class RewardActivityBaseVO {

    @Schema(description = "活动标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sold out")
    @NotNull(message = "Campaign title is required.")
    private String name;

    @Schema(description = "开始时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Start time is required.")
    private LocalDateTime startTime;

    @Schema(description = "结束时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "End time is required.")
    @Future(message = "End time must be later than now.")
    private LocalDateTime endTime;

    @Schema(description = "备注", example = "biubiubiu")
    private String remark;

    @Schema(description = "条件类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Condition type is required.")
    @InEnum(value = PromotionConditionTypeEnum.class, message = "Condition type must be {value}.")
    private Integer conditionType;

    @Schema(description = "商品范围", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "ProductRange is required.")
    @InEnum(value = PromotionProductScopeEnum.class, message = "ProductRange must be {value}.")
    private Integer productScope;

    @Schema(description = "商品范围编号的数组", example = "[1, 3]")
    private List<Long> productScopeValues;

    /**
     * 优惠规则的数组
     */
    @Valid // 校验下子对象
    private List<Rule> rules;

    @Schema(description = "优惠规则")
    @Data
    public static class Rule {

        @Schema(description = "优惠门槛", requiredMode = Schema.RequiredMode.REQUIRED, example = "100") // 1. 满 N 元，单位：分; 2. 满 N 件
        @Min(value = 1L, message = "Discount threshold must be at least 1.")
        private Integer limit;

        @Schema(description = "优惠价格", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
        @Min(value = 1L, message = "Discount price must be at least 1.")
        private Integer discountPrice;

        @Schema(description = "是否包邮", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
        @NotNull(message = "Rule is free shipping cannot be empty.")
        private Boolean freeDelivery;

        @Schema(description = "赠送的积分", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
        private Integer point;

        @Schema(description = "赠送的优惠劵编号的数组")
        private Map<Long, Integer> giveCouponTemplateCounts;

        @AssertTrue(message = "Bonus points cannot be less than 0.")
        @JsonIgnore
        public boolean isPointValid() {
            return point == null || point >= 0;
        }

    }

    @AssertTrue(message = "ProductRange code Array is required.")
    @JsonIgnore
    public boolean isProductScopeValuesValid() {
        return Objects.equals(productScope, PromotionProductScopeEnum.ALL.getScope()) // AllRange time, can is empty
                || CollUtil.isNotEmpty(productScopeValues);
    }

}
