package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "CRM customer-volume analysis (by user) VO.")
@Data
public class CrmStatisticsCustomerSummaryByUserRespVO extends CrmStatisticsCustomerByUserBaseRespVO {

    @Schema(description = "New customers.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer customerCreateCount;

    @Schema(description = "Won Customers", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer customerDealCount;

    @Schema(description = "Contract total.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    private BigDecimal contractPrice;

    @Schema(description = "Collection amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    private BigDecimal receivablePrice;

}
