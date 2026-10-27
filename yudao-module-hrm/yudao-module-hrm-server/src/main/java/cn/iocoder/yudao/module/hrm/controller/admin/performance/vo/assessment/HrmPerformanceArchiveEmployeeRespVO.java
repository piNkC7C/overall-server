package cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - HRM employeeperformance review profile response.")
@Data
public class HrmPerformanceArchiveEmployeeRespVO {

    @Schema(description = "Employee code.", example = "1024")
    private Long employeeId;

    @Schema(description = "Employee Name", example = "John.")
    private String employeeName;

    @Schema(description = "Employee No.", example = "HRM001")
    private String jobNumber;

    @Schema(description = "Department code.", example = "100")
    private Long deptId;

    @Schema(description = "Department name.", example = "Engineering.")
    private String deptName;

    @Schema(description = "Job Title name.", example = "Java engineer.")
    private String postName;

    @Schema(description = "Mobile Number", example = "15601691300")
    private String mobile;

    @Schema(description = "Employee status.", example = "1")
    private Integer employeeStatus;

    @Schema(description = "Employment Type", example = "1")
    private Integer employeeType;

    @Schema(description = "RecentReviewID.", example = "2048")
    private Long latestAssessmentId;

    @Schema(description = "Latest review plan.", example = "2026 annual performance review")
    private String latestPlanName;

    @Schema(description = "Latest performance score.", example = "95.50")
    private BigDecimal latestScore;

    @Schema(description = "Latest performance grade.", example = "A")
    private String latestResultLevel;

    @Schema(description = "Review count.", example = "3")
    private Long assessmentCount;

}
