package cn.iocoder.yudao.module.mes.controller.admin.wm.outsourceissue.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES subcontract issue order detail create / edit request.")
@Data
public class MesWmOutsourceIssueDetailSaveReqVO {

    @Schema(description = "DetailID.", example = "1024")
    private Long id;

    @Schema(description = "Line ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Line ID is required.")
    private Long lineId;

    @Schema(description = "Issue materials order ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Issue materials order ID is required.")
    private Long issueId;

    @Schema(description = "Material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material ID is required.")
    private Long itemId;

    @Schema(description = "InventoryID.", example = "1")
    private Long materialStockId;

    @Schema(description = "Quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "300.00")
    @NotNull(message = "Quantity is required.")
    @DecimalMin(value = "0.01", message = "Quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "LotID.", example = "1")
    private Long batchId;

    @Schema(description = "WarehouseID.", example = "1")
    private Long warehouseId;

    @Schema(description = "Zone ID.", example = "1")
    private Long locationId;

    @Schema(description = "BinID.", example = "1")
    private Long areaId;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
