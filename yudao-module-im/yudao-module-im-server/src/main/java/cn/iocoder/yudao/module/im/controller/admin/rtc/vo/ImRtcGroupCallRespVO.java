package cn.iocoder.yudao.module.im.controller.admin.rtc.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Set;

@Schema(description = "Active group-call response VO. No token. Pill-bar display only.")
@Data
public class ImRtcGroupCallRespVO {

    @Schema(description = "Business call code.")
    private String room;

    @Schema(description = "Group ID")
    private Long groupId;

    @Schema(description = "Media Type")
    private Integer mediaType; // See ImCallMediaTypeEnum enum class

    @Schema(description = "Start person code.")
    private Long inviterId;

    @Schema(description = "User IDs already in the room.")
    private Set<Long> joinedUserIds;

    @Schema(description = "Invitee pool. Used to show pending-join avatars when the pill expands.")
    private Set<Long> inviteeIds;

}
