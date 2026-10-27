package cn.iocoder.yudao.module.trade.controller.admin.delivery.vo.expresstemplate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.validation.Valid;
import java.util.List;

@Schema(description = "Shipping-fee template create request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DeliveryExpressTemplateCreateReqVO extends DeliveryExpressTemplateBaseVO {

    @Schema(description = "Regional shipping-fee list.")
    @Valid
    private List<DeliveryExpressTemplateChargeBaseVO> charges;

    @Schema(description = "Free-shipping region list.")
    @Valid
    private List<DeliveryExpressTemplateFreeBaseVO> frees;

}
