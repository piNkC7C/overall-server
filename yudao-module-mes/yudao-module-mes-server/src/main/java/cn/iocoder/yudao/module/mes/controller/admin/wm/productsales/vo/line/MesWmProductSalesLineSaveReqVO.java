package cn.iocoder.yudao.module.mes.controller.admin.wm.productsales.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES sales shipment line create / edit request.")
@Data
public class MesWmProductSalesLineSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Outbound orderID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Outbound orderID is required.")
    private Long salesId;

    @Schema(description = "Shipping notification order line ID.", example = "1")
    private Long noticeLineId;

    @Schema(description = "Material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material is required.")
    private Long itemId;

    @Schema(description = "Outbound quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Outbound quantity is required.")
    private BigDecimal quantity;

    @Schema(description = "LotID.", example = "1")
    private Long batchId;

    @Schema(description = "Lot no.", example = "B20260301001")
    private String batchCode;

    @Schema(description = "Outgoing factory inspection.", example = "true")
    private Boolean oqcCheckFlag;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
