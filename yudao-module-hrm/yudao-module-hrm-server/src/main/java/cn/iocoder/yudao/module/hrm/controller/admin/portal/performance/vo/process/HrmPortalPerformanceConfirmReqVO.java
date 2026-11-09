package cn.iocoder.yudao.module.hrm.controller.admin.portal.performance.vo.process;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.assessment.HrmPerformanceConfirmationResultEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - HRM 员工端绩效确认 Request VO")
@Data
public class HrmPortalPerformanceConfirmReqVO {

    @Schema(description = "员工绩效考核编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Employeeperformance reviewReview is required.")
    private Long assessmentId;

    @Schema(description = "是否通过", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Confirm result is required.")
    @InEnum(value = HrmPerformanceConfirmationResultEnum.class, message = "Confirm result must be {value}.")
    private Integer pass;

    @Schema(description = "说明", example = "Confirm Review target.")
    @Size(max = 1000, message = "Notes cannot exceed 1000 characters.")
    private String comment;

}
