package cn.iocoder.yudao.module.mes.controller.admin.cal.plan.vo.shift;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - MES plan shift create / edit request.")
@Data
public class MesCalPlanShiftSaveReqVO {

    @Schema(description = "Shift code.", example = "1024")
    private Long id;

    @Schema(description = "Schedule plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Schedule plan is required.")
    private Long planId;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "Shift name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Day shift")
    @NotEmpty(message = "Shift name is required.")
    private String name;

    @Schema(description = "Start time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "08:00")
    @NotEmpty(message = "Start time is required.")
    private String startTime;

    @Schema(description = "End time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "17:00")
    @NotEmpty(message = "End time is required.")
    private String endTime;

    @Schema(description = "Notes.")
    private String remark;

    }
