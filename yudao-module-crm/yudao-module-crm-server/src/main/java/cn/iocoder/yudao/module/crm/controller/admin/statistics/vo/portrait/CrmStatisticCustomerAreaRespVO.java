package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.portrait;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "CRM customer province analysis VO.")
@Data
public class CrmStatisticCustomerAreaRespVO {

    @Schema(description = "Province ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer areaId;
    @Schema(description = "Province name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Zhejiang")
    private String areaName;

    @Schema(description = "Customers", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer customerCount;

    @Schema(description = "Won Deals", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer dealCount;

}
