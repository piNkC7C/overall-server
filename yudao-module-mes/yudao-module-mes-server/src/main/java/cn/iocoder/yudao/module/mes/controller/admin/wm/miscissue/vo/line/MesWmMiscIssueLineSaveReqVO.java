package cn.iocoder.yudao.module.mes.controller.admin.wm.miscissue.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES miscellaneous outbound order line create / edit request.")
@Data
public class MesWmMiscIssueLineSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Outbound order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Outbound order code is required.")
    private Long issueId;

    @Schema(description = "Source document line ID.", example = "1")
    private Long sourceDocLineId;

    @Schema(description = "InventoryrecordID.", example = "1")
    private Long materialStockId;

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material code is required.")
    private Long itemId;

    @Schema(description = "Outbound quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Outbound quantity is required.")
    @DecimalMin(value = "0.01", message = "Outbound quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "Lot code.", example = "1")
    private Long batchId;

    @Schema(description = "Lot no.", example = "BATCH20260301")
    private String batchCode;

    @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Warehouse is required.")
    private Long warehouseId;

    @Schema(description = "Zone code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Zone is required.")
    private Long locationId;

    @Schema(description = "Bin code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Bin is required.")
    private Long areaId;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
