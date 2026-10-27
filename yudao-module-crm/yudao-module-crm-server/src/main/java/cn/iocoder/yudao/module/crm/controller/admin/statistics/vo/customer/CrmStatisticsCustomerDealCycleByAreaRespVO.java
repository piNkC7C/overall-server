package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "CRM customer deal-cycle analysis by region VO.")
@Data
public class CrmStatisticsCustomerDealCycleByAreaRespVO {

    @Schema(description = "Province ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @JsonIgnore
    private Integer areaId;

    @Schema(description = "Province name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Zhejiang")
    private String areaName;

    @Schema(description = "Win cycle.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1.0")
    private Double customerDealCycle;

    @Schema(description = "Won Customers", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer customerDealCount;

}
