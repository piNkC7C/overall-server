package cn.iocoder.yudao.module.mes.controller.admin.wm.stocktaking.plan.vo.param;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES stocktake plan parameter page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmStockTakingPlanParamPageReqVO extends PageParam {

    @Schema(description = "Plan ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Plan ID is required.")
    private Long planId;

}
