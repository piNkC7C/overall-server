package cn.iocoder.yudao.module.mes.controller.admin.wm.stocktaking.task.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - MES stocktake taskcomplete request.")
@Data
public class MesWmStockTakingTaskFinishReqVO {

    @Schema(description = "Task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Task code is required.")
    private Long id;

}
