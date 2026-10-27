package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "CRM customer deal-cycle analysis (by date) VO.")
@Data
public class CrmStatisticsCustomerDealCycleByDateRespVO {

    @Schema(description = "Timeline", requiredMode = Schema.RequiredMode.REQUIRED, example = "202401")
    private String time;

    @Schema(description = "Win cycle.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1.0")
    private Double customerDealCycle;

}
