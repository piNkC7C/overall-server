package cn.iocoder.yudao.module.pms.controller.admin.pm.project.vo.member;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - PMS item member response.")
@Data
public class PmsProjectMemberRespVO {

    @Schema(description = "Admin user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long userId;

    @Schema(description = "Nickname", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String nickname;

    @Schema(description = "UserAvatar.")
    private String avatar;

    @Schema(description = "Member permission level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Integer level;

    @Schema(description = "Is not item creator.", example = "true")
    private Boolean creatorStatus;

}
