package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.beforeOrEqualNow;

@Schema(description = "Admin - HRM employee confirm Onboarding request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class HrmEmployeeConfirmEntryReqVO extends HrmEmployeeSaveReqVO {

    @AssertTrue(message = "Hire date cannot be later than today.")
    @JsonIgnore
    public boolean isEntryTimeValid() {
        return getEntryTime() == null || beforeOrEqualNow(getEntryTime());
    }

}
