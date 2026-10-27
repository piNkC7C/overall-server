package cn.iocoder.yudao.module.mes.controller.admin.cal.team.vo.member;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - MES team member create request.")
@Data
public class MesCalTeamMemberSaveReqVO {

    @Schema(description = "Team member code.", example = "1024")
    private Long id;

    @Schema(description = "Team code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "201")
    @NotNull(message = "Team code is required.")
    private Long teamId;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "User ID is required.")
    private Long userId;

    @Schema(description = "Notes.")
    private String remark;

    }
