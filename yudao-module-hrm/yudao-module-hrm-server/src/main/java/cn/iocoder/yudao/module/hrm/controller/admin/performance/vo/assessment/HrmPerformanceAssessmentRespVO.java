package cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - HRM performance reviewemployee response.")
@Data
public class HrmPerformanceAssessmentRespVO {

    @Schema(description = "Code.")
    private Long id;

    @Schema(description = "Performance reviewplan code.")
    private Long planId;

    @Schema(description = "Performance reviewplan name.")
    private String name;

    @Schema(description = "Review Cycle type.")
    private Integer cycleType;

    @Schema(description = "Review Cycle")
    private String cycle;

    @Schema(description = "Start Date.")
    private LocalDateTime startTime;

    @Schema(description = "End Date.")
    private LocalDateTime endTime;

    @Schema(description = "Order item Score limit.")
    private BigDecimal upperLimitScore;

    @Schema(description = "Employee code.")
    private Long employeeId;

    @Schema(description = "Employee Name")
    private String employeeName;

    @Schema(description = "Employee No.")
    private String jobNumber;

    @Schema(description = "Phone number.")
    private String mobile;

    @Schema(description = "Department code.")
    private Long deptId;

    @Schema(description = "Department name.")
    private String deptName;

    @Schema(description = "Job Title name.")
    private String postName;

    @Schema(description = "Employment Type")
    private Integer employeeType;

    @Schema(description = "Employee status.")
    private Integer employeeStatus;

    @Schema(description = "Current process person.")
    private String currentHandlerName;

    @Schema(description = "Review status.")
    private Integer status;

    @Schema(description = "Active status.")
    private Integer processStatus;

    @Schema(description = "Stage status.")
    private Integer stageType;

    @Schema(description = "Stage sort.")
    private Integer stageSort;

    @Schema(description = "Score.")
    private BigDecimal score;

    @Schema(description = "Result level.")
    private String resultLevel;

    @Schema(description = "Performance Factor")
    private BigDecimal coefficient;

    @Schema(description = "Target confirm Employee Name.")
    private String targetConfirmationEmployeeName;

    @Schema(description = "Target confirm result.")
    private Integer targetConfirmationResult;

    @Schema(description = "Goal confirmation comment.")
    private String targetConfirmationComment;

    @Schema(description = "Target confirm time.")
    private LocalDateTime targetConfirmationTime;

    @Schema(description = "Is not can confirm target.")
    private Boolean canConfirmTarget;

    @Schema(description = "Self Review")
    private String selfComment;

    @Schema(description = "Score person Notes.")
    private String reviewerComment;

    @Schema(description = "ResultNotes.")
    private String resultComment;

    @Schema(description = "Result confirm time.")
    private LocalDateTime resultConfirmationTime;

    @Schema(description = "Result approval status.")
    private Integer resultAuditStatus;

    @Schema(description = "Result approval time.")
    private LocalDateTime resultAuditTime;

    @Schema(description = "Result review notes.")
    private String resultAuditReason;

    @Schema(description = "Appeal Reason")
    private String appealReason;

    @Schema(description = "Appeal AttachmentAddress list.")
    private List<String> appealFileUrls;

    @Schema(description = "Appeal return-to scoring stage IDs.")
    private List<Long> appealReviewStageIds;

    @Schema(description = "Appeal submit time.")
    private LocalDateTime appealSubmitTime;

    @Schema(description = "Appeal status.")
    private Integer appealStatus;

    @Schema(description = "Appeal handled time.")
    private LocalDateTime appealTime;

    @Schema(description = "Appeal decision notes.")
    private String appealComment;

    @Schema(description = "Archived")
    private LocalDateTime archiveTime;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

    @Schema(description = "Metric Dimension list.")
    private List<HrmPerformanceAssessmentDimensionRespVO> dimensions;

    @Schema(description = "Metric list.")
    private List<HrmPerformanceAssessmentQuotaRespVO> quotas;

    @Schema(description = "Scoring Stage list.")
    private List<HrmPerformanceAssessmentStageRespVO> reviewStages;

    @Schema(description = "Current Scoring Stage.")
    private HrmPerformanceAssessmentStageRespVO currentReviewStage;

    @Schema(description = "Run stagelist.")
    private List<HrmPerformanceAssessmentStageRespVO> stages;

    @Schema(description = "Current pending stage.")
    private HrmPerformanceAssessmentStageRespVO currentStage;

}
