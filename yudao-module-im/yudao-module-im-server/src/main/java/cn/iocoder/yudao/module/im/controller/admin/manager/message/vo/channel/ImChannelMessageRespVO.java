package cn.iocoder.yudao.module.im.controller.admin.manager.message.vo.channel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - IM Channelmessage response.")
@Data
public class ImChannelMessageRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Channel ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long channelId;

    @Schema(description = "Channel name (joined).")
    private String channelName;

    @Schema(description = "Media code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long materialId;

    @Schema(description = "Media title, filled by join query.")
    private String materialTitle;

    @Schema(description = "Media cover URL, filled by join query.")
    private String materialCoverUrl;

    @Schema(description = "Message type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "125")
    private Integer type; // See ImContentTypeEnum enum class

    @Schema(description = "Message content. Payload JSON snapshot.")
    private String content;

    @Schema(description = "Recipient IDs. Empty means everyone.")
    private List<Long> receiverUserIds;

    @Schema(description = "Send time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime sendTime;

}
