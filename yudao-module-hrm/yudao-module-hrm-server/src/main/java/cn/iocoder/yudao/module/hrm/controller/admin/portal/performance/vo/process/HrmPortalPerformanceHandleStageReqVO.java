package cn.iocoder.yudao.module.hrm.controller.admin.portal.performance.vo.process;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.assessment.HrmPerformanceConfirmationResultEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "管理后台 - HRM 员工端绩效运行阶段处理 Request VO")
@Data
public class HrmPortalPerformanceHandleStageReqVO {

    @Schema(description = "员工绩效考核编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Employeeperformance reviewReview is required.")
    private Long assessmentId;

    @Schema(description = "运行阶段编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "Run stage cannot be empty.")
    private Long stageId;

    @Schema(description = "是否通过", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Process result is required.")
    @InEnum(value = HrmPerformanceConfirmationResultEnum.class, message = "Process result must be {value}.")
    private Integer pass;

    @Schema(description = "处理意见", example = "Approval via.")
    @Size(max = 500, message = "Handle comment cannot exceed 500 characters.")
    private String comment;

    @Schema(description = "退回评分阶段编号列表", example = "[1024, 1025]")
    private List<Long> reviewStageIds;

}
