package cn.iocoder.yudao.module.mes.controller.admin.cal.plan.vo.team;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - MES plan team relation create request.")
@Data
public class MesCalPlanTeamSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Schedule plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Schedule plan is required.")
    private Long planId;

    @Schema(description = "Team code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Team is required.")
    private Long teamId;

    @Schema(description = "Notes.")
    private String remark;

    }
