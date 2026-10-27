package cn.iocoder.yudao.module.im.controller.admin.message.vo.group;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 群聊消息 Response VO
 */
@Schema(description = "Admin - group chat message response.")
@Data
public class ImGroupMessageRespVO {

    @Schema(description = "Message code.", example = "1")
    private Long id;

    @Schema(description = "Clientmessage code.", example = "uuid-xxx")
    private String clientMessageId;

    @Schema(description = "Send person code.", example = "1")
    private Long senderId;

    @Schema(description = "Group ID", example = "1")
    private Long groupId;

    @Schema(description = "Message type.", example = "0")
    private Integer type;

    @Schema(description = "Message content.", example = "{\"content\":\"Hello\"}")
    private String content;

    @Schema(description = "Message status.", example = "0")
    private Integer status;

    @Schema(description = "Send time.")
    private LocalDateTime sendTime;

    @Schema(description = "@ target user ID list.", example = "[1,2,3]")
    private List<Long> atUserIds;

    @Schema(description = "Targeted recipients User ID list.", example = "[1,2]")
    private List<Long> receiverUserIds;

    @Schema(description = "Receipt status.", example = "0")
    private Integer receiptStatus;

    @Schema(description = "Read count. Set for receipt messages sent by the current user.", example = "3")
    private Integer readCount;

}
