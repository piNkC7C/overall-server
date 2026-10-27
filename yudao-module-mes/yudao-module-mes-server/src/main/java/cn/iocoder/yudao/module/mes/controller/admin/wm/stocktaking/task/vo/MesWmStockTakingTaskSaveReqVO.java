package cn.iocoder.yudao.module.mes.controller.admin.wm.stocktaking.task.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES stocktake task create / edit request.")
@Data
public class MesWmStockTakingTaskSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ST202603080001")
    @NotEmpty(message = "Task code is required.")
    private String code;

    @Schema(description = "Task name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Raw-warehouse monthly count")
    @NotEmpty(message = "Task name is required.")
    private String name;

    @Schema(description = "Stocktake Date.")
    private LocalDateTime takingDate;

    @Schema(description = "Stocktake type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Stocktake type is required.")
    private Integer type;

    @Schema(description = "Stocktake person ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Stocktake person is required.")
    private Long userId;

    @Schema(description = "Source plan ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Source plan is required.")
    private Long planId;

    @Schema(description = "Start time.")
    private LocalDateTime startTime;

    @Schema(description = "End time.")
    private LocalDateTime endTime;

    @Schema(description = "Blind Count", example = "false")
    @NotNull(message = "Blind Count is required.")
    private Boolean blindFlag;

    @Schema(description = "Is not freeze inventory.", example = "false")
    @NotNull(message = "Is not freeze inventory is required.")
    private Boolean frozen;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
