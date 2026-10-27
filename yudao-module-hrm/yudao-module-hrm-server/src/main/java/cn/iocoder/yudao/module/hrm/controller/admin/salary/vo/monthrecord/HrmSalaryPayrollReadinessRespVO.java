package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.monthrecord;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Schema(description = "HRM payroll calculation readiness response VO.")
@Data
public class HrmSalaryPayrollReadinessRespVO {

    @Schema(description = "Payroll ID")
    private Long monthRecordId;

    @Schema(description = "Title.")
    private String title;

    @Schema(description = "Year.")
    private Integer year;

    @Schema(description = "Month")
    private Integer month;

    @Schema(description = "Start Date.")
    private LocalDateTime startTime;

    @Schema(description = "End Date.")
    private LocalDateTime endTime;

    @Schema(description = "Social security YearMonth.")
    private String socialSecurityYearMonth;

    @Schema(description = "Employees in payroll.")
    private Long payrollEmployeeCount;

    @Schema(description = "Employees with set pay.")
    private Long salaryEmployeeCount;

    @Schema(description = "Employees without set pay.")
    private Long noSalaryEmployeeCount;

    @Schema(description = "Employees without a pay group.")
    private Long noSalaryGroupEmployeeCount;

    @Schema(description = "Employees with changes.")
    private Long changeEmployeeCount;

    @Schema(description = "Change-type count map.")
    private Map<Integer, Long> changeTypeCountMap;

    @Schema(description = "Not Set Salaryemployee list.")
    private List<Employee> noSalaryEmployees;
    @Schema(description = "Not assign payroll group employee list.")
    private List<Employee> noSalaryGroupEmployees;

    @Schema(description = "HRM payroll calculation readiness employee response VO.")
    @Data
    public static class Employee {

        @Schema(description = "Employee code.")
        private Long employeeId;

        @Schema(description = "Employee Name")
        private String employeeName;

        @Schema(description = "Employee No.")
        private String jobNumber;

        @Schema(description = "Department code.")
        private Long deptId;

        @Schema(description = "Department name.")
        private String deptName;

        @Schema(description = "Job Title name.")
        private String postName;

        @Schema(description = "Onboarding status.")
        private Integer entryStatus;

        @Schema(description = "Employee status.")
        private Integer status;

        @Schema(description = "Hire Date")
        private LocalDateTime entryTime;

    }

}
