package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.monthrecord.employee;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.salary.employee.HrmSalaryEmployeeChangeTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Schema(description = "Admin - HRM employeepayrolllist request.")
@Data
public class HrmSalaryMonthEmployeeRecordListReqVO {

    @Schema(description = "Payroll ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Payroll ID is required.")
    private Long monthRecordId;

    @Schema(description = "Employee code.", example = "1024")
    private Long employeeId;

    @Schema(description = "Employee Name", example = "John.")
    private String employeeName;

    @Schema(description = "Employee No.", example = "HRM001")
    private String jobNumber;

    @Schema(description = "Department code.", example = "100")
    private Long deptId;

    @Schema(description = "EmployeeChange type.", example = "1")
    @InEnum(value = HrmSalaryEmployeeChangeTypeEnum.class, message = "Employee change category must be {value}.")
    private Integer employeeChangeType;

    @Schema(hidden = true)
    private Collection<Long> employeeIds;

    @Schema(hidden = true)
    private Boolean salarySlipSent;

}
