package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "CRM deal-cycle analysis by user VO.")
@Data
public class CrmStatisticsCustomerDealCycleByUserRespVO extends CrmStatisticsCustomerByUserBaseRespVO {

    @Schema(description = "Win cycle.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1.0")
    private Double customerDealCycle;

    @Schema(description = "Won Customers", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer customerDealCount;

}
