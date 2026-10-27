package cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - HRM performance plan StageStats response.")
@Data
public class HrmPerformancePlanStageCountRespVO {

    @Schema(description = "Stage status.")
    private Integer stageType;

    @Schema(description = "Quantity.")
    private Long count;

}
