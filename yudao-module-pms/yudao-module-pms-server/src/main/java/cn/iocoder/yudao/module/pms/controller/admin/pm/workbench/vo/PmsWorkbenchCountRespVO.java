package cn.iocoder.yudao.module.pms.controller.admin.pm.workbench.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

@Schema(description = "Admin - PMS workbenchQuantityresponse VO.")
@Data
@Accessors(chain = true)
public class PmsWorkbenchCountRespVO {

    @Schema(description = "Requirement quantity.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer requirementCount;

    @Schema(description = "Task quantity.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer taskCount;

    @Schema(description = "Defect quantity.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer defectCount;

    @Schema(description = "Sprint quantity.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer iterationCount;

}
