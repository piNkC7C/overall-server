package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.employeeinfo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.option.HrmSalaryOptionValueVO;
import cn.iocoder.yudao.module.hrm.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - HRM employeepayroll info response.")
@Data
@ExcelIgnoreUnannotated
public class HrmSalaryEmployeeInfoRespVO {

    @ExcelProperty(value = "Employee Pay ID", index = 0)
    @Schema(description = "Employeepayroll code.")
    private Long id;

    @ExcelProperty(value = "Employee ID", index = 1)
    @Schema(description = "Employee code.")
    private Long employeeId;

    @ExcelProperty(value = "Employee Name", index = 2)
    @Schema(description = "Employee Name")
    private String employeeName;

    @ExcelProperty(value = "Employee No", index = 3)
    @Schema(description = "Employee No.")
    private String jobNumber;

    @Schema(description = "Phone number.")
    private String mobile;

    @ExcelProperty(value = "Department ID", index = 4)
    @Schema(description = "Department code.")
    private Long deptId;

    @Schema(description = "Department name.")
    private String deptName;

    @Schema(description = "Post name.")
    private String postName;

    @Schema(description = "Onboarding status.")
    private Integer entryStatus;

    @Schema(description = "Employee status.")
    private Integer status;

    @Schema(description = "Hire Date")
    private LocalDateTime entryTime;

    @Schema(description = "Confirmation Date")
    private LocalDateTime regularTime;

    @ExcelProperty(value = "Adjustment Reason", index = 6, converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_SALARY_CHANGE_REASON)
    @Schema(description = "Adjust reason.")
    private Integer changeReason;

    @ExcelProperty(value = "Effective Date", index = 7)
    @Schema(description = "Effective Date")
    private LocalDateTime effectTime;

    @ExcelProperty(value = "Pay Status", index = 5, converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_SALARY_CHANGE_TYPE)
    @Schema(description = "Payroll status.")
    private Integer changeType;

    @ExcelProperty(value = "Probation Salary", index = 9)
    @Schema(description = "Probation periodpayroll.")
    private BigDecimal probationSalary;

    @ExcelProperty(value = "Regular Salary", index = 8)
    @Schema(description = "Regular salary.")
    private BigDecimal regularSalary;

    @ExcelProperty(value = "Notes", index = 10)
    @Schema(description = "Notes.")
    private String remark;

    @Schema(description = "Payroll item list.")
    private List<HrmSalaryOptionValueVO> salaryOptions;

    @Schema(description = "Probation pay items.")
    private List<HrmSalaryOptionValueVO> probationSalaryOptions;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}
