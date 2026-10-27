package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.employment.HrmEmployeeQuitReasonEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.employment.HrmEmployeeQuitTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.isAfterOrEqual;
import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.isBeforeOrEqual;

@Schema(description = "Admin - HRM employee offboarding request.")
@Data
public class HrmEmployeeQuitReqVO {

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

    @AssertTrue(message = "Resignation request date cannot be later than the planned last day.")
    @JsonIgnore
    public boolean isApplyQuitTimeValid() {
        return applyQuitTime == null || planQuitTime == null
                || isBeforeOrEqual(applyQuitTime.toLocalDate(), planQuitTime.toLocalDate());
    }

    @AssertTrue(message = "Payroll settlement time cannot be earlier than the planned last day.")
    @JsonIgnore
    public boolean isSalarySettlementTimeValid() {
        return salarySettlementTime == null || planQuitTime == null
                || isAfterOrEqual(salarySettlementTime.toLocalDate(), planQuitTime.toLocalDate());
    }

    @AssertTrue(message = "Offboarding reason and offboarding type does not match.")
    @JsonIgnore
    public boolean isReasonValid() {
        if (type == null || HrmEmployeeQuitTypeEnum.RETIREMENT.getType().equals(type)) {
            return true;
        }
        HrmEmployeeQuitReasonEnum quitReason = HrmEmployeeQuitReasonEnum.valueOf(reason);
        return quitReason != null && quitReason.getQuitType().equals(type);
    }

}
