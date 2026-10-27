package cn.iocoder.yudao.module.trade.controller.admin.delivery.vo.expresstemplate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "Shipping-fee template response VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DeliveryExpressTemplateRespVO extends DeliveryExpressTemplateBaseVO {

    @Schema(description = "Auto-increment ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "371")
    private Long id;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
