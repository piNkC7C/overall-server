package cn.iocoder.yudao.module.mes.controller.admin.wm.materialstock.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 库存台账 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesWmMaterialStockRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "物料分类编号", example = "1")
    private Long itemTypeId;

    @Schema(description = "物料编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long itemId;

    @Schema(description = "物料编码", example = "M001")
    @ExcelProperty("Material Code")
    private String itemCode;

    @Schema(description = "物料名称", example = "Steel plate.")
    @ExcelProperty("Material Name")
    private String itemName;

    @Schema(description = "规格型号", example = "10mm*100mm")
    @ExcelProperty("Spec / Model")
    private String specification;

    @Schema(description = "计量单位名称", example = "Kg.")
    @ExcelProperty("Unit Of Measure")
    private String unitMeasureName;

    @Schema(description = "批次编号", example = "1")
    private Long batchId;

    @Schema(description = "批次号", example = "B20260101")
    @ExcelProperty("Lot No")
    private String batchCode;

    @Schema(description = "仓库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long warehouseId;

    @Schema(description = "仓库编码", example = "WH001")
    private String warehouseCode;

    @Schema(description = "仓库名称", example = "Raw Materials.")
    @ExcelProperty("Warehouse")
    private String warehouseName;

    @Schema(description = "库区编号", example = "1")
    private Long locationId;

    @Schema(description = "库区名称", example = "Zone A")
    @ExcelProperty("Zone")
    private String locationName;

    @Schema(description = "库位编号", example = "1")
    private Long areaId;

    @Schema(description = "库位名称", example = "A-01")
    @ExcelProperty("Bin")
    private String areaName;

    @Schema(description = "供应商编号", example = "1")
    private Long vendorId;

    @Schema(description = "供应商名称", example = "A supplier.")
    @ExcelProperty("Supplier")
    private String vendorName;

    @Schema(description = "在库数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.0000")
    @ExcelProperty("On-hand Quantity")
    private BigDecimal quantity;

    @Schema(description = "入库时间")
    @ExcelProperty("Inbound Time")
    private LocalDateTime receiptTime;

    @Schema(description = "是否冻结", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @ExcelProperty("Frozen")
    private Boolean frozen;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
