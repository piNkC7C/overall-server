package cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - HRM employeeperformance review metric Scoredetail response.")
@Data
public class HrmPerformanceAssessmentQuotaScoreRespVO {

    @Schema(description = "Code.")
    private Long id;

    @Schema(description = "EmployeeScoring Stage code.")
    private Long assessmentStageId;

    @Schema(description = "Employeeperformance review metric code.")
    private Long assessmentQuotaId;

    @Schema(description = "Score.")
    private BigDecimal score;

    @Schema(description = "Notes")
    private String comment;

}
