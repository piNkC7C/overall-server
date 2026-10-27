package cn.iocoder.yudao.module.im.controller.admin.manager.rtc.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "IM call participant response VO.")
@Data
public class ImRtcParticipantManagerRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Call code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long callId;

    @Schema(description = "Participant user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long userId;

    @Schema(description = "Participant nickname.", example = "John.")
    private String userNickname;

    @Schema(description = "Participant role.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer role; // See ImRtcParticipantRoleEnum enum class

    @Schema(description = "Participant status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    private Integer status; // See ImRtcParticipantStatusEnum enum class

    @Schema(description = "Invited time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime inviteTime;

    @Schema(description = "Answer time. Empty if not answered.")
    private LocalDateTime acceptTime;

    @Schema(description = "Leave time. Empty if never joined.")
    private LocalDateTime leaveTime;

}
