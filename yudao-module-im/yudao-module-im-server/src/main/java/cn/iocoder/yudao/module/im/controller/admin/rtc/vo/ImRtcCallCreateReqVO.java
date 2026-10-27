package cn.iocoder.yudao.module.im.controller.admin.rtc.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.im.enums.ImConversationTypeEnum;
import cn.iocoder.yudao.module.im.enums.rtc.ImRtcCallMediaTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Schema(description = "Admin - create call request.")
@Data
public class ImRtcCallCreateReqVO {

    @Schema(description = "Conversation type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Conversation type is required.")
    @InEnum(ImConversationTypeEnum.class)
    private Integer conversationType;

    @Schema(description = "Media Type", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Media Type is required.")
    @InEnum(ImRtcCallMediaTypeEnum.class)
    private Integer mediaType;

    @Schema(description = "Group ID. Required for group chat.", example = "2048")
    private Long groupId;

    @Schema(description = "Invited user IDs. DMs require one peer. Group calls require at least one user.")
    private Set<@NotNull(message = "Invitee user ID cannot be empty.") Long> inviteeIds;

    /**
     * 通话仅支持私聊和群聊
     */
    @AssertTrue(message = "Conversation type not support.")
    @JsonIgnore
    public boolean isConversationTypeSupported() {
        return conversationType == null || ImConversationTypeEnum.isPrivate(conversationType)
                || ImConversationTypeEnum.isGroup(conversationType);
    }

}
