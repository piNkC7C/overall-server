package cn.iocoder.yudao.module.mes.controller.admin.dv.checkplan.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES inspection and maintenance plan response.")
@Data
@ExcelIgnoreUnannotated
public class MesDvCheckPlanRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "CHP001")
    @ExcelProperty("Plan Code")
    private String code;

    @Schema(description = "Plan name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Injection-molding daily inspection plan")
    @ExcelProperty("Plan Name")
    private String name;

    @Schema(description = "Plan type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Plan Type")
    private Integer type;

    @Schema(description = "Start Date.")
    @ExcelProperty("Start Date")
    private LocalDateTime startDate;

    @Schema(description = "End Date.")
    @ExcelProperty("End Date")
    private LocalDateTime endDate;

    @Schema(description = "Cycle Type", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Cycle Type")
    private Integer cycleType;

    @Schema(description = "Cycle count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Cycle Count")
    private Integer cycleCount;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Status")
    private Integer status;

    @Schema(description = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
