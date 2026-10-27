package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.portrait;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "CRM customer-source analysis VO.")
@Data
public class CrmStatisticCustomerSourceRespVO {

    @Schema(description = "Customer source code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer source;

    @Schema(description = "Customers", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer customerCount;

    @Schema(description = "Won Deals", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer dealCount;

}
