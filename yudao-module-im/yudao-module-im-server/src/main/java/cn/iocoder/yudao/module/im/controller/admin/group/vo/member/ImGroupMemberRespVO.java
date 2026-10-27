package cn.iocoder.yudao.module.im.controller.admin.group.vo.member;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Group member response VO.")
@Data
public class ImGroupMemberRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "17071")
    private Long id;

    @Schema(description = "Group ID", example = "13279")
    private Long groupId;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "21730")
    private Long userId;

    @Schema(description = "Display name in group.", example = "Overall.")
    private String displayUserName;

    @Schema(description = "Group remark.", example = "Core group")
    private String groupRemark;

    @Schema(description = "Is not Do Not Disturb.")
    private Boolean silent;

    @Schema(description = "Member status.", example = "0")
    private Integer status;

    @Schema(description = "Member role.", example = "3")
    private Integer role; // See ImGroupMemberRoleEnum enum class

    @Schema(description = "Join time.")
    private LocalDateTime joinTime;

    @Schema(description = "Leave time.")
    private LocalDateTime quitTime;

    @Schema(description = "Mute until.")
    private LocalDateTime muteEndTime;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    // ========== relation AdminUser field ==========

    @Schema(description = "Nickname", example = "Overall.")
    private String nickname;

    @Schema(description = "UserAvatar.")
    private String avatar;

}