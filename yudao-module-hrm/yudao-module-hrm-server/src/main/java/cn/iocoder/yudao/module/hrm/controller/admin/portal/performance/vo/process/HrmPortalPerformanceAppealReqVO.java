package cn.iocoder.yudao.module.hrm.controller.admin.portal.performance.vo.process;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "HRM employee performance appeal request VO.")
@Data
public class HrmPortalPerformanceAppealReqVO {

    @Schema(description = "Employeeperformance reviewReview code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Employeeperformance reviewReview is required.")
    private Long assessmentId;

    @Schema(description = "Appeal Reason", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "Actual result does not match the scoring basis")
    @NotBlank(message = "Appeal Reason is required.")
    @Size(max = 500, message = "Appeal Reason cannot exceed 500 characters.")
    private String appealReason;

    @Schema(description = "Appeal AttachmentAddress list.", example = "[https://example.com/appeal.pdf]")
    private List<String> appealFileUrls;

    @Schema(description = "ReturnScore node code list.", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "[1024, 2048]")
    @NotNull(message = "ReturnScore node is required.")
    private List<Long> reviewStageIds;

}
