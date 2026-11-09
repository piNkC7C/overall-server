package cn.iocoder.yudao.module.mes.controller.admin.dv.repair.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 维修工单行 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesDvRepairLineRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "维修工单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long repairId;

    @Schema(description = "点检保养项目编号", example = "1")
    private Long subjectId;

    @Schema(description = "项目名称", example = "Check engine oil")
    @ExcelProperty("Project Name")
    private String subjectName;

    @Schema(description = "项目内容", example = "Check whether engine oil is sufficient")
    @ExcelProperty("Project Content")
    private String subjectContent;

    @Schema(description = "项目标准", example = "No oil leak")
    @ExcelProperty("Standard")
    private String subjectStandard;

    @Schema(description = "故障描述", requiredMode = Schema.RequiredMode.REQUIRED, example = "Hydraulic oil leak")
    @ExcelProperty("Fault Description")
    private String malfunction;

    @Schema(description = "故障图片 URL", example = "https://example.com/image.png")
    private String malfunctionUrl;

    @Schema(description = "维修描述", example = "Replace the seal")
    @ExcelProperty("Maintenance Description")
    private String description;

    @Schema(description = "备注", example = "Sample notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
