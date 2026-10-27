package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.funnel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Admin - CRM sales funnel response.")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CrmStatisticFunnelSummaryRespVO {

    @Schema(description = "Customer count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long customerCount;

    @Schema(description = "Opportunity count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long businessCount;

    @Schema(description = "Won count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long businessWinCount;

}
