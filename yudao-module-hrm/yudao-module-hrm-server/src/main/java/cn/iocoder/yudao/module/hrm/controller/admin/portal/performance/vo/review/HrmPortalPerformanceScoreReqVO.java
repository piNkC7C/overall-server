package cn.iocoder.yudao.module.hrm.controller.admin.portal.performance.vo.review;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "HRM employee performance score request VO.")
@Data
public class HrmPortalPerformanceScoreReqVO {

    @Schema(description = "Employeeperformance reviewReview code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Employeeperformance reviewReview is required.")
    private Long assessmentId;

    @Schema(description = "Scoring Stage code.", example = "2048")
    private Long reviewStageId;

    @Schema(description = "Notes", example = "This StageScorecomplete.")
    @Size(max = 2000, message = "Notes cannot exceed 2000 characters.")
    private String comment;

    @Schema(description = "Self Review", example = "Finished this quarter's goals")
    @Size(max = 2000, message = "Self Review cannot exceed 2000 characters.")
    private String selfComment;

    @Schema(description = "Score person Notes.", example = "Goal completion is good")
    @Size(max = 2000, message = "Score person Notes cannot exceed 2000 characters.")
    private String reviewerComment;

    @Schema(description = "Metric list.")
    @Valid
    private List<HrmPortalPerformanceQuotaSaveReqVO> quotas;

}
