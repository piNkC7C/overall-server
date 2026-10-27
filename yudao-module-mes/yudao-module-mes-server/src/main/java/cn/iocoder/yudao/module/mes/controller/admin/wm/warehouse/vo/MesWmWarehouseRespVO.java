package cn.iocoder.yudao.module.mes.controller.admin.wm.warehouse.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES warehouse response.")
@Data
@ExcelIgnoreUnannotated
public class MesWmWarehouseRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "WH001")
    @ExcelProperty("Warehouse Code")
    private String code;

    @Schema(description = "Warehouse name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Raw Materials.")
    @ExcelProperty("Warehouse Name")
    private String name;

    @Schema(description = "WarehouseAddress.", example = "Building 1, Zone A")
    @ExcelProperty("Warehouse Address")
    private String address;

    @Schema(description = "Area", example = "1200.50")
    @ExcelProperty("Area")
    private BigDecimal area;

    @Schema(description = "Owner person user ID.", example = "1")
    private Long chargeUserId;

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
