package cn.iocoder.yudao.module.hrm.controller.admin.portal.performance.vo.process;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "HRM employee performance action response VO.")
@Data
public class HrmPortalPerformanceProcessRespVO {

    @Schema(description = "Code.")
    private Long id;

    @Schema(description = "Next stage ID.")
    private Long nextStageId;

}
