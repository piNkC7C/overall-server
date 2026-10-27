package cn.iocoder.yudao.module.promotion.controller.admin.coupon.vo.template;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.promotion.enums.common.PromotionProductScopeEnum;
import cn.iocoder.yudao.module.promotion.enums.coupon.CouponTakeTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - coupontemplate page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CouponTemplatePageReqVO extends PageParam {

    @Schema(description = "Coupon name.", example = "Hello")
    private String name;

    @Schema(description = "Status.", example = "1")
    private Integer status;

    @Schema(description = "Discount type.", example = "1")
    private Integer discountType;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "Claimable type.", example = "[1, 2, 3]")
    @InEnum(value = CouponTakeTypeEnum.class, message = "Claimable type must be {value}.")
    private List<Integer> canTakeTypes;

    @Schema(description = "ProductRange.", example = "1")
    @InEnum(value = PromotionProductScopeEnum.class, message = "ProductRange, must be {value}.")
    private Integer productScope;

    @Schema(description = "ProductRange code.", example = "1")
    private Long productScopeValue;

}
