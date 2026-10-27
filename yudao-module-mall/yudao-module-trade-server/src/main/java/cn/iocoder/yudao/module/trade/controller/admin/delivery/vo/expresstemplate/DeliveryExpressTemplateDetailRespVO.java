package cn.iocoder.yudao.module.trade.controller.admin.delivery.vo.expresstemplate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Schema(description = "Shipping-fee template detail response VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DeliveryExpressTemplateDetailRespVO extends DeliveryExpressTemplateBaseVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "371")
    private Long id;

    @Schema(description = "Shipping-template fee setting.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<DeliveryExpressTemplateChargeBaseVO> charges;

    @Schema(description = "Shipping-template free-shipping regions.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<DeliveryExpressTemplateFreeBaseVO> frees;

}
