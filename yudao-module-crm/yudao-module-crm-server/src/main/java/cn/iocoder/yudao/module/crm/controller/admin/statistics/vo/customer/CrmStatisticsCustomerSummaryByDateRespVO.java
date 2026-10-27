package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "CRM customer-volume analysis (by date) VO.")
@Data
public class CrmStatisticsCustomerSummaryByDateRespVO {

    @Schema(description = "Timeline", requiredMode = Schema.RequiredMode.REQUIRED, example = "202401")
    private String time;

    @Schema(description = "New customers.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer customerCreateCount;

    @Schema(description = "Won Customers", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer customerDealCount;

}
