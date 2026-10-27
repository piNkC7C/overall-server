package cn.iocoder.yudao.module.promotion.controller.admin.kefu.vo.conversation;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - support conversationPin request.")
@Data
public class KeFuConversationUpdatePinnedReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23202")
    @NotNull(message = "Conversation code is required.")
    private Long id;

    @Schema(description = "Pin in admin.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Pin in admin cannot be empty.")
    private Boolean adminPinned;

}