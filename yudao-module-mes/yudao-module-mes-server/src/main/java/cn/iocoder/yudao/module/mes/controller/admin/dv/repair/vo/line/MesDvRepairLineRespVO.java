package cn.iocoder.yudao.module.mes.controller.admin.dv.repair.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES repair work order line response.")
@Data
@ExcelIgnoreUnannotated
public class MesDvRepairLineRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Repair work order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long repairId;

    @Schema(description = "Inspection and maintenance item code.", example = "1")
    private Long subjectId;

    @Schema(description = "Item name.", example = "Check engine oil")
    @ExcelProperty("Project Name")
    private String subjectName;

    @Schema(description = "Item content.", example = "Check whether engine oil is sufficient")
    @ExcelProperty("Project Content")
    private String subjectContent;

    @Schema(description = "Item standard.", example = "No oil leak")
    @ExcelProperty("Standard")
    private String subjectStandard;

    @Schema(description = "Fault description.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Hydraulic oil leak")
    @ExcelProperty("Fault Description")
    private String malfunction;

    @Schema(description = "Fault image URL.", example = "https://example.com/image.png")
    private String malfunctionUrl;

    @Schema(description = "MaintenanceDescription.", example = "Replace the seal")
    @ExcelProperty("Maintenance Description")
    private String description;

    @Schema(description = "Notes.", example = "Sample notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
