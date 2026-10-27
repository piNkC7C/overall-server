package cn.iocoder.yudao.module.promotion.controller.admin.coupon.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - coupontemplateupdate request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CouponTemplateUpdateReqVO extends CouponTemplateBaseVO {

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Template code is required.")
    private Long id;

}
