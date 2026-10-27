package cn.iocoder.yudao.module.mes.controller.admin.wm.stocktaking.task.vo.result;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Admin - MES stocktake result page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class MesWmStockTakingTaskResultPageReqVO extends PageParam {

    @Schema(description = "Task code.", example = "1")
    private Long taskId;

    @Schema(description = "Material code.", example = "1")
    private Long itemId;

    @Schema(description = "Warehouse code.", example = "1")
    private Long warehouseId;

    @Schema(description = "Zone code.", example = "1")
    private Long locationId;

    @Schema(description = "Bin code.", example = "1")
    private Long areaId;

}
