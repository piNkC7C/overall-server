package cn.iocoder.yudao.module.promotion.controller.admin.coupon.vo.coupon;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.promotion.enums.common.PromotionDiscountTypeEnum;
import cn.iocoder.yudao.module.promotion.enums.common.PromotionProductScopeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.TIME_ZONE_DEFAULT;

/**
* 优惠劵 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class CouponBaseVO {

    // ========== Basic Info BEGIN ==========
    @Schema(description = "优惠劵模板编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Coupontemplate code is required.")
    private Long templateId;

    @Schema(description = "优惠劵名", requiredMode = Schema.RequiredMode.REQUIRED, example = "New Year sale")
    @NotNull(message = "Coupon name cannot be empty.")
    private String name;

    @Schema(description = "优惠码状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    // ========== Basic Info END ==========

    // ========== 领取情况 BEGIN ==========
    @Schema(description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "User ID is required.")
    private Long userId;

    @Schema(description = "领取方式", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Claim Method is required.")
    private Integer takeType;
    // ========== 领取情况 END ==========

    // ========== used rule BEGIN ==========
    @Schema(description = "是否设置满多少金额可用", requiredMode = Schema.RequiredMode.REQUIRED, example = "100") // 单位：分；0 - 不限制
    @NotNull(message = "Minimum spend required cannot be empty.")
    private Integer usePrice;

    @Schema(description = "固定日期 - 生效开始时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND, timezone = TIME_ZONE_DEFAULT)
    private LocalDateTime validStartTime;

    @Schema(description = "固定日期 - 生效结束时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND, timezone = TIME_ZONE_DEFAULT)
    private LocalDateTime validEndTime;

    @Schema(description = "商品范围", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "ProductRange is required.")
    @InEnum(PromotionProductScopeEnum.class)
    private Integer productScope;

    @Schema(description = "商品范围编号的数组", example = "1,3")
    private List<Long> productScopeValues;
    // ========== used rule END ==========

    // ========== 使用效果 BEGIN ==========
    @Schema(description = "优惠类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Discount type is required.")
    @InEnum(PromotionDiscountTypeEnum.class)
    private Integer discountType;

    @Schema(description = "折扣百分比", example = "80") // 例如说，80% 为 80
    private Integer discountPercent;

    @Schema(description = "优惠金额", example = "10")
    @Min(value = 0, message = "Discount amount must be greater than or equal to 0.")
    private Integer discountPrice;

    @Schema(description = "折扣上限", example = "100") // 单位：分，仅在 discountType 为 PERCENT 使用
    private Integer discountLimitPrice;
    // ========== 使用效果 END ==========

    // ========== 使用情况 BEGIN ==========

    @Schema(description = "使用订单号", example = "4096")
    private Long useOrderId;

    @Schema(description = "使用时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND, timezone = TIME_ZONE_DEFAULT)
    private LocalDateTime useTime;

    // ========== 使用情况 END ==========

}
