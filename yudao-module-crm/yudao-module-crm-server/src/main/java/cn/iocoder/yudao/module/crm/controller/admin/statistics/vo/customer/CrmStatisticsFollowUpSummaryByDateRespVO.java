package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "CRM follow-up count analysis (by date) VO.")
@Data
public class CrmStatisticsFollowUpSummaryByDateRespVO {

    @Schema(description = "Timeline", requiredMode = Schema.RequiredMode.REQUIRED, example = "202401")
    private String time;

    @Schema(description = "Follow-up Count", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer followUpRecordCount;

    @Schema(description = "Followed Customers", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer followUpCustomerCount;

}
