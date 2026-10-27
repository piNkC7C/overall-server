package cn.iocoder.yudao.module.mes.controller.admin.wm.warehouse.vo.location;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES zone response.")
@Data
@ExcelIgnoreUnannotated
public class MesWmWarehouseLocationRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Zone code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "L001")
    @ExcelProperty("Zone Code")
    private String code;

    @Schema(description = "Zone name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Raw-material zone")
    @ExcelProperty("Zone Name")
    private String name;

    @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long warehouseId;

    @Schema(description = "Warehouse name.", example = "Raw Materials.")
    @ExcelProperty("Warehouse Name")
    private String warehouseName;

    @Schema(description = "Area", example = "500.00")
    @ExcelProperty("Area")
    private BigDecimal area;

    @Schema(description = "Is not freeze.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @ExcelProperty("Frozen")
    private Boolean frozen;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
