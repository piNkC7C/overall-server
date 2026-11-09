package cn.iocoder.yudao.module.hrm.controller.admin.portal.performance.vo.review;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "管理后台 - HRM 员工端绩效评分 Request VO")
@Data
public class HrmPortalPerformanceScoreReqVO {

    @Schema(description = "员工绩效考核编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Employeeperformance reviewReview is required.")
    private Long assessmentId;

    @Schema(description = "评分阶段编号", example = "2048")
    private Long reviewStageId;

    @Schema(description = "说明", example = "This StageScorecomplete.")
    @Size(max = 2000, message = "Notes cannot exceed 2000 characters.")
    private String comment;

    @Schema(description = "自评说明", example = "Finished this quarter's goals")
    @Size(max = 2000, message = "Self Review cannot exceed 2000 characters.")
    private String selfComment;

    @Schema(description = "评分人说明", example = "Goal completion is good")
    @Size(max = 2000, message = "Score person Notes cannot exceed 2000 characters.")
    private String reviewerComment;

    @Schema(description = "指标列表")
    @Valid
    private List<HrmPortalPerformanceQuotaSaveReqVO> quotas;

}
