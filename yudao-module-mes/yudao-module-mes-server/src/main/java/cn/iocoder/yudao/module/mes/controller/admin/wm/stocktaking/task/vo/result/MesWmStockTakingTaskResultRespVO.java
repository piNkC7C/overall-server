package cn.iocoder.yudao.module.mes.controller.admin.wm.stocktaking.task.vo.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES stocktake result response.")
@Data
@ExcelIgnoreUnannotated
public class MesWmStockTakingTaskResultRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Task ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long taskId;

    @Schema(description = "Task line ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long lineId;

    @Schema(description = "Inventory ledger ID.", example = "1")
    private Long materialStockId;

    @Schema(description = "Material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long itemId;

    @Schema(description = "Material code.", example = "ITEM001")
    @ExcelProperty("Material Code")
    private String itemCode;

    @Schema(description = "Material name.", example = "Steel plate.")
    @ExcelProperty("Material Name")
    private String itemName;

    @Schema(description = "Spec / Model", example = "10mm*100mm")
    @ExcelProperty("Spec / Model")
    private String specification;

    @Schema(description = "Unit of measure name.", example = "Kg.")
    @ExcelProperty("Unit Of Measure")
    private String unitMeasureName;

    @Schema(description = "Lot ID.", example = "1")
    private Long batchId;

    @Schema(description = "Lot code.", example = "B202603080001")
    @ExcelProperty("Lot Code")
    private String batchCode;

    @Schema(description = "Warehouse ID.", example = "1")
    private Long warehouseId;

    @Schema(description = "Warehouse name.", example = "Raw Materials.")
    @ExcelProperty("Warehouse")
    private String warehouseName;

    @Schema(description = "Zone ID.", example = "1")
    private Long locationId;

    @Schema(description = "Zone name.", example = "Zone A")
    @ExcelProperty("Zone")
    private String locationName;

    @Schema(description = "Bin ID.", example = "1")
    private Long areaId;

    @Schema(description = "Bin name.", example = "A-01")
    @ExcelProperty("Bin")
    private String areaName;

    @Schema(description = "Book quantity.", example = "100.000000")
    @ExcelProperty("Book Quantity")
    private BigDecimal quantity;

    @Schema(description = "Counted quantity.", example = "98.000000")
    @ExcelProperty("Counted Quantity")
    private BigDecimal takingQuantity;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

}
