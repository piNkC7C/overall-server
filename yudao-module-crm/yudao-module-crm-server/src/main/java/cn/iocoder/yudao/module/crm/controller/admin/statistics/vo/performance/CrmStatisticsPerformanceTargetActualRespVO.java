package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.performance;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Schema(description = "Quota actuals response VO.")
@Data
@Accessors(chain = true)
public class CrmStatisticsPerformanceTargetActualRespVO {

    @Schema(description = "Month", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer month;

    @Schema(description = "Complete amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8000.00")
    private BigDecimal currentPrice;

}
