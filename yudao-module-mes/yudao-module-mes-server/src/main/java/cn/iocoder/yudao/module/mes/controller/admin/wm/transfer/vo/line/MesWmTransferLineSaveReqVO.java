package cn.iocoder.yudao.module.mes.controller.admin.wm.transfer.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES transfer order line Save request.")
@Data
public class MesWmTransferLineSaveReqVO {

    @Schema(description = "Code.", example = "1")
    private Long id;

    @Schema(description = "Transfer order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Transfer order code is required.")
    private Long transferId;

    @Schema(description = "Inventoryrecord code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inventoryrecord code is required.")
    private Long materialStockId;

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material code is required.")
    private Long itemId;

    @Schema(description = "Transfer quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Transfer quantity is required.")
    @DecimalMin(value = "0.01", message = "Transfer quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "Lot code.", example = "1")
    private Long batchId;

    @Schema(description = "Remove warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Remove warehouse code is required.")
    private Long fromWarehouseId;

    @Schema(description = "Remove zone code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Remove zone code is required.")
    private Long fromLocationId;

    @Schema(description = "Remove bin code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Remove bin code is required.")
    private Long fromAreaId;

    @Schema(description = "Notes.", example = "Notes info.")
    private String remark;

}
