package cn.iocoder.yudao.module.mes.controller.admin.wm.stocktaking.plan.vo.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - MES stocktake plan parameter create / edit request.")
@Data
public class MesWmStockTakingPlanParamSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Plan ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Plan ID is required.")
    private Long planId;

    @Schema(description = "Parameter type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "102")
    @NotNull(message = "Parameter type is required.")
    private Integer type;

    @Schema(description = "Parameter value ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Parameter value ID cannot be empty.")
    private Long valueId;

    @Schema(description = "ParameterValuecode.", example = "WH001")
    private String valueCode;

    @Schema(description = "ParameterValuename.", example = "Raw Materials.")
    private String valueName;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
