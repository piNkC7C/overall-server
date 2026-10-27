package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.slip.sendrecord;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "HRM employees pending payslip request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class HrmSalarySlipSendEmployeeReqVO extends PageParam {

    @Schema(description = "Monthly payroll ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Monthly payroll ID cannot be empty.")
    private Long monthRecordId;

    @Schema(description = "Employee Name、Employee No. or phone number.", example = "John.")
    private String search;

    @Schema(description = "Department code.", example = "100")
    private Long deptId;

    @Schema(description = "Is not already send.", example = "false")
    private Boolean sent;

}
