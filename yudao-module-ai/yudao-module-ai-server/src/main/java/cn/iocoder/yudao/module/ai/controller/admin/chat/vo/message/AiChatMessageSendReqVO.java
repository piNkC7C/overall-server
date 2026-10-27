package cn.iocoder.yudao.module.ai.controller.admin.chat.vo.message;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "AI chat message send request VO.")
@Data
public class AiChatMessageSendReqVO {

    @Schema(description = "Chat conversation ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Chat conversation ID cannot be empty.")
    private Long conversationId;

    @Schema(description = "Chat content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Help me write a Java algorithm")
    @NotEmpty(message = "Chat content cannot be empty.")
    private String content;

    @Schema(description = "Include context.", example = "true")
    private Boolean useContext;

    @Schema(description = "Web search.", example = "true")
    private Boolean useSearch;

    @Schema(description = "Attachment URL Array.", example = "https://www.iocoder.cn/1.png")
    private List<String> attachmentUrls;

}
