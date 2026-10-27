package cn.iocoder.yudao.module.hrm.controller.admin.portal.performance.vo.assessment;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "HRM employee my performance review page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class HrmPortalPerformanceAssessmentPageReqVO extends PageParam {

    @Schema(description = "Performance reviewplan name.", example = "Q3 2026 performance plan")
    private String search;

    @Schema(description = "Archived.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Archived cannot be empty.")
    private Boolean archived;

}
