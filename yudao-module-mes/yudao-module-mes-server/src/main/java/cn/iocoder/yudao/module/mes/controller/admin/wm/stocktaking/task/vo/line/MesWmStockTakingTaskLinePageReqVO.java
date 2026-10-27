package cn.iocoder.yudao.module.mes.controller.admin.wm.stocktaking.task.vo.line;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - stocktake task line page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmStockTakingTaskLinePageReqVO extends PageParam {

    @Schema(description = "Stocktake task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long taskId;

}
