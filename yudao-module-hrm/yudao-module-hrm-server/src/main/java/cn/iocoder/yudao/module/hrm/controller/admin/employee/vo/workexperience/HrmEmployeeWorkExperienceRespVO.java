package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.workexperience;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - HRM employeework experience response.")
@Data
public class HrmEmployeeWorkExperienceRespVO {

    @Schema(description = "Work-experience ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long employeeId;

    @Schema(description = "Employer.", example = "Sample Tech")
    private String workUnit;

    @Schema(description = "Title", example = "Software engineer")
    private String postName;

    @Schema(description = "Work start date.")
    private LocalDateTime startTime;

    @Schema(description = "Work end date.")
    private LocalDateTime endTime;

    @Schema(description = "Offboarding reason.")
    private String reason;

    @Schema(description = "Reference")
    private String witnessName;

    @Schema(description = "Referencephone number.")
    private String witnessPhone;

    @Schema(description = "Work notes.")
    private String remark;

    @Schema(description = "Sort.", example = "1")
    private Integer sort;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
