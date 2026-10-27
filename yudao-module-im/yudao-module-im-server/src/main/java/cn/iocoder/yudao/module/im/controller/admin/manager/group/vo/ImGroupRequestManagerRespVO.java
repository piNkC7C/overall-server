package cn.iocoder.yudao.module.im.controller.admin.manager.group.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - IM join-group request response.")
@Data
public class ImGroupRequestManagerRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Group ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long groupId;

    @Schema(description = "Group name", example = "Demo tech group")
    private String groupName;

    @Schema(description = "Applicant / inviteeuser ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Long userId;

    @Schema(description = "Applicant / inviteeNickname.", example = "John.")
    private String userNickname;

    @Schema(description = "Inviter user ID. Null means the user applied.", example = "200")
    private Long inviterUserId;

    @Schema(description = "InviterNickname.", example = "John")
    private String inviterNickname;

    @Schema(description = "Apply please reason.", example = "I want to join this group")
    private String applyContent;

    @Schema(description = "Join source.", example = "1")
    private Integer addSource; // See ImGroupAddSourceEnum enum class

    @Schema(description = "Process result.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer handleResult; // See ImGroupRequestHandleResultEnum enum class

    @Schema(description = "Process person user ID.", example = "31460")
    private Long handleUserId;

    @Schema(description = "Process person Nickname.", example = "Admin.")
    private String handleNickname;

    @Schema(description = "Process reason.", example = "Not approved yet")
    private String handleContent;

    @Schema(description = "Process time.")
    private LocalDateTime handleTime;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
