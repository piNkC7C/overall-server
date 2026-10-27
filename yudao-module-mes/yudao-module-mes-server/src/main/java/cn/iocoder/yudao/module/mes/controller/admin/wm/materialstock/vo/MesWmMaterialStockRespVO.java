package cn.iocoder.yudao.module.mes.controller.admin.wm.materialstock.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES inventory ledger response.")
@Data
@ExcelIgnoreUnannotated
public class MesWmMaterialStockRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Material category code.", example = "1")
    private Long itemTypeId;

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long itemId;

    @Schema(description = "Material code.", example = "M001")
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

    @Schema(description = "Lot code.", example = "1")
    private Long batchId;

    @Schema(description = "Lot no.", example = "B20260101")
    @ExcelProperty("Lot No")
    private String batchCode;

    @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long warehouseId;

    @Schema(description = "Warehouse code.", example = "WH001")
    private String warehouseCode;

    @Schema(description = "Warehouse name.", example = "Raw Materials.")
    @ExcelProperty("Warehouse")
    private String warehouseName;

    @Schema(description = "Zone code.", example = "1")
    private Long locationId;

    @Schema(description = "Zone name.", example = "Zone A")
    @ExcelProperty("Zone")
    private String locationName;

    @Schema(description = "Bin code.", example = "1")
    private Long areaId;

    @Schema(description = "Bin name.", example = "A-01")
    @ExcelProperty("Bin")
    private String areaName;

    @Schema(description = "Supplier code.", example = "1")
    private Long vendorId;

    @Schema(description = "Supplier name.", example = "A supplier.")
    @ExcelProperty("Supplier")
    private String vendorName;

    @Schema(description = "On-hand Qty", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.0000")
    @ExcelProperty("On-hand Quantity")
    private BigDecimal quantity;

    @Schema(description = "Inbound time.")
    @ExcelProperty("Inbound Time")
    private LocalDateTime receiptTime;

    @Schema(description = "Is not freeze.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @ExcelProperty("Frozen")
    private Boolean frozen;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
