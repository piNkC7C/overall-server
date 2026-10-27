package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.performance;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;


@Schema(description = "CRM employee performance stats response VO.")
@Data
public class CrmStatisticsPerformanceRespVO {

    @Schema(description = "Timeline", requiredMode = Schema.RequiredMode.REQUIRED, example = "202401")
    private String time;

    @Schema(description = "Current MonthStats result.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private BigDecimal currentMonthCount;

    @Schema(description = "MonthStats result.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private BigDecimal lastMonthCount;

    @Schema(description = "Same period last year.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private BigDecimal lastYearCount;

}
