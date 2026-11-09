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

    @Schema(description = "优惠劵名", requiredMode = Schema.RequiredMode.REQUIRED, example = "New Year sale")
    @NotNull(message = "Coupon name cannot be empty.")
    private String name;

    @Schema(description = "优惠券说明", example = "Coupon usedNotes.")
    private String description;

    @Schema(description = "发行总量", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024") // -1 - 则表示不限制发放数量
    @NotNull(message = "Total issued quantity cannot be empty.")
    private Integer totalCount;

    @Schema(description = "每人限领个数", requiredMode = Schema.RequiredMode.REQUIRED, example = "66") // -1 - 则表示不限制
    @NotNull(message = "Claim limit per person cannot be empty.")
    private Integer takeLimitCount;

    @Schema(description = "领取方式", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Claim Method is required.")
    private Integer takeType;

    @Schema(description = "是否设置满多少金额可用", requiredMode = Schema.RequiredMode.REQUIRED, example = "100") // 单位：分；0 - 不限制
    @NotNull(message = "Minimum spend required cannot be empty.")
    private Integer usePrice;

    @Schema(description = "商品范围", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "ProductRange is required.")
    @InEnum(PromotionProductScopeEnum.class)
    private Integer productScope;

    @Schema(description = "商品范围编号的数组", example = "[1, 3]")
    private List<Long> productScopeValues;

    @Schema(description = "生效日期类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Effective Date type is required.")
    @InEnum(CouponTemplateValidityTypeEnum.class)
    private Integer validityType;

    @Schema(description = "固定日期 - 生效开始时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND, timezone = TIME_ZONE_DEFAULT)
    private LocalDateTime validStartTime;

    @Schema(description = "固定日期 - 生效结束时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND, timezone = TIME_ZONE_DEFAULT)
    private LocalDateTime validEndTime;

    @Schema(description = "领取日期 - 开始天数")
    @Min(value = 0L, message = "Start day count must be greater than 0.")
    private Integer fixedStartTerm;

    @Schema(description = "领取日期 - 结束天数")
    @Min(value = 1L, message = "Start day count must be greater than 1.")
    private Integer fixedEndTerm;

    @Schema(description = "优惠类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Discount type is required.")
    @InEnum(PromotionDiscountTypeEnum.class)
    private Integer discountType;

    @Schema(description = "折扣百分比", example = "80") //  例如说，80% 为 80
    private Integer discountPercent;

    @Schema(description = "优惠金额", example = "10")
    @Min(value = 0, message = "Discount amount must be greater than or equal to 0.")
    private Integer discountPrice;

    @Schema(description = "折扣上限", example = "100") // 单位：分，仅在 discountType 为 PERCENT 使用
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
