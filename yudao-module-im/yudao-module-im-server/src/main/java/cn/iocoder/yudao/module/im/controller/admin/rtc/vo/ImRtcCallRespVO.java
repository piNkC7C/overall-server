package cn.iocoder.yudao.module.im.controller.admin.rtc.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Set;

@Schema(description = "Call session response VO shared by invite, accept, and refreshToken.")
@Data
public class ImRtcCallRespVO {

    @Schema(description = "Business call code.")
    private String room;

    @Schema(description = "LiveKit Server WebSocket Address; frontend connect.")
    private String livekitUrl;

    @Schema(description = "LiveKit access token. Call refreshToken to reissue when needed.")
    private String token;

    @Schema(description = "Conversation type.")
    private Integer conversationType; // See ImConversationTypeEnum enum class

    @Schema(description = "Media Type")
    private Integer mediaType; // See ImCallMediaTypeEnum enum class

    @Schema(description = "Status.")
    private Integer status; // See ImCallStatusEnum enum class

    @Schema(description = "End reason. Set only when status=ENDED.")
    private Integer endReason; // See ImRtcCallEndReasonEnum enum class

    @Schema(description = "Start person code.")
    private Long inviterId;

    @Schema(description = "Group ID. Group calls only.")
    private Long groupId;

    @Schema(description = "Invitee IDs.")
    private Set<Long> inviteeIds;

    @Schema(description = "Member IDs already in the room.")
    private Set<Long> joinedUserIds;

}
