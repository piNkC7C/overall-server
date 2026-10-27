package cn.iocoder.yudao.module.mes.controller.admin.cal.team.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - MES team create / edit request.")
@Data
public class MesCalTeamSaveReqVO {

    @Schema(description = "Team code.", example = "1024")
    private Long id;

    @Schema(description = "Team code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "TEAM-A")
    @NotEmpty(message = "Team code is required.")
    private String code;

    @Schema(description = "Team name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Injection team A")
    @NotEmpty(message = "Team name is required.")
    private String name;

    @Schema(description = "Team type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Team type is required.")
    private Integer calendarType;

    @Schema(description = "Notes.")
    private String remark;

}
