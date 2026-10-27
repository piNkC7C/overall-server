package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.quitinfo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.employment.HrmEmployeeQuitReasonEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.employment.HrmEmployeeQuitTypeEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.info.HrmEmployeeStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - HRM employee offboarding info save request.")
@Data
public class HrmEmployeeQuitInfoSaveReqVO {

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Employee code is required.")
    private Long employeeId;

    @Schema(description = "Plan offboarding time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Plan offboarding time is required.")
    private LocalDateTime planQuitTime;

    @Schema(description = "Apply please offboarding time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Apply please offboarding time is required.")
    private LocalDateTime applyQuitTime;

    @Schema(description = "Payroll settlement time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Payroll settlement time cannot be empty.")
    private LocalDateTime salarySettlementTime;

    @Schema(description = "Offboarding type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Offboarding type is required.")
    @InEnum(value = HrmEmployeeQuitTypeEnum.class, message = "Offboarding type must be {value}.")
    private Integer type;

    @Schema(description = "Offboarding reason.", example = "1")
    @InEnum(value = HrmEmployeeQuitReasonEnum.class, message = "Offboarding reason must be {value}.")
    private Integer reason;

    @Schema(description = "Notes.", example = "Person reason offboarding.")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    private String remark;

    @Schema(description = "Offboarding before employee status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Offboarding before employee status is required.")
    @InEnum(value = HrmEmployeeStatusEnum.class, message = "Offboarding before employee status must be {value}.")
    private Integer oldEmployeeStatus;

}
