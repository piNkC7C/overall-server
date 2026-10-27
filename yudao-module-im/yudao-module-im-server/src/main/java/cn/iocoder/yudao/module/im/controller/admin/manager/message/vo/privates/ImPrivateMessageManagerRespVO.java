package cn.iocoder.yudao.module.im.controller.admin.manager.message.vo.privates;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - IM direct message response.")
@Data
public class ImPrivateMessageManagerRespVO {

    @Schema(description = "Message code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Clientmessage code.", example = "c-uuid-xxx")
    private String clientMessageId;

    @Schema(description = "Send person code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long senderId;

    @Schema(description = "Send person Nickname.", example = "John.")
    private String senderNickname;

    @Schema(description = "Recipient code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long receiverId;

    @Schema(description = "RecipientNickname.", example = "Jane.")
    private String receiverNickname;

    @Schema(description = "Message type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type; // See ImContentTypeEnum enum class

    @Schema(description = "Message content (JSON).", requiredMode = Schema.RequiredMode.REQUIRED)
    private String content;

    @Schema(description = "Message status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status; // See ImMessageStatusEnum enum class

    @Schema(description = "Receipt status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer receiptStatus; // See ImMessageReceiptStatusEnum enum class

    @Schema(description = "Send time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime sendTime;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
