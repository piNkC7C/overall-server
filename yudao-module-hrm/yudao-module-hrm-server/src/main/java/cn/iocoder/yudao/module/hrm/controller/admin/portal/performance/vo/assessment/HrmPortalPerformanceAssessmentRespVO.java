package cn.iocoder.yudao.module.hrm.controller.admin.portal.performance.vo.assessment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "HRM employee performance review response VO.")
@Data
public class HrmPortalPerformanceAssessmentRespVO {

    @Schema(description = "Code.")
    private Long id;

    @Schema(description = "Performance reviewplan code.")
    private Long planId;

    @Schema(description = "Performance reviewplan name.")
    private String name;

    @Schema(description = "Review status.")
    private Integer status;

    @Schema(description = "Stage status.")
    private Integer stageType;

    @Schema(description = "Score.")
    private BigDecimal score;

    @Schema(description = "Result level.")
    private String resultLevel;

    @Schema(description = "Performance Factor")
    private BigDecimal coefficient;

    @Schema(description = "Result approval status.")
    private Integer resultAuditStatus;

    @Schema(description = "Result approval time.")
    private LocalDateTime resultAuditTime;

    @Schema(description = "Result review notes.")
    private String resultAuditReason;

    @Schema(description = "Appeal Reason")
    private String appealReason;

    @Schema(description = "Appeal status.")
    private Integer appealStatus;

    @Schema(description = "Appeal handled time.")
    private LocalDateTime appealTime;

    @Schema(description = "Appeal decision notes.")
    private String appealComment;

    @Schema(description = "Start Date.")
    private LocalDateTime startTime;

    @Schema(description = "End Date.")
    private LocalDateTime endTime;

    @Schema(description = "Archived")
    private LocalDateTime archiveTime;

}
