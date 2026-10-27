package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.beforeOrEqualNow;

@Schema(description = "Admin - HRM employee again Onboarding request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class HrmEmployeeRehireReqVO extends HrmEmployeeSaveReqVO {

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Employee code is required.")
    private Long employeeId;

    @AssertTrue(message = "Hire date cannot be later than today.")
    @JsonIgnore
    public boolean isEntryTimeValid() {
        return getEntryTime() == null || beforeOrEqualNow(getEntryTime());
    }

}
