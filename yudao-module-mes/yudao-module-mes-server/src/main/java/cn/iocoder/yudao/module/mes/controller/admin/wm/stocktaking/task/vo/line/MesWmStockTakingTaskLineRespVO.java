package cn.iocoder.yudao.module.mes.controller.admin.wm.stocktaking.task.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES stocktake task line response.")
@Data
public class MesWmStockTakingTaskLineRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Task ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long taskId;

    @Schema(description = "Inventory ledger ID.", example = "1")
    private Long materialStockId;

    @Schema(description = "Material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long itemId;

    @Schema(description = "Material code.", example = "ITEM001")
    private String itemCode;

    @Schema(description = "Material name.", example = "Steel plate.")
    private String itemName;

    @Schema(description = "Spec / Model", example = "10mm*100mm")
    private String specification;

    @Schema(description = "Unit of measure name.", example = "Kg.")
    private String unitMeasureName;

    @Schema(description = "Lot ID.", example = "1")
    private Long batchId;

    @Schema(description = "Lot code.", example = "B202603080001")
    private String batchCode;

    @Schema(description = "Book quantity.", example = "100.000000")
    private BigDecimal quantity;

    @Schema(description = "Counted quantity.", example = "98.000000")
    private BigDecimal takingQuantity;

    @Schema(description = "Variance quantity.", example = "-2.000000")
    private BigDecimal differenceQuantity;

    @Schema(description = "Warehouse ID.", example = "1")
    private Long warehouseId;

    @Schema(description = "Warehouse name.", example = "Raw Materials.")
    private String warehouseName;

    @Schema(description = "Zone ID.", example = "1")
    private Long locationId;

    @Schema(description = "Zone name.", example = "Zone A")
    private String locationName;

    @Schema(description = "Bin ID.", example = "1")
    private Long areaId;

    @Schema(description = "Bin name.", example = "A-01")
    private String areaName;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
