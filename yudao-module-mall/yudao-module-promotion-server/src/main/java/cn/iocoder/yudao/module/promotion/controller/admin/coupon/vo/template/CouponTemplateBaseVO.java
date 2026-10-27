package cn.iocoder.yudao.module.promotion.controller.admin.coupon.vo.template;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.promotion.enums.common.PromotionDiscountTypeEnum;
import cn.iocoder.yudao.module.promotion.enums.common.PromotionProductScopeEnum;
import cn.iocoder.yudao.module.promotion.enums.coupon.CouponTemplateValidityTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.TIME_ZONE_DEFAULT;

/**
 * 优惠劵模板 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class CouponTemplateBaseVO {

    @Schema(description = "Coupon name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "New Year sale")
    @NotNull(message = "Coupon name cannot be empty.")
    private String name;

    @Schema(description = "CouponNotes.", example = "Coupon usedNotes.")
    private String description;

    @Schema(description = "Total issued quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024") // -1 - 则表示不限制发放数量
    @NotNull(message = "Total issued quantity cannot be empty.")
    private Integer totalCount;

    @Schema(description = "Claim limit per person.", requiredMode = Schema.RequiredMode.REQUIRED, example = "66") // -1 - 则表示不限制
    @NotNull(message = "Claim limit per person cannot be empty.")
    private Integer takeLimitCount;

    @Schema(description = "Claim Method", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Claim Method is required.")
    private Integer takeType;

    @Schema(description = "Minimum spend required.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100") // 单位：分；0 - 不限制
    @NotNull(message = "Minimum spend required cannot be empty.")
    private Integer usePrice;

    @Schema(description = "ProductRange.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "ProductRange is required.")
    @InEnum(PromotionProductScopeEnum.class)
    private Integer productScope;

    @Schema(description = "ProductRange code Array.", example = "[1, 3]")
    private List<Long> productScopeValues;

    @Schema(description = "Effective Date type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Effective Date type is required.")
    @InEnum(CouponTemplateValidityTypeEnum.class)
    private Integer validityType;

    @Schema(description = "Fixed date - effective start.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND, timezone = TIME_ZONE_DEFAULT)
    private LocalDateTime validStartTime;

    @Schema(description = "Fixed date - effective end.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND, timezone = TIME_ZONE_DEFAULT)
    private LocalDateTime validEndTime;

    @Schema(description = "ClaimDate - Start day count.")
    @Min(value = 0L, message = "Start day count must be greater than 0.")
    private Integer fixedStartTerm;

    @Schema(description = "Claim window end day.")
    @Min(value = 1L, message = "Start day count must be greater than 1.")
    private Integer fixedEndTerm;

    @Schema(description = "Discount type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Discount type is required.")
    @InEnum(PromotionDiscountTypeEnum.class)
    private Integer discountType;

    @Schema(description = "Discount percent.", example = "80") //  例如说，80% 为 80
    private Integer discountPercent;

    @Schema(description = "Discount amount.", example = "10")
    @Min(value = 0, message = "Discount amount must be greater than or equal to 0.")
    private Integer discountPrice;

    @Schema(description = "Discount limit.", example = "100") // 单位：分，仅在 discountType 为 PERCENT 使用
    private Integer discountLimitPrice;

    @AssertTrue(message = "ProductRange code Array is required.")
    @JsonIgnore
    public boolean isProductScopeValuesValid() {
        return Objects.equals(productScope, PromotionProductScopeEnum.ALL.getScope()) // AllRange time, can is empty
                || CollUtil.isNotEmpty(productScopeValues);
    }

    @AssertTrue(message = "Effective start time cannot be empty.")
    @JsonIgnore
    public boolean isValidStartTimeValid() {
        return ObjectUtil.notEqual(validityType, CouponTemplateValidityTypeEnum.DATE.getType())
                || validStartTime != null;
    }

    @AssertTrue(message = "Effective end time cannot be empty.")
    @JsonIgnore
    public boolean isValidEndTimeValid() {
        return ObjectUtil.notEqual(validityType, CouponTemplateValidityTypeEnum.DATE.getType())
                || validEndTime != null;
    }

    @AssertTrue(message = "Start days is required.")
    @JsonIgnore
    public boolean isFixedStartTermValid() {
        return ObjectUtil.notEqual(validityType, CouponTemplateValidityTypeEnum.TERM.getType())
                || fixedStartTerm != null;
    }

    @AssertTrue(message = "End days is required.")
    @JsonIgnore
    public boolean isFixedEndTermValid() {
        return ObjectUtil.notEqual(validityType, CouponTemplateValidityTypeEnum.TERM.getType())
                || fixedEndTerm != null;
    }

    @AssertTrue(message = "Discount percent must be between 1 and 99.")
    @JsonIgnore
    public boolean isDiscountPercentValid() {
        return ObjectUtil.notEqual(discountType, PromotionDiscountTypeEnum.PERCENT.getType())
                || (discountPercent != null && discountPercent >= 1 && discountPercent<= 99);
    }

    @AssertTrue(message = "Discount amount is required.")
    @JsonIgnore
    public boolean isDiscountPriceValid() {
        return ObjectUtil.notEqual(discountType, PromotionDiscountTypeEnum.PRICE.getType())
                || discountPrice != null;
    }

    @AssertTrue(message = "Discount limit is required.")
    @JsonIgnore
    public boolean isDiscountLimitPriceValid() {
        return ObjectUtil.notEqual(discountType, PromotionDiscountTypeEnum.PERCENT.getType())
                || discountLimitPrice != null;
    }

}
