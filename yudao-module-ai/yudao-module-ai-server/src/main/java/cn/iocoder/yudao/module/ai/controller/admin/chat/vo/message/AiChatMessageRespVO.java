package cn.iocoder.yudao.module.ai.controller.admin.chat.vo.message;

import cn.iocoder.yudao.module.ai.framework.ai.core.webserch.AiWebSearchResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "AI chat message response VO.")
@Data
public class AiChatMessageRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Conversation ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long conversationId;

    @Schema(description = "Reply message code.", example = "1024")
    private Long replyId;

    @Schema(description = "Message type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "role")
    private String type; // See MessageType enum class

    @Schema(description = "User ID.", example = "4096")
    private Long userId;

    @Schema(description = "Role code.", example = "888")
    private Long roleId;

    @Schema(description = "Model key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "gpt-3.5-turbo")
    private String model;

    @Schema(description = "Model code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "123")
    private Long modelId;

    @Schema(description = "Chat content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Hello, hello")
    private String content;

    @Schema(description = "Reasoning content.", example = "To reach this goal, you need...")
    private String reasoningContent;

    @Schema(description = "Include context.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean useContext;

    @Schema(description = "Knowledge basesegmentIDArray.", example = "[1,2,3]")
    private List<Long> segmentIds;

    @Schema(description = "Knowledge basesegmentArray.")
    private List<KnowledgeSegment> segments;

    @Schema(description = "Web search results.")
    private List<AiWebSearchResponse.WebPage> webSearchPages;

    @Schema(description = "Attachment URL Array.", example = "https://www.iocoder.cn/1.png")
    private List<String> attachmentUrls;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024-05-12 12:51")
    private LocalDateTime createTime;

    // ========== 仅在【对话管理】时加载 ==========

    @Schema(description = "Role name.", example = "Yellow")
    private String roleName;

    @Schema(description = "Knowledge basesegment.", example = "Java handbook")
    @Data
    public static class KnowledgeSegment {

        @Schema(description = "SegmentID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long id;

        @Schema(description = "Chunk content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Java handbook")
        private String content;

        @Schema(description = "Document code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "24790")
        private Long documentId;

        @Schema(description = "Document name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Product user guide")
        private String documentName;

    }

}
