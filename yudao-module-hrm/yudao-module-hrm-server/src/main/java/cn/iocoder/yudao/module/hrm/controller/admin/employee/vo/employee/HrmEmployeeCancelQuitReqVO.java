package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - HRM 员工取消离职 Request VO")
@Data
public class HrmEmployeeCancelQuitReqVO {

    @Schema(description = "员工编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Employee code is required.")
    private Long employeeId;

    @Schema(description = "取消原因", requiredMode = Schema.RequiredMode.REQUIRED, example = "Employeewithdraw offboarding apply please.")
    @NotBlank(message = "Cancelreason is required.")
    @Size(max = 500, message = "Cancelreason cannot exceed 500 characters.")
    private String reason;

}
