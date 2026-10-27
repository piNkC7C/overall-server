package cn.iocoder.yudao.module.mes.controller.admin.md.workstation.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES workstation response.")
@Data
@ExcelIgnoreUnannotated
public class MesMdWorkstationRespVO {

    @Schema(description = "Workstation code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Workstation ID")
    private Long id;

    @Schema(description = "Workstation code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "WK001")
    @ExcelProperty("Workstation Code")
    private String code;

    @Schema(description = "Workstation name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Workstation 1")
    @ExcelProperty("Workstation Name")
    private String name;

    @Schema(description = "WorkstationLocation.", example = "Zone A line 1")
    @ExcelProperty("Workstation Location")
    private String address;

    @Schema(description = "WorkshopID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long workshopId;

    @Schema(description = "Workshop name.", example = "Workshop 1")
    @ExcelProperty("Shop Floor Name")
    private String workshopName;

    @Schema(description = "Operation code.", example = "1")
    private Long processId;

    @Schema(description = "Operation name.", example = "Polish")
    @ExcelProperty("Operation Name")
    private String processName;

    @Schema(description = "Line-side warehouse ID.", example = "1")
    private Long warehouseId;

    @Schema(description = "Zone code.", example = "1")
    private Long locationId;

    @Schema(description = "Bin code.", example = "1")
    private Long areaId;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Status")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
