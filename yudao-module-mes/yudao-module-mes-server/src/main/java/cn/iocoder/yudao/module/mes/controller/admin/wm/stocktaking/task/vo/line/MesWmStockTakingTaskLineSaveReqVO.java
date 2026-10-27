package cn.iocoder.yudao.module.mes.controller.admin.wm.stocktaking.task.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - stocktake task line create / edit request.")
@Data
public class MesWmStockTakingTaskLineSaveReqVO {

    @Schema(description = "Code.", example = "1")
    private Long id;

    @Schema(description = "Stocktake task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Stocktake task code is required.")
    private Long taskId;

    @Schema(description = "Inventoryrecord code.", example = "1")
    private Long materialStockId;

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material code is required.")
    private Long itemId;

    @Schema(description = "Lot code.", example = "1")
    private Long batchId;

    @Schema(description = "Book quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Book quantity cannot be empty.")
    private BigDecimal quantity;

    @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Warehouse code is required.")
    private Long warehouseId;

    @Schema(description = "Zone code.", example = "1")
    private Long locationId;

    @Schema(description = "Bin code.", example = "1")
    private Long areaId;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
