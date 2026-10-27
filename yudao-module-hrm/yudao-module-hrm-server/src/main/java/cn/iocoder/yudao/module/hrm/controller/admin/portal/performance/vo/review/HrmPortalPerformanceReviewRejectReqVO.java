package cn.iocoder.yudao.module.hrm.controller.admin.portal.performance.vo.review;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "HRM employee reject previous scoring stage request VO.")
@Data
public class HrmPortalPerformanceReviewRejectReqVO {

    @Schema(description = "Employeeperformance reviewReview code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Employeeperformance reviewReview is required.")
    private Long assessmentId;

    @Schema(description = "Scoring Stage code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "Current Scoring Stage is required.")
    private Long reviewStageId;

    @Schema(description = "Review reject reason.", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "Scoring basis is incomplete. Add notes.")
    @NotBlank(message = "Reject reason cannot be empty.")
    @Size(max = 1000, message = "Reject reason cannot exceed 1000 characters.")
    private String reason;

}
