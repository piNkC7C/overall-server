package cn.iocoder.yudao.module.ai.controller.admin.chat.vo.conversation;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "AI chat conversation update [ my ] request VO.")
@Data
public class AiChatConversationUpdateMyReqVO {

    @Schema(description = "Conversation ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Conversation ID is required.")
    private Long id;

    @Schema(description = "Conversation title.", example = "Me is one title.")
    private String title;

    @Schema(description = "Is not Pin.", example = "true")
    private Boolean pinned;

    @Schema(description = "Model code.", example = "1")
    private Long modelId;

    @Schema(description = "Knowledge base code.", example = "1")
    private Long knowledgeId;

    @Schema(description = "Role Prompt", example = "A happy programmer")
    private String systemMessage;

    @Schema(description = "Temperature", example = "0.8")
    private Double temperature;

    @Schema(description = "Maximum tokens per reply.", example = "4096")
    private Integer maxTokens;

    @Schema(description = "Maximum context messages.", example = "10")
    private Integer maxContexts;

}
