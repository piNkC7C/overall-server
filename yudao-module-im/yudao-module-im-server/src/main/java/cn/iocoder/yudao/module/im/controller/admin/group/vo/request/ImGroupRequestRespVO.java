package cn.iocoder.yudao.module.im.controller.admin.group.vo.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - IM join-group request response.")
@Data
public class ImGroupRequestRespVO {

    @Schema(description = "Apply please code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Group ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long groupId;

    @Schema(description = "Applicant / inviteeuser ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Long userId;

    @Schema(description = "Inviter user ID. Null means the user applied.", example = "200")
    private Long inviterUserId;

    @Schema(description = "Process result.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer handleResult; // See ImGroupRequestHandleResultEnum enum

    @Schema(description = "Apply please reason.", example = "I want to join this group")
    private String applyContent;

    @Schema(description = "Handle reason. Optional when rejecting.", example = "Not approved yet")
    private String handleContent;

    @Schema(description = "Process person user ID.", example = "31460")
    private Long handleUserId;

    @Schema(description = "Join source.", example = "1")
    private Integer addSource; // See ImGroupAddSourceEnum enum

    @Schema(description = "Process time.")
    private LocalDateTime handleTime;

    @Schema(description = "Apply please create time.")
    private LocalDateTime createTime;

    @Schema(description = "Request update time. Incremental-fetch cursor.")
    private LocalDateTime updateTime;

    // ========== 下面是聚合字段，方便前端显示 ==========

    @Schema(description = "Applicant/invitee nickname, live-aggregated from AdminUser.", example = "Overall.")
    private String userNickname;

    @Schema(description = "Applicant/invitee avatar, live-aggregated from AdminUser.")
    private String userAvatar;

    @Schema(description = "Inviter nickname, live-aggregated from AdminUser.", example = "John")
    private String inviterNickname;

    @Schema(description = "Inviter avatar, live-aggregated from AdminUser.")
    private String inviterAvatar;

    @Schema(description = "Group name, live-aggregated from ImGroup.", example = "Demo tech group")
    private String groupName;

    @Schema(description = "Group avatar, live-aggregated from ImGroup.")
    private String groupAvatar;

}
