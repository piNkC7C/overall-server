package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.slip.sendrecord;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "HRM employees pending payslip response VO.")
@Data
public class HrmSalarySlipSendEmployeeRespVO {

    @Schema(description = "Employee monthly payroll ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long monthEmployeeRecordId;

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long employeeId;

    @Schema(description = "Employee Name", example = "John.")
    private String employeeName;

    @Schema(description = "Employee No.", example = "HRM001")
    private String jobNumber;

    @Schema(description = "Mobile Number", example = "13800138000")
    private String mobile;

    @Schema(description = "Department code.", example = "100")
    private Long deptId;

    @Schema(description = "Department name.", example = "Engineering.")
    private String deptName;

    @Schema(description = "Post name.", example = "Java engineer.")
    private String postName;

    @Schema(description = "Gross Pay", example = "10000")
    private BigDecimal expectedPaySalary;

    @Schema(description = "Net pay.", example = "8500")
    private BigDecimal realPaySalary;

    @Schema(description = "Is not already send.", example = "false")
    private Boolean sent;

}
