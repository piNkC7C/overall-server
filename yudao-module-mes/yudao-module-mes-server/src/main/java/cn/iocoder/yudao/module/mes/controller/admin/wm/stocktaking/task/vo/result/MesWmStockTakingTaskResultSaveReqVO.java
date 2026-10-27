package cn.iocoder.yudao.module.mes.controller.admin.wm.stocktaking.task.vo.result;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES stocktake result create / edit request.")
@Data
public class MesWmStockTakingTaskResultSaveReqVO {

    @Schema(description = "Code.", example = "1")
    private Long id;

    @Schema(description = "Task ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Task ID is required.")
    private Long taskId;

    @Schema(description = "Task line ID.", example = "1")
    private Long lineId;

    @Schema(description = "Inventory ledger ID.", example = "1")
    private Long materialStockId;

    @Schema(description = "Material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material ID is required.")
    private Long itemId;

    @Schema(description = "Lot ID.", example = "1")
    private Long batchId;

    @Schema(description = "Lot code.", example = "B202603080001")
    private String batchCode;

    @Schema(description = "Warehouse ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Warehouse ID is required.")
    private Long warehouseId;

    @Schema(description = "Zone ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Zone ID is required.")
    private Long locationId;

    @Schema(description = "Bin ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Bin ID is required.")
    private Long areaId;

    @Schema(description = "Stocktake quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.000000")
    @NotNull(message = "Stocktake quantity is required.")
    private BigDecimal takingQuantity;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
