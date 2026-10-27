package cn.iocoder.yudao.module.mes.controller.admin.wm.returnvendor.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES supplierreturn order line Save request.")
@Data
public class MesWmReturnVendorLineSaveReqVO {

    @Schema(description = "Line ID.", example = "1")
    private Long id;

    @Schema(description = "Return orderID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Return orderID is required.")
    private Long returnId;

    @Schema(description = "Material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material ID is required.")
    private Long itemId;

    @Schema(description = "Return quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Return quantity is required.")
    @DecimalMin(value = "0", inclusive = false, message = "Return quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "LotID.", example = "1")
    private Long batchId;

    @Schema(description = "Lot no.", example = "BATCH20260101001")
    private String batchCode;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
