package cn.iocoder.yudao.module.mes.controller.admin.wm.warehouse.vo.area;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES bin response.")
@Data
@ExcelIgnoreUnannotated
public class MesWmWarehouseAreaRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Bin code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "A001")
    @ExcelProperty("Bin Code")
    private String code;

    @Schema(description = "Bin name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Default bin.")
    @ExcelProperty("Bin Name")
    private String name;

    @Schema(description = "Zone code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long locationId;

    @Schema(description = "Zone name.", example = "Raw-material zone")
    @ExcelProperty("Zone Name")
    private String locationName;

    @Schema(description = "Warehouse code.", example = "1")
    private Long warehouseId;

    @Schema(description = "Warehouse name.", example = "Raw Materials.")
    @ExcelProperty("Warehouse Name")
    private String warehouseName;

    @Schema(description = "Area", example = "20.00")
    @ExcelProperty("Area")
    private BigDecimal area;

    @Schema(description = "Maximum load.", example = "1000.00")
    @ExcelProperty("Max Load")
    private BigDecimal maxLoad;

    @Schema(description = "Location X.", example = "1")
    @ExcelProperty("Position X")
    private Integer positionX;

    @Schema(description = "Location Y.", example = "1")
    @ExcelProperty("Position Y")
    private Integer positionY;

    @Schema(description = "Location Z.", example = "1")
    @ExcelProperty("Position Z")
    private Integer positionZ;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Status")
    private Integer status;

    @Schema(description = "Is not freeze.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @ExcelProperty("Frozen")
    private Boolean frozen;

    @Schema(description = "Allow mixed materials.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @ExcelProperty("Allow Mixed Materials")
    private Boolean allowItemMixing;

    @Schema(description = "Allow mixed lots.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @ExcelProperty("Allow Mixed Lots")
    private Boolean allowBatchMixing;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
