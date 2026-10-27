package cn.iocoder.yudao.module.im.controller.admin.message.vo.privates;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 私聊消息 Response VO
 */
@Schema(description = "Admin - direct message response.")
@Data
public class ImPrivateMessageRespVO {

    @Schema(description = "Message code.", example = "1")
    private Long id;

    @Schema(description = "Clientmessage code.", example = "uuid-xxx")
    private String clientMessageId;

    @Schema(description = "Send person code.", example = "1")
    private Long senderId;

    @Schema(description = "Recipient code.", example = "2")
    private Long receiverId;

    @Schema(description = "Message type.", example = "0")
    private Integer type;

    @Schema(description = "Message content.", example = "{\"content\":\"Hello\"}")
    private String content;

    @Schema(description = "Message status.", example = "0")
    private Integer status; // See ImMessageStatusEnum enum class

    @Schema(description = "Receipt status.", example = "0")
    private Integer receiptStatus; // See ImMessageReceiptStatusEnum enum class

    @Schema(description = "Send time.")
    private LocalDateTime sendTime;

}
