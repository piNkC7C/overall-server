package cn.iocoder.yudao.module.mes.controller.admin.cal.team.vo.member;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES team member response.")
@Data
public class MesCalTeamMemberRespVO {

    @Schema(description = "Team member code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Team code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "201")
    private Long teamId;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long userId;

    @Schema(description = "Nickname", example = "Admin.")
    private String nickname;

    @Schema(description = "Phone", example = "13800138000")
    private String telephone;

    @Schema(description = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
