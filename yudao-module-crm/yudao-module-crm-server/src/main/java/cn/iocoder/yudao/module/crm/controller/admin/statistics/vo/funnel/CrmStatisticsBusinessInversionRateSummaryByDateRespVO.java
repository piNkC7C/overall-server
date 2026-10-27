package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.funnel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "CRM opportunity conversion analysis by date VO.")
@Data
public class CrmStatisticsBusinessInversionRateSummaryByDateRespVO {

    @Schema(description = "Timeline", requiredMode = Schema.RequiredMode.REQUIRED, example = "202401")
    private String time;

    @Schema(description = "Opportunity quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long businessCount;

    @Schema(description = "Won opportunities.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long businessWinCount;

}
