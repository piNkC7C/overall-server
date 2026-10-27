package cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "HRM employee performance review runtime stage response VO.")
@Data
public class HrmPerformanceAssessmentStageRespVO {

    @Schema(description = "Code.")
    private Long id;

    @Schema(description = "Employeeperformance reviewReview code.")
    private Long assessmentId;

    @Schema(description = "Stage type.")
    private Integer type;

    @Schema(description = "Process employee code.")
    private Long handlerEmployeeId;

    @Schema(description = "Process person Name.")
    private String handlerName;

    @Schema(description = "Stage name.")
    private String name;

    @Schema(description = "Score person type.")
    private Integer raterType;

    @Schema(description = "Weight")
    private BigDecimal weight;

    @Schema(description = "Score type.")
    private Integer scoringType;

    @Schema(description = "Visible content.")
    private Integer visibleContent;

    @Schema(description = "WhetherRequired.")
    private Boolean requiredSetting;

    @Schema(description = "Reject permission.")
    private Boolean rejectAuthority;

    @Schema(description = "Sort.")
    private Integer sort;

    @Schema(description = "Review-stage status.")
    private Integer status;

    @Schema(description = "Score.")
    private BigDecimal score;

    @Schema(description = "Result level.")
    private String resultLevel;

    @Schema(description = "Notes")
    private String comment;

    @Schema(description = "Reject reason.")
    private String rejectReason;

    @Schema(description = "Submit time.")
    private LocalDateTime submitTime;

    @Schema(description = "Due time.")
    private LocalDateTime deadlineTime;

    @Schema(description = "Is not can process.")
    private Boolean canHandle;

    @Schema(description = "Is not can Score.")
    private Boolean canScore;

    @Schema(description = "Metric Score list.")
    private List<HrmPerformanceAssessmentQuotaScoreRespVO> quotaScoreList;

}
