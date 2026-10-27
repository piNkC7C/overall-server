package cn.iocoder.yudao.module.mes.controller.admin.cal.plan.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES schedule plan create / edit request.")
@Data
public class MesCalPlanSaveReqVO {

    @Schema(description = "Plan code.", example = "1024")
    private Long id;

    @Schema(description = "Plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "PLAN001")
    @NotEmpty(message = "Plan code is required.")
    private String code;

    @Schema(description = "Plan name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024Year schedule plan.")
    @NotEmpty(message = "Plan name is required.")
    private String name;

    @Schema(description = "Team type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Team type is required.")
    private Integer calendarType;

    @Schema(description = "Start Date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Start Date is required.")
    private LocalDateTime startDate;

    @Schema(description = "End Date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "End Date is required.")
    private LocalDateTime endDate;

    @Schema(description = "Rotation method.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Rotation method is required.")
    private Integer shiftType;

    @Schema(description = "Shift rotation method.", example = "1")
    private Integer shiftMethod;

    @Schema(description = "Shift rotation days.", example = "7")
    private Integer shiftCount;

    @Schema(description = "Status.", example = "0")
    private Integer status;

    @Schema(description = "Notes.")
    private String remark;

    }
