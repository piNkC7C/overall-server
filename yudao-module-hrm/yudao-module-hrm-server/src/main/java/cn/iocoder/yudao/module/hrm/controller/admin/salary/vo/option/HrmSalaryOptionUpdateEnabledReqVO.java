package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.option;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - HRM payroll item update Enabled status request.")
@Data
public class HrmSalaryOptionUpdateEnabledReqVO {

    @Schema(description = "Payroll item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Payroll item code is required.")
    private Long id;

    @Schema(description = "Is not Enabled.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Enabled status is required.")
    private Boolean enabled;

}
