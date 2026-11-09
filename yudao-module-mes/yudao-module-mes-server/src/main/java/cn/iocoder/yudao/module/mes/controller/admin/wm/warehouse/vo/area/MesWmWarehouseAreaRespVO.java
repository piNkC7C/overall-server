package cn.iocoder.yudao.module.mes.controller.admin.wm.warehouse.vo.area;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 库位 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesWmWarehouseAreaRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "库位编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "A001")
    @ExcelProperty("Bin Code")
    private String code;

    @Schema(description = "库位名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Default bin.")
    @ExcelProperty("Bin Name")
    private String name;

    @Schema(description = "库区编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long locationId;

    @Schema(description = "库区名称", example = "Raw-material zone")
    @ExcelProperty("Zone Name")
    private String locationName;

    @Schema(description = "仓库编号", example = "1")
    private Long warehouseId;

    @Schema(description = "仓库名称", example = "Raw Materials.")
    @ExcelProperty("Warehouse Name")
    private String warehouseName;

    @Schema(description = "面积", example = "20.00")
    @ExcelProperty("Area")
    private BigDecimal area;

    @Schema(description = "最大载重", example = "1000.00")
    @ExcelProperty("Max Load")
    private BigDecimal maxLoad;

    @Schema(description = "位置 X", example = "1")
    @ExcelProperty("Position X")
    private Integer positionX;

    @Schema(description = "位置 Y", example = "1")
    @ExcelProperty("Position Y")
    private Integer positionY;

    @Schema(description = "位置 Z", example = "1")
    @ExcelProperty("Position Z")
    private Integer positionZ;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Status")
    private Integer status;

    @Schema(description = "是否冻结", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @ExcelProperty("Frozen")
    private Boolean frozen;

    @Schema(description = "是否允许物料混放", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @ExcelProperty("Allow Mixed Materials")
    private Boolean allowItemMixing;

    @Schema(description = "是否允许批次混放", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @ExcelProperty("Allow Mixed Lots")
    private Boolean allowBatchMixing;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
