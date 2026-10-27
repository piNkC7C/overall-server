package cn.iocoder.yudao.module.promotion.controller.app.coupon.vo.template;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.promotion.enums.common.PromotionProductScopeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "User App - coupontemplate page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppCouponTemplatePageReqVO extends PageParam {

    @Schema(description = "ProductRange.", example = "1")
    @InEnum(value = PromotionProductScopeEnum.class, message = "ProductRange, must be {value}.")
    private Integer productScope;

    @Schema(description = "Product label.", example = "1")
    private Long spuId;

}
