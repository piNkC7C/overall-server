package cn.iocoder.yudao.module.im.controller.admin.manager.group.vo.member;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "IM group member response VO.")
@Data
public class ImGroupMemberManagerRespVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long userId;

    @Schema(description = "Nickname", example = "John.")
    private String nickname;

    @Schema(description = "UserAvatar.")
    private String avatar;

    @Schema(description = "Display name in group.", example = "Sam")
    private String displayUserName;

    @Schema(description = "Group remark.", example = "Tech group")
    private String groupRemark;

    @Schema(description = "Is not Do Not Disturb.", example = "false")
    private Boolean silent;

    @Schema(description = "Member status.", example = "0")
    private Integer status; // See CommonStatusEnum enum class

    @Schema(description = "Member role. 1=owner, 2=admin, 3=member.", example = "3")
    private Integer role; // See ImGroupMemberRoleEnum enum class

    @Schema(description = "Join time.")
    private LocalDateTime joinTime;

    @Schema(description = "Leave time.")
    private LocalDateTime quitTime;

    @Schema(description = "Mute until.")
    private LocalDateTime muteEndTime;

}
