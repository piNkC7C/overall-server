package cn.iocoder.yudao.module.ai.controller.admin.chat.vo.message;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "管理后台 - AI 聊天消息发送 Request VO")
@Data
public class AiChatMessageSendReqVO {

    @Schema(description = "聊天对话编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Chat conversation ID cannot be empty.")
    private Long conversationId;

    @Schema(description = "聊天内容", requiredMode = Schema.RequiredMode.REQUIRED, example = "Help me write a Java algorithm")
    @NotEmpty(message = "Chat content cannot be empty.")
    private String content;

    @Schema(description = "是否携带上下文", example = "true")
    private Boolean useContext;

    @Schema(description = "是否联网搜索", example = "true")
    private Boolean useSearch;

    @Schema(description = "附件 URL 数组", example = "https://www.iocoder.cn/1.png")
    private List<String> attachmentUrls;

}
