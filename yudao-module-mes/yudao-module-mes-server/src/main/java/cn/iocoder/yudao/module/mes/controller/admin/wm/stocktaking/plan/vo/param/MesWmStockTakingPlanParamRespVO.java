package cn.iocoder.yudao.module.mes.controller.admin.wm.stocktaking.plan.vo.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - MES stocktake plan parameter response.")
@Data
public class MesWmStockTakingPlanParamRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Plan ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long planId;

    @Schema(description = "Parameter type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "102")
    private Integer type;

    @Schema(description = "Parameter value ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long valueId;

    @Schema(description = "ParameterValuecode.", example = "WH001")
    private String valueCode;

    @Schema(description = "ParameterValuename.", example = "Raw Materials.")
    private String valueName;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
