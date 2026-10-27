package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.funnel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "CRM new-opportunity analysis (by date) VO.")
@Data
public class CrmStatisticsBusinessSummaryByDateRespVO {

    @Schema(description = "Timeline", requiredMode = Schema.RequiredMode.REQUIRED, example = "202401")
    private String time;

    @Schema(description = "Create opportunity quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long businessCreateCount;

    @Schema(description = "Create opportunity amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private BigDecimal totalPrice;

}
