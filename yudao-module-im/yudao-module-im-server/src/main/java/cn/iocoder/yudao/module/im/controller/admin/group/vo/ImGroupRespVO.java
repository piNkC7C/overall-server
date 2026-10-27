package cn.iocoder.yudao.module.im.controller.admin.group.vo;

import cn.iocoder.yudao.module.im.controller.admin.message.vo.group.ImGroupMessageRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Group response VO.")
@Data
public class ImGroupRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1003")
    private Long id;

    @Schema(description = "Group name", example = "Overall.")
    private String name;

    @Schema(description = "Group Owner user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "31460")
    private Long ownerUserId;

    @Schema(description = "Group avatar.")
    private String avatar;

    @Schema(description = "Group announcement.")
    private String notice;

    @Schema(description = "Banned.")
    private Boolean banned;

    @Schema(description = "Mute the whole group.")
    private Boolean mutedAll;

    @Schema(description = "Join requires owner or admin approval.", example = "false")
    private Boolean joinApproval;

    @Schema(description = "Ban time.")
    private LocalDateTime bannedTime;

    @Schema(description = "Group status.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer status;

    @Schema(description = "Disband time.")
    private LocalDateTime dissolvedTime;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Current user's membership: in group or left. Left groups are still returned so the client can show name/avatar for offline messages.")
    private Integer joinStatus; // See CommonStatusEnum enum

    @Schema(description = "Current user's remark for this group.")
    private String groupRemark;

    @Schema(description = "Current sign-in user is not Do Not Disturb.")
    private Boolean silent;

    @Schema(description = "Pinned group messages in pin order (first pinned first). Empty if not an active member.")
    private List<ImGroupMessageRespVO> pinnedMessages;

}
