package cn.iocoder.yudao.module.promotion.controller.admin.kefu.vo.message;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Send support message request VO.")
@Data
public class KeFuMessageSendReqVO {

    @Schema(description = "Conversation code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "12580")
    @NotNull(message = "Conversation code is required.")
    private Long conversationId;

    @Schema(description = "Message type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Message type is required.")
    private Integer contentType;

    @Schema(description = "Message.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Message is required.")
    private String content;

    // ========== 后端设置的参数，前端无需传递 ==========

    @Schema(description = "Send person code.", example = "24571", hidden = true)
    private Long senderId;
    @Schema(description = "Send person type.", example = "1", hidden = true)
    private Integer senderType;

}