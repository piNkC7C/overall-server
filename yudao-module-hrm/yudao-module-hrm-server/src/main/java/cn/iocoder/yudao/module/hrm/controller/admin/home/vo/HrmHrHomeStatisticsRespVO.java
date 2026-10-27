package cn.iocoder.yudao.module.hrm.controller.admin.home.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "Admin - HRM HR workbenchStats response.")
@Data
public class HrmHrHomeStatisticsRespVO {

    @Schema(description = "People overview.")
    private EmployeeSurvey employeeSurvey;

    @Schema(description = "Recruiting activity.")
    private RecruitSurvey recruitSurvey;

    @Schema(description = "Monthpayroll.")
    private SalarySurvey salarySurvey;

    @Schema(description = "Todo reminder.")
    private TodoSurvey todoSurvey;

    @Schema(description = "HRM HR workspace headcount overview response VO.")
    @Data
    public static class EmployeeSurvey {

        @Schema(description = "Active headcount.")
        private Long activeCount;

        @Schema(description = "Hires this month.")
        private Long entryThisMonthCount;

        @Schema(description = "Pending hires this month.")
        private Long pendingEntryThisMonthCount;

        @Schema(description = "Terminations this month.")
        private Long leaveThisMonthCount;

        @Schema(description = "Pending terminations this month.")
        private Long pendingLeaveThisMonthCount;

        @Schema(description = "Confirmations this month.")
        private Long regularThisMonthCount;

        @Schema(description = "Transfers this month.")
        private Long transferThisMonthCount;

    }

    @Schema(description = "HRM HR workspace recruiting activity response VO.")
    @Data
    public static class RecruitSurvey {

        @Schema(description = "Recruiting Job Title quantity.")
        private Long recruitingPostCount;

        @Schema(description = "Recruitingworkflow Candidates.")
        private Long candidateInProcessCount;

        @Schema(description = "Pending hires.")
        private Long pendingEntryCount;

        @Schema(description = "Hired count.")
        private Long joinedCount;

    }

    @Schema(description = "HRM HR workspace last-month payroll response VO.")
    @Data
    public static class SalarySurvey {

        @Schema(description = "Payroll ID")
        private Long monthRecordId;

        @Schema(description = "Employee quantity.")
        private Integer employeeCount;

        @Schema(description = "Net pay.")
        private BigDecimal realPaySalary;

        @Schema(description = "Department pay mix.")
        private List<SalaryDept> deptProportions;

    }

    @Schema(description = "HRM HR workspace department payroll share response VO.")
    @Data
    public static class SalaryDept {

        @Schema(description = "Department code.")
        private Long deptId;

        @Schema(description = "Department name.")
        private String deptName;

        @Schema(description = "Pay mix.")
        private BigDecimal proportion;

        @Schema(description = "Net pay.")
        private BigDecimal totalSalary;

    }

    @Schema(description = "HRM HR workspace to-do reminder response VO.")
    @Data
    public static class TodoSurvey {

        @Schema(description = "Pending hires.")
        private Long toEntryCount;

        @Schema(description = "Pending terminations.")
        private Long toLeaveCount;

        @Schema(description = "Contracts pending expiry.")
        private Long toExpireContractCount;

        @Schema(description = "Pending confirmations.")
        private Long toRegularCount;

        @Schema(description = "Payrolls pending calculation.")
        private Long toSalaryComputeCount;

        @Schema(description = "This Month birthday employee quantity.")
        private Long toBirthdayCount;

    }

}
