package cn.iocoder.yudao.module.im.controller.admin.manager.message.vo.group;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - IM group chat message response.")
@Data
public class ImGroupMessageManagerRespVO {

    @Schema(description = "Message code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Clientmessage code.", example = "c-uuid-xxx")
    private String clientMessageId;

    @Schema(description = "Group ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long groupId;

    @Schema(description = "Group name", example = "Tech group")
    private String groupName;

    @Schema(description = "Send person code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long senderId;

    @Schema(description = "Send person Nickname.", example = "John.")
    private String senderNickname;

    @Schema(description = "Message type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type; // See ImContentTypeEnum enum class

    @Schema(description = "Message content (JSON).", requiredMode = Schema.RequiredMode.REQUIRED)
    private String content;

    @Schema(description = "Message status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status; // See ImMessageStatusEnum enum class

    @Schema(description = "@ target user IDs. -1 means @everyone.")
    private List<Long> atUserIds;
    @Schema(description = "@ target nicknames. The -1 slot is null; the client shows \"@everyone\" from atUserIds.")
    private List<String> atUserNicknames;

    @Schema(description = "Receipt status.", example = "0")
    private Integer receiptStatus; // See ImMessageReceiptStatusEnum enum class

    @Schema(description = "Send time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime sendTime;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
