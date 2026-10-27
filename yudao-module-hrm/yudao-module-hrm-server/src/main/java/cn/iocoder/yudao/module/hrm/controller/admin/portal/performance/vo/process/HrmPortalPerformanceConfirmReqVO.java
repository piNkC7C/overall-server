package cn.iocoder.yudao.module.hrm.controller.admin.portal.performance.vo.process;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.assessment.HrmPerformanceConfirmationResultEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "HRM employee performance review confirm request VO.")
@Data
public class HrmPortalPerformanceConfirmReqVO {

    @Schema(description = "Employeeperformance reviewReview code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Employeeperformance reviewReview is required.")
    private Long assessmentId;

    @Schema(description = "Is not via.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Confirm result is required.")
    @InEnum(value = HrmPerformanceConfirmationResultEnum.class, message = "Confirm result must be {value}.")
    private Integer pass;

    @Schema(description = "Notes", example = "Confirm Review target.")
    @Size(max = 1000, message = "Notes cannot exceed 1000 characters.")
    private String comment;

}
