package cn.iocoder.yudao.module.mes.controller.admin.wm.stocktaking.plan.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Admin - MES stocktake plan page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class MesWmStockTakingPlanPageReqVO extends PageParam {

    @Schema(description = "Plan code.", example = "STP202603080001")
    private String code;

    @Schema(description = "Plan name.", example = "Raw-warehouse monthly count")
    private String name;

    @Schema(description = "Stocktake type.", example = "1")
    private Integer type;

    @Schema(description = "Status.", example = "0")
    private Integer status;

}
