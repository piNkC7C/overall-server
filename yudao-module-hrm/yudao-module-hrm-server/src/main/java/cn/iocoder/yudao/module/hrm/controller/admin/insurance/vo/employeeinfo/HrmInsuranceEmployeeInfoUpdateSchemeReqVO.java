package cn.iocoder.yudao.module.hrm.controller.admin.insurance.vo.employeeinfo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - HRM 员工参保方案更新 Request VO")
@Data
public class HrmInsuranceEmployeeInfoUpdateSchemeReqVO {

    @Schema(description = "员工编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Employee is required.")
    private Long employeeId;

    @Schema(description = "社保方案编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Social security plan is required.")
    private Long schemeId;

}
