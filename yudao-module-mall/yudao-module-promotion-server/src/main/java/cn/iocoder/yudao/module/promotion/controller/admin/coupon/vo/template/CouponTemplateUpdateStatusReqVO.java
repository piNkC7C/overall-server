package cn.iocoder.yudao.module.promotion.controller.admin.coupon.vo.template;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - coupontemplateupdate status request.")
@Data
public class CouponTemplateUpdateStatusReqVO {

    @Schema(description = "Coupontemplate code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Coupontemplate code is required.")
    private Long id;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    @InEnum(value = CommonStatusEnum.class, message = "Edit status must be {value}.")
    private Integer status;

}
