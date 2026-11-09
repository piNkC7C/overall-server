package cn.iocoder.yudao.module.hrm.controller.admin.portal.performance.vo.process;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "管理后台 - HRM 员工端绩效申诉 Request VO")
@Data
public class HrmPortalPerformanceAppealReqVO {

    @Schema(description = "员工绩效考核编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Employeeperformance reviewReview is required.")
    private Long assessmentId;

    @Schema(description = "申诉原因", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "Actual result does not match the scoring basis")
    @NotBlank(message = "Appeal Reason is required.")
    @Size(max = 500, message = "Appeal Reason cannot exceed 500 characters.")
    private String appealReason;

    @Schema(description = "申诉附件地址列表", example = "[https://example.com/appeal.pdf]")
    private List<String> appealFileUrls;

    @Schema(description = "退回评分节点编号列表", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "[1024, 2048]")
    @NotNull(message = "ReturnScore node is required.")
    private List<Long> reviewStageIds;

}
