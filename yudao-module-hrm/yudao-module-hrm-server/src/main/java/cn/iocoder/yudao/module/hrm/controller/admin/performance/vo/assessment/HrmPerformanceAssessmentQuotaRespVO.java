package cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - HRM employeeperformance review metric response.")
@Data
public class HrmPerformanceAssessmentQuotaRespVO {

    @Schema(description = "Code.")
    private Long id;

    @Schema(description = "Employeeperformance reviewReview code.")
    private Long assessmentId;

    @Schema(description = "Employeeperformance reviewDimension code.")
    private Long dimensionId;

    @Schema(description = "Is not allow edit.")
    private Boolean allowEdit;

    @Schema(description = "Preset value.")
    private Boolean preset;

    @Schema(description = "Dimension name.")
    private String dimensionName;

    @Schema(description = "Metric name.")
    private String name;

    @Schema(description = "Metric Notes.")
    private String description;

    @Schema(description = "Standard value.")
    private String standard;

    @Schema(description = "DimensionWeight.")
    private BigDecimal dimensionWeight;

    @Schema(description = "Metric Weight.")
    private BigDecimal weight;

    @Schema(description = "Score type.")
    private Integer scoreType;

    @Schema(description = "Target value.")
    private String targetValue;

    @Schema(description = "Actual value.")
    private String actualValue;

    @Schema(description = "Self-review score.")
    private BigDecimal selfScore;

    @Schema(description = "Reviewer score.")
    private BigDecimal reviewerScore;

    @Schema(description = "Final score.")
    private BigDecimal finalScore;

    @Schema(description = "Notes")
    private String comment;

    @Schema(description = "Sort.")
    private Integer sort;

}
