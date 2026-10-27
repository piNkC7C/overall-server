package cn.iocoder.yudao.module.im.controller.admin.manager.friend.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - IM contact apply please response.")
@Data
public class ImFriendRequestManagerRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Initiatoruser ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long fromUserId;

    @Schema(description = "InitiatorNickname.", example = "John.")
    private String fromNickname;

    @Schema(description = "Recipient user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long toUserId;

    @Schema(description = "Recipient nickname.", example = "Jane.")
    private String toNickname;

    @Schema(description = "Apply please reason.", example = "Me is Overall.")
    private String applyContent;

    @Schema(description = "Requester remark for the recipient.")
    private String displayName;

    @Schema(description = "Add source.", example = "1")
    private Integer addSource; // See ImFriendAddSourceEnum enum class

    @Schema(description = "Process result.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer handleResult; // See ImFriendRequestHandleResultEnum enum class

    @Schema(description = "Process reason.", example = "Not approved yet")
    private String handleContent;

    @Schema(description = "Process time.")
    private LocalDateTime handleTime;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
