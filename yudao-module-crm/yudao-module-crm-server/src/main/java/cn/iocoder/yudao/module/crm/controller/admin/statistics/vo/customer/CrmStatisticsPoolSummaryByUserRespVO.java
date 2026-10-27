package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "CRM pool-customer analysis (by user) VO.")
@Data
public class CrmStatisticsPoolSummaryByUserRespVO extends CrmStatisticsCustomerByUserBaseRespVO {

    @Schema(description = "Customers Moved to Pool", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer customerPutCount;

    @Schema(description = "Customers Claimed from Pool", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer customerTakeCount;

}
