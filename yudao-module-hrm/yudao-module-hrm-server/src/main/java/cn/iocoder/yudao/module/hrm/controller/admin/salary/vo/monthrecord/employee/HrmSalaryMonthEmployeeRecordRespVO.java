package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.monthrecord.employee;

import cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.option.HrmSalaryOptionValueVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "HRM employee monthly pay response VO.")
@Data
public class HrmSalaryMonthEmployeeRecordRespVO {

    @Schema(description = "Code.")
    private Long id;

    @Schema(description = "Payroll ID")
    private Long monthRecordId;

    @Schema(description = "Employee code.")
    private Long employeeId;

    @Schema(description = "Year.")
    private Integer year;

    @Schema(description = "Month")
    private Integer month;

    @Schema(description = "Employee Name")
    private String employeeName;

    @Schema(description = "Employee No.")
    private String jobNumber;

    @Schema(description = "Department code.")
    private Long deptId;

    @Schema(description = "Department.")
    private String deptName;

    @Schema(description = "Job Title name.")
    private String postName;

    @Schema(description = "Payable attendance days.")
    private BigDecimal actualWorkDay;

    @Schema(description = "Required attendance days.")
    private BigDecimal needWorkDay;

    @Schema(description = "Gross Pay")
    private BigDecimal expectedPaySalary;

    @Schema(description = "Taxable wages.")
    private BigDecimal taxableSalary;

    @Schema(description = "Income Tax")
    private BigDecimal personalTax;

    @Schema(description = "Net pay.")
    private BigDecimal realPaySalary;

    @Schema(description = "Performance Factor")
    private BigDecimal performanceCoefficient;

    @Schema(description = "Pay item valuelist.")
    private List<HrmSalaryOptionValueVO> optionValues;

}
