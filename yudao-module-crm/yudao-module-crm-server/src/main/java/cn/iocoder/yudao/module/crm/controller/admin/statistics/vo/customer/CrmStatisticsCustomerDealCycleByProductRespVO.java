package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "CRM customer deal-cycle analysis (by product) VO.")
@Data
public class CrmStatisticsCustomerDealCycleByProductRespVO {

    @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Demo product")
    private String productName;

    @Schema(description = "Win cycle.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1.0")
    private Double customerDealCycle;

    @Schema(description = "Won Customers", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer customerDealCount;

}
