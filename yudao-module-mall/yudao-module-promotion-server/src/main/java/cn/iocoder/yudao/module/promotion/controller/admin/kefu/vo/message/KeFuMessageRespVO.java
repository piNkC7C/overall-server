package cn.iocoder.yudao.module.promotion.controller.admin.kefu.vo.message;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Support message response VO.")
@Data
public class KeFuMessageRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23202")
    private Long id;

    @Schema(description = "Conversation code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "12580")
    private Long conversationId;

    @Schema(description = "Send person code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "24571")
    private Long senderId;
    @Schema(description = "Send person Avatar.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://yudao.com/images/avatar.jpg")
    private String senderAvatar;

    @Schema(description = "Send person type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer senderType;

    @Schema(description = "Recipient code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "29124")
    private Long receiverId;

    @Schema(description = "Recipient type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer receiverType;

    @Schema(description = "Message type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer contentType;

    @Schema(description = "Message.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String content;

    @Schema(description = "Is not Read.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Boolean readStatus;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}