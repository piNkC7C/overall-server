package cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - HRM performance reviewplan result level Stats response.")
@Data
public class HrmPerformancePlanResultLevelCountRespVO {

    @Schema(description = "Level name.")
    private String levelName;

    @Schema(description = "Quantity.")
    private Long count;

}
