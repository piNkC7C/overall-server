package cn.iocoder.yudao.module.im.controller.admin.message.vo.channel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "IM channel message fetch response VO.")
@Data
public class ImChannelMessagePullRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "9001")
    private Long id;

    @Schema(description = "Channel ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long channelId;

    @Schema(description = "Media code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long materialId;

    @Schema(description = "Message type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "125")
    private Integer type;

    @Schema(description = "Message content. Payload JSON snapshot.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String content;

    @Schema(description = "Current user receipt/read state from the Redis read cursor. Read=DONE, unread=PENDING.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer receiptStatus; // See ImMessageReceiptStatusEnum enum class

    @Schema(description = "Send time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime sendTime;

}
