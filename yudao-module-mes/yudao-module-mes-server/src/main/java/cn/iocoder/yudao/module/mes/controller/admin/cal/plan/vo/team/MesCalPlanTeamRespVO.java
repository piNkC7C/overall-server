package cn.iocoder.yudao.module.mes.controller.admin.cal.plan.vo.team;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES plan team relation response.")
@Data
public class MesCalPlanTeamRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Schedule plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long planId;

    @Schema(description = "Team code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long teamId;

    @Schema(description = "Team code.", example = "T001")
    private String teamCode;

    @Schema(description = "Team name.", example = "A group.")
    private String teamName;

    @Schema(description = "Notes.")
    private String remark;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}
