package cn.iocoder.yudao.module.ai.controller.admin.chat.vo.message;

import cn.iocoder.yudao.module.ai.framework.ai.core.webserch.AiWebSearchResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "AI chat message send response VO.")
@Data
public class AiChatMessageSendRespVO {

    @Schema(description = "Send message.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Message send;

    @Schema(description = "Receivemessage.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Message receive;

    @Schema(description = "Message.")
    @Data
    public static class Message {

        @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long id;

        @Schema(description = "Message type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "role")
        private String type; // See MessageType enum class

        @Schema(description = "Chat content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Hello, hello")
        private String content;

        @Schema(description = "Reasoning content.", example = "To reach this goal, you need...")
        private String reasoningContent;

        @Schema(description = "Knowledge basesegmentIDArray.", example = "[1,2,3]")
        private List<Long> segmentIds;

        @Schema(description = "Knowledge basesegmentArray.")
        private List<AiChatMessageRespVO.KnowledgeSegment> segments;

        @Schema(description = "Web search results.")
        private List<AiWebSearchResponse.WebPage> webSearchPages;

        @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
        private LocalDateTime createTime;

    }

}
