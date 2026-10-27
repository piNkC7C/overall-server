package cn.iocoder.yudao.module.im.controller.admin.rtc.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Schema(description = "Add-invitees-during-call request VO. Group calls only.")
@Data
public class ImRtcCallInviteReqVO {

    @Schema(description = "Business call code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "f47ac10b58cc4372a567")
    @NotBlank(message = "Call code is required.")
    private String room;

    @Schema(description = "Newly invited user IDs.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Select at least one member.")
    private Set<@NotNull(message = "Invitee user ID cannot be empty.") Long> inviteeIds;

}
