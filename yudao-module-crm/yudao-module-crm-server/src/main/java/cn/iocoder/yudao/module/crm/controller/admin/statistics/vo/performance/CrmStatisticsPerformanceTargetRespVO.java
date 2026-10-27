package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.performance;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Schema(description = "CRM quota completion response VO.")
@Data
@Accessors(chain = true)
public class CrmStatisticsPerformanceTargetRespVO {

    @Schema(description = "Month", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer month;

    @Schema(description = "Target amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10000.00")
    private BigDecimal targetPrice;

    @Schema(description = "Complete amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8000.00")
    private BigDecimal currentPrice;

    @Schema(description = "Completion rate.", requiredMode = Schema.RequiredMode.REQUIRED, example = "80.00")
    private BigDecimal completionRate;

}
