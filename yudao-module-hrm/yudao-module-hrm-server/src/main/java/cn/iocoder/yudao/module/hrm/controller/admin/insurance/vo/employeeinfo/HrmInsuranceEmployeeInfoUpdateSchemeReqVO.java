package cn.iocoder.yudao.module.hrm.controller.admin.insurance.vo.employeeinfo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - HRM employee insurance plan update request.")
@Data
public class HrmInsuranceEmployeeInfoUpdateSchemeReqVO {

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Employee is required.")
    private Long employeeId;

    @Schema(description = "Social security plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Social security plan is required.")
    private Long schemeId;

}
