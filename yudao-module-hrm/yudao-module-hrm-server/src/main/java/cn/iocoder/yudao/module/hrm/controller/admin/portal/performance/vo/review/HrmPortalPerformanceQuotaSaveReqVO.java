package cn.iocoder.yudao.module.hrm.controller.admin.portal.performance.vo.review;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - HRM employeeperformance review metric save request.")
@Data
public class HrmPortalPerformanceQuotaSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Employeeperformance reviewDimension code.", example = "2048")
    private Long dimensionId;

    @Schema(description = "Metric name.", example = "Sales-target attainment")
    @Size(max = 255, message = "Metric name cannot exceed 255 characters.")
    private String name;

    @Schema(description = "Metric Notes.", example = "Based on quarterly sales targets")
    @Size(max = 1000, message = "Metric Notes cannot exceed 1000 characters.")
    private String description;

    @Schema(description = "Standard value.", example = "Full score when completion reaches 100%")
    @Size(max = 1000, message = "Standard value cannot exceed 1000 characters.")
    private String standard;

    @Schema(description = "Metric Weight.", example = "50")
    private BigDecimal weight;

    @Schema(description = "Score type.", example = "1")
    private Integer scoreType;

    @Schema(description = "Target value.", example = "100%")
    @Size(max = 1000, message = "Target value cannot exceed 1000 characters.")
    private String targetValue;

    @Schema(description = "Actual value.", example = "95%")
    @Size(max = 1000, message = "Actual value cannot exceed 1000 characters.")
    private String actualValue;

    @Schema(description = "Self-review score.", example = "90")
    private BigDecimal selfScore;

    @Schema(description = "Reviewer score.", example = "88")
    private BigDecimal reviewerScore;

    @Schema(description = "Final score.", example = "89")
    private BigDecimal finalScore;

    @Schema(description = "Notes", example = "Goal mostly met")
    @Size(max = 1000, message = "Notes cannot exceed 1000 characters.")
    private String comment;

    @Schema(description = "Sort.", example = "1")
    private Integer sort;

}
