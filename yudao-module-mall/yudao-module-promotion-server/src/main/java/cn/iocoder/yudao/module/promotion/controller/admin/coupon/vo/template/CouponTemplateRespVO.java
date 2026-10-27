package cn.iocoder.yudao.module.promotion.controller.admin.coupon.vo.template;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "Admin - coupontemplate response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CouponTemplateRespVO extends CouponTemplateBaseVO {

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "Coupon claim quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer takeCount;

    @Schema(description = "Coupon use count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Integer useCount;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
