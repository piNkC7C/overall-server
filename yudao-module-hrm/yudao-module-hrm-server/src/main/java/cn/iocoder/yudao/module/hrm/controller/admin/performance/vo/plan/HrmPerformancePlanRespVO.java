package cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.plan;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Schema(description = "Admin - HRM performance reviewplan response.")
@Data
public class HrmPerformancePlanRespVO {

    @Schema(description = "Code.")
    private Long id;

    @Schema(description = "Performance reviewplan name.")
    private String name;

    @Schema(description = "Review Cycle type.")
    private Integer cycleType;

    @Schema(description = "Review Cycle")
    private String cycle;

    @Schema(description = "Quarter.")
    private Integer quarter;

    @Schema(description = "Start Date.")
    private LocalDateTime startTime;

    @Schema(description = "End Date.")
    private LocalDateTime endTime;

    @Schema(description = "ReviewNotes.")
    private String description;

    @Schema(description = "Review scopelist.")
    private List<Scope> scopes;

    @Schema(description = "Reviewtemplate code.")
    private Long assessmentTemplateId;

    @Schema(description = "Reviewsetting snapshot.")
    private AssessmentConfig assessmentConfig;

    @Schema(description = "Resulttemplate code.")
    private Long resultTemplateId;

    @Schema(description = "Result setting snapshot.")
    private ResultConfig resultConfig;

    @Schema(description = "Metric set type.")
    private Integer quotaSettingType;

    @Schema(description = "Is not need to need target confirm.")
    private Boolean targetConfirmation;

    @Schema(description = "Target confirm node.")
    private HandlerStage targetConfirmationStage;

    @Schema(description = "Scoring Stage list.")
    private List<ReviewStage> reviewStages;

    @Schema(description = "Is not need to need result approval.")
    private Boolean resultAudit;

    @Schema(description = "Result approval node list.")
    private List<HandlerStage> resultAuditStages;

    @Schema(description = "Is not need to need result confirm.")
    private Boolean resultConfirmation;

    @Schema(description = "Appeal stageslist.")
    private List<HandlerStage> appealStages;

    @Schema(description = "Appeal overdue days.")
    private Integer appealTimeoutDays;

    @Schema(description = "Appeal timeout action.")
    private Integer appealTimeoutAction;

    @Schema(description = "Is not sync payroll.")
    private Boolean syncToSalary;

    @Schema(description = "Pay Month")
    private String paidForMonth;

    @Schema(description = "Each Stageemployee quantity.")
    private Map<Integer, Long> stageCountMap;

    @Schema(description = "Stage status.")
    private Integer stageType;

    @Schema(description = "Performance reviewplan status.")
    private Integer status;

    @Schema(description = "Current actionStage.")
    private Integer operationType;

    @Schema(description = "End time.")
    private LocalDateTime terminateTime;

    @Schema(description = "Reviewtemplate name.")
    private String assessmentTemplateName;

    @Schema(description = "Resulttemplate name.")
    private String resultTemplateName;

    @Schema(description = "Employee quantity.")
    private Integer employeeCount;

    @Schema(description = "Completed quantity.")
    private Integer finishedCount;

    @Schema(description = "Is not can start Score.")
    private Boolean scoringReady;

    @Schema(description = "Can start the meeting.")
    private Boolean interviewReady;

    @Schema(description = "Can archive.")
    private Boolean archiveReady;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

    @Schema(description = "HRM performance plan review scope response VO.")
    @Data
    public static class Scope {

        @Schema(description = "Range type.", example = "1")
        private Integer type;

        @Schema(description = "Employee code list.", example = "[1024, 1025]")
        private List<Long> employeeIds;

        @Schema(description = "Department code list.", example = "[100, 101]")
        private List<Long> deptIds;

        @Schema(description = "Employment Type", example = "1")
        private Integer employeeType;

        @Schema(description = "Employee status list.", example = "[1, 2]")
        private List<Integer> employeeStatuses;
    }

    @Schema(description = "Admin - HRM performance reviewplan process node response.")
    @Data
    public static class HandlerStage {

        @Schema(description = "Process person type.", example = "1")
        private Integer type;

        @Schema(description = "Manager or department level.", example = "1")
        private Integer level;

        @Schema(description = "Specified process employee code.", example = "1024")
        private Long employeeId;
    }

    @Schema(description = "Admin - HRM performance plan Scoring Stage response.")
    @Data
    public static class ReviewStage {

        @Schema(description = "Scoring Stage name.", example = "Direct ManagerScore.")
        private String name;

        @Schema(description = "Score person.")
        private HandlerStage rater;

        @Schema(description = "ScoreWeight.", example = "60")
        private BigDecimal weight;

        @Schema(description = "Score method.", example = "1")
        private Integer scoringType;

        @Schema(description = "Score content visibility.", example = "1")
        private Integer visibleContent;

        @Schema(description = "Comment required.", example = "true")
        private Boolean requiredSetting;

        @Schema(description = "Is not Allow Reject.", example = "true")
        private Boolean rejectAuthority;
    }

    @Schema(description = "HRM performance review setting snapshot response VO.")
    @Data
    public static class AssessmentConfig {

        @Schema(description = "Template name.", example = "Quarterly review template")
        private String name;

        @Schema(description = "Scoring method.", example = "1")
        private Integer scoreCalculation;

        @Schema(description = "Score limit type.", example = "1")
        private Integer upperLimitType;

        @Schema(description = "Score limit.", example = "100")
        private BigDecimal upperLimitScore;

        @Schema(description = "ReviewDimensionsetting.")
        private List<Dimension> dimensions;

        @Schema(description = "Admin - HRM performance review Dimension response.")
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

        @Schema(description = "Admin - HRM performance reviewReview metric response.")
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

    @Schema(description = "HRM performance review result setting snapshot response VO.")
    @Data
    public static class ResultConfig {

        @Schema(description = "Template name.", example = "Performance review resulttemplate.")
        private String name;

        @Schema(description = "Result level setting.")
        private List<Level> levels;

        @Schema(description = "Admin - HRM performance review result level response.")
        @Data
        public static class Level {

            @Schema(description = "Level name.", example = "Excellent")
            private String name;

            @Schema(description = "Minimum score.", example = "90")
            private BigDecimal minScore;

            @Schema(description = "Maximum score.", example = "100")
            private BigDecimal maxScore;

            @Schema(description = "Performance Factor", example = "1.2")
            private BigDecimal coefficient;
        }
    }

}
