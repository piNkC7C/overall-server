package cn.iocoder.yudao.module.promotion.controller.app.coupon.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "User App - coupontemplate response.")
@Data
public class AppCouponTemplateRespVO {

    @Schema(description = "Coupontemplate code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Coupon name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "New Year sale")
    private String name;

    @Schema(description = "CouponNotes.", example = "Coupon usedNotes.")
    private String description;

    @Schema(description = "Total issued quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024") // -1 - 则表示不限制发放数量
    private Integer totalCount;

    @Schema(description = "Claim limit per person.", requiredMode = Schema.RequiredMode.REQUIRED, example = "66") // -1 - 则表示不限制
    private Integer takeLimitCount;

    @Schema(description = "Minimum spend required.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100") // 单位：分；0 - 不限制
    private Integer usePrice;

    @Schema(description = "ProductRange.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer productScope;

    @Schema(description = "ProductRange code Array.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private List<Long> productScopeValues;

    @Schema(description = "Effective Date type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer validityType;

    @Schema(description = "Fixed date - effective start.")
    private LocalDateTime validStartTime;

    @Schema(description = "Fixed date - effective end.")
    private LocalDateTime validEndTime;

    @Schema(description = "ClaimDate - Start day count.")
    @Min(value = 0L, message = "Start day count must be greater than 0.")
    private Integer fixedStartTerm;

    @Schema(description = "Claim window end day.")
    @Min(value = 1L, message = "Start day count must be greater than 1.")
    private Integer fixedEndTerm;

    @Schema(description = "Discount type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer discountType;

    @Schema(description = "Discount percent.", example = "80") //  例如说，80% 为 80
    private Integer discountPercent;

    @Schema(description = "Discount amount.", example = "10")
    @Min(value = 0, message = "Discount amount must be greater than or equal to 0.")
    private Integer discountPrice;

    @Schema(description = "Discount limit.", example = "100") // 单位：分，仅在 discountType 为 PERCENT 使用
    private Integer discountLimitPrice;

    @Schema(description = "Coupon claim quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer takeCount;

    // ========== 用户相关字段 ==========

    @Schema(description = "Can claim.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean canTake;

}
