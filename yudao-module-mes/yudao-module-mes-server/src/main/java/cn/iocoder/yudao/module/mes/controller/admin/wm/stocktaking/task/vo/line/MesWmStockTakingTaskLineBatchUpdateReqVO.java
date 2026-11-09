package cn.iocoder.yudao.module.mes.controller.admin.wm.stocktaking.task.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "管理后台 - MES 盘点任务行批量更新 Request VO")
@Data
public class MesWmStockTakingTaskLineBatchUpdateReqVO {

    @Schema(description = "任务编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Task code is required.")
    private Long taskId;

    @Schema(description = "任务行列表")
    @NotEmpty(message = "Task line is required.")
    @Valid
    private List<Item> items;

    @Data
    public static class Item {

        @Schema(description = "任务行编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Task line code is required.")
        private Long id;

        @Schema(description = "实盘数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "98.000000")
        @NotNull(message = "Counted quantity cannot be empty.")
        private BigDecimal takingQuantity;

        @Schema(description = "备注", example = "Notes.")
        private String remark;

    }

}
