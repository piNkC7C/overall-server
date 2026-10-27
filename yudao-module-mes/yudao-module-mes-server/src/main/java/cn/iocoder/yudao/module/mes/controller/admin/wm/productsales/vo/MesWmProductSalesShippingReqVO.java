package cn.iocoder.yudao.module.mes.controller.admin.wm.productsales.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Fill sales-shipment waybill request VO.")
@Data
public class MesWmProductSalesShippingReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Code is required.")
    private Long id;

    @Schema(description = "Carrier", example = "SF Express")
    private String carrier;

    @Schema(description = "Tracking No.", example = "SF1234567890")
    private String shippingNumber;

}
