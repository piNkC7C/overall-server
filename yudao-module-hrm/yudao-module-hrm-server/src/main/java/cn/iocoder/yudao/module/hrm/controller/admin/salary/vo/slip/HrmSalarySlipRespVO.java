package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.slip;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - HRM payslip response.")
@Data
public class HrmSalarySlipRespVO {

    @Schema(description = "Code.")
    private Long id;

    @Schema(description = "PaysliprecordID.")
    private Long sendRecordId;

    @Schema(description = "Employee payroll record ID.")
    private Long monthEmployeeRecordId;

    @Schema(description = "Employee code.")
    private Long employeeId;

    @Schema(description = "Employee Name")
    private String employeeName;

    @Schema(description = "Employee No.")
    private String jobNumber;

    @Schema(description = "Mobile Number")
    private String mobile;

    @Schema(description = "Department code.")
    private Long deptId;

    @Schema(description = "Department name.")
    private String deptName;

    @Schema(description = "Post name.")
    private String postName;

    @Schema(description = "Year.")
    private Integer year;

    @Schema(description = "Month")
    private Integer month;

    @Schema(description = "Read status.")
    private Integer readStatus;

    @Schema(description = "Actualpayroll.")
    private BigDecimal realPaySalary;

    @Schema(description = "Notes.")
    private String remark;

    @Schema(description = "Options.")
    private List<HrmSalarySlipOptionRespVO> options;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}
