package cn.iocoder.yudao.module.promotion.controller.app.coupon.vo.coupon;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "User App - coupon response.")
@Data
public class AppCouponRespVO {

    @Schema(description = "Coupon code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Coupon name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "New Year sale")
    private String name;

    @Schema(description = "Coupon status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1") // See CouponStatusEnum enum
    private Integer status;

    @Schema(description = "Minimum spend required.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100") // 单位：分；0 - 不限制
    private Integer usePrice;

    @Schema(description = "ProductRange.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer productScope;

    @Schema(description = "ProductRange code Array.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private List<Long> productScopeValues;

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

}
