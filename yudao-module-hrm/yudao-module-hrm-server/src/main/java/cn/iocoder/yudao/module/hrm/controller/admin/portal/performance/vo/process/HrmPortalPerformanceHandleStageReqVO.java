package cn.iocoder.yudao.module.hrm.controller.admin.portal.performance.vo.process;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.assessment.HrmPerformanceConfirmationResultEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "HRM employee performance review runtime stage process request VO.")
@Data
public class HrmPortalPerformanceHandleStageReqVO {

    @Schema(description = "Employeeperformance reviewReview code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Employeeperformance reviewReview is required.")
    private Long assessmentId;

    @Schema(description = "Run stageID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "Run stage cannot be empty.")
    private Long stageId;

    @Schema(description = "Is not via.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Process result is required.")
    @InEnum(value = HrmPerformanceConfirmationResultEnum.class, message = "Process result must be {value}.")
    private Integer pass;

    @Schema(description = "Handle comment.", example = "Approval via.")
    @Size(max = 500, message = "Handle comment cannot exceed 500 characters.")
    private String comment;

    @Schema(description = "ReturnScoring Stage code list.", example = "[1024, 1025]")
    private List<Long> reviewStageIds;

}
