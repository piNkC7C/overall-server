package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.quitinfo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - HRM employee offboarding info response.")
@Data
public class HrmEmployeeQuitInfoRespVO {

    @Schema(description = "Offboarding info code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long employeeId;

    @Schema(description = "Plan offboarding time.")
    private LocalDateTime planQuitTime;

    @Schema(description = "Apply please offboarding time.")
    private LocalDateTime applyQuitTime;

    @Schema(description = "Payroll settlement time.")
    private LocalDateTime salarySettlementTime;

    @Schema(description = "Offboarding type.", example = "1")
    private Integer type;

    @Schema(description = "Offboarding reason.", example = "1")
    private Integer reason;

    @Schema(description = "Notes.")
    private String remark;

    @Schema(description = "Offboarding before employee status.")
    private Integer oldEmployeeStatus;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
