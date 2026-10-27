package cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessmenttemplate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - HRM performance reviewReviewtemplate response.")
@Data
public class HrmPerformanceAssessmentTemplateRespVO {

    @Schema(description = "Template code.", example = "1024")
    private Long id;

    @Schema(description = "Template name.", example = "Quarterly review template")
    private String name;

    @Schema(description = "TemplateNotes.", example = "For quarterly performance reviews")
    private String illustrate;

    @Schema(description = "Scoring method.", example = "1")
    private Integer scoreCalculation;

    @Schema(description = "Score limit type.", example = "1")
    private Integer upperLimitType;

    @Schema(description = "Score limit.", example = "100")
    private BigDecimal upperLimitScore;

    @Schema(description = "Dimension quantity.", example = "3")
    private Integer dimensionCount;

    @Schema(description = "Metric quantity.", example = "12")
    private Integer quotaCount;

    @Schema(description = "Status.", example = "0")
    private Integer status;

    @Schema(description = "ReviewDimension list.")
    private List<Dimension> dimensions;

    @Schema(description = "Creator.")
    private String creator;

    @Schema(description = "Creator name.")
    private String creatorName;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

    @Schema(description = "Update time.")
    private LocalDateTime updateTime;

    @Schema(description = "Admin - HRM performance review templateDimension.")
    @Data
    public static class Dimension {

        @Schema(description = "Dimension name.", example = "Job performance")
        private String name;

        @Schema(description = "Metric type.", example = "1")
        private Integer quotaType;

        @Schema(description = "DimensionWeight.", example = "60")
        private BigDecimal weight;

        @Schema(description = "Notes.", example = "Core KPI")
        private String remark;

        @Schema(description = "Is not allow employee edit.", example = "true")
        private Boolean allowEdit;

        @Schema(description = "Review metric list.")
        private List<Quota> quotas;
    }

    @Schema(description = "Admin - HRM performance reviewReviewtemplate metric.")
    @Data
    public static class Quota {

        @Schema(description = "Metric name.", example = "Sales-target attainment")
        private String name;

        @Schema(description = "Metric Notes.", example = "Based on quarterly sales targets")
        private String illustrate;

        @Schema(description = "Score standard.", example = "Full score when completion reaches 100%")
        private String standard;

        @Schema(description = "Metric Weight.", example = "50")
        private BigDecimal weight;

        @Schema(description = "Score type.", example = "1")
        private Integer scoreType;
    }

}
