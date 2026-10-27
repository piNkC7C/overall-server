package cn.iocoder.yudao.module.im.controller.admin.manager.rtc.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - IM call record response.")
@Data
public class ImRtcCallManagerRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Business call code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "uuid-xxx")
    private String room;

    @Schema(description = "Conversation type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer conversationType; // See ImConversationTypeEnum enum class

    @Schema(description = "Media Type", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer mediaType; // See ImRtcCallMediaTypeEnum enum class

    @Schema(description = "Start person user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long inviterUserId;

    @Schema(description = "Start person Nickname.", example = "John.")
    private String inviterNickname;

    @Schema(description = "Group ID. Empty for DMs.", example = "999")
    private Long groupId;

    @Schema(description = "Group name. Empty for DMs.", example = "Test group")
    private String groupName;

    @Schema(description = "Call status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer status; // See ImRtcCallStatusEnum enum class

    @Schema(description = "End reason.", example = "1")
    private Integer endReason; // See ImRtcCallEndReasonEnum enum class

    @Schema(description = "Start time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime startTime;

    @Schema(description = "Connect time. Empty if not connected.")
    private LocalDateTime acceptTime;

    @Schema(description = "End time; not end is empty.")
    private LocalDateTime endTime;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
