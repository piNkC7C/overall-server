package cn.iocoder.yudao.module.ai.controller.admin.chat.vo.conversation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "AI chat conversation create [ my ] request VO.")
@Data
public class AiChatConversationCreateMyReqVO {

    @Schema(description = "Chat role ID.", example = "666")
    private Long roleId;

    @Schema(description = "Knowledge base code.", example = "1204")
    private Long knowledgeId;

}
