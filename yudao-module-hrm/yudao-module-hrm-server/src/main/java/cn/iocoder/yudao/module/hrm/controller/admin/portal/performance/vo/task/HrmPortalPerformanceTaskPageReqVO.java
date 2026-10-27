package cn.iocoder.yudao.module.hrm.controller.admin.portal.performance.vo.task;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.assessment.HrmPerformanceAssessmentStageStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "HRM employee performance review task page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class HrmPortalPerformanceTaskPageReqVO extends PageParam {

    @Schema(description = "Performance plan name、Employee Name or Employee No.", example = "John.")
    private String search;

    @Schema(description = "Stage process status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Stage process status is required.")
    @InEnum(value = HrmPerformanceAssessmentStageStatusEnum.class,
            message = "Stage process status must be {value}.")
    private Integer stageStatus;

}
