package cn.iocoder.yudao.module.mes.controller.admin.wm.stocktaking.task.vo.result;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - MES 盘点结果新增/修改 Request VO")
@Data
public class MesWmStockTakingTaskResultSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @Schema(description = "任务 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Task ID is required.")
    private Long taskId;

    @Schema(description = "任务行 ID", example = "1")
    private Long lineId;

    @Schema(description = "库存台账 ID", example = "1")
    private Long materialStockId;

    @Schema(description = "物料 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material ID is required.")
    private Long itemId;

    @Schema(description = "批次 ID", example = "1")
    private Long batchId;

    @Schema(description = "批次编码", example = "B202603080001")
    private String batchCode;

    @Schema(description = "仓库 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Warehouse ID is required.")
    private Long warehouseId;

    @Schema(description = "库区 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Zone ID is required.")
    private Long locationId;

    @Schema(description = "库位 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Bin ID is required.")
    private Long areaId;

    @Schema(description = "盘点数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.000000")
    @NotNull(message = "Stocktake quantity is required.")
    private BigDecimal takingQuantity;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}
