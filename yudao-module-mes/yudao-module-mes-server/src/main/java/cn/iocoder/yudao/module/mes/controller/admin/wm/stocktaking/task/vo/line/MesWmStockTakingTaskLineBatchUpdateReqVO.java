package cn.iocoder.yudao.module.mes.controller.admin.wm.stocktaking.task.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "Admin - MES stocktake task line batch update request.")
@Data
public class MesWmStockTakingTaskLineBatchUpdateReqVO {

    @Schema(description = "Task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Task code is required.")
    private Long taskId;

    @Schema(description = "Task line list.")
    @NotEmpty(message = "Task line is required.")
    @Valid
    private List<Item> items;

    @Data
    public static class Item {

        @Schema(description = "Task line code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Task line code is required.")
        private Long id;

        @Schema(description = "Counted quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "98.000000")
        @NotNull(message = "Counted quantity cannot be empty.")
        private BigDecimal takingQuantity;

        @Schema(description = "Notes.", example = "Notes.")
        private String remark;

    }

}
