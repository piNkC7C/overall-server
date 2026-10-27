package cn.iocoder.yudao.module.hrm.controller.admin.portal.performance.vo.review;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "HRM employee performance score preview response VO.")
@Data
public class HrmPortalPerformanceScorePreviewRespVO {

    @Schema(description = "Stagescore.")
    private BigDecimal stageScore;

    @Schema(description = "Stage result level.")
    private String stageResultLevel;

    @Schema(description = "Current total score.")
    private BigDecimal cumulativeScore;

    @Schema(description = "Current result grade. Returned when all scoring stages are done.")
    private String cumulativeResultLevel;

}
