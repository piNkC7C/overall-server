package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - HRM employeecancel offboarding request.")
@Data
public class HrmEmployeeCancelQuitReqVO {

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Employee code is required.")
    private Long employeeId;

    @Schema(description = "Cancelreason.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Employeewithdraw offboarding apply please.")
    @NotBlank(message = "Cancelreason is required.")
    @Size(max = 500, message = "Cancelreason cannot exceed 500 characters.")
    private String reason;

}
