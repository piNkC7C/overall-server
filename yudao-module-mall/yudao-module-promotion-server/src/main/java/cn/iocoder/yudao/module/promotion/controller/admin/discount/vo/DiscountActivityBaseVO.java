package cn.iocoder.yudao.module.promotion.controller.admin.discount.vo;

import cn.hutool.core.util.ObjectUtil;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.promotion.enums.common.PromotionDiscountTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 限时折扣活动 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class DiscountActivityBaseVO {

    @Schema(description = "活动标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "One title.")
    @NotNull(message = "Campaign title is required.")
    private String name;

    @Schema(description = "开始时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Start time is required.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime startTime;

    @Schema(description = "结束时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "End time is required.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime endTime;

    @Schema(description = "备注", example = "Sample notes")
    private String remark;

    @Schema(description = "商品")
    @Data
    public static class Product {

        @Schema(description = "商品 SPU 编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Product SPU code is required.")
        private Long spuId;

        @Schema(description = "商品 SKU 编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Product SKU code is required.")
        private Long skuId;

        @Schema(description = "优惠类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Discount type is required.")
        @InEnum(PromotionDiscountTypeEnum.class)
        private Integer discountType;

        @Schema(description = "折扣百分比", example = "80") // 例如说，80% 为 80
        private Integer discountPercent;

        @Schema(description = "优惠金额", example = "10")
        @Min(value = 0, message = "Discount amount must be greater than or equal to 0.")
        private Integer discountPrice;

        @AssertTrue(message = "Discount percent must be between 0.01% and 99.99%.")
        @JsonIgnore
        public boolean isDiscountPercentValid() {
            return ObjectUtil.notEqual(discountType, PromotionDiscountTypeEnum.PERCENT.getType())
                    || (discountPercent != null && discountPercent >= 1 && discountPercent <= 9999);
        }

        @AssertTrue(message = "Discount amount is required.")
        @JsonIgnore
        public boolean isDiscountPriceValid() {
            return ObjectUtil.notEqual(discountType, PromotionDiscountTypeEnum.PRICE.getType())
                    || discountPrice != null;
        }

    }
}
