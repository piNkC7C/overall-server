package cn.iocoder.yudao.module.mes.controller.admin.wm.stocktaking.plan.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES stocktake plan create / edit request.")
@Data
public class MesWmStockTakingPlanSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "STP202603080001")
    @NotEmpty(message = "Plan code is required.")
    private String code;

    @Schema(description = "Plan name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Raw-warehouse monthly count")
    @NotEmpty(message = "Plan name is required.")
    private String name;

    @Schema(description = "Stocktake type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Stocktake type is required.")
    private Integer type;

    @Schema(description = "Plan start time.")
    private LocalDateTime startTime;

    @Schema(description = "Plan end time.")
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
