package cn.iocoder.yudao.module.ai.controller.admin.chat.vo.conversation;

import cn.iocoder.yudao.module.ai.dal.dataobject.model.AiModelDO;
import cn.iocoder.yudao.module.ai.dal.dataobject.model.AiChatRoleDO;
import org.dromara.core.trans.anno.Trans;
import org.dromara.core.trans.constant.TransType;
import org.dromara.core.trans.vo.VO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "AI chat conversation response VO.")
@Data
public class AiChatConversationRespVO implements VO {

    @Schema(description = "Conversation ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long userId;

    @Schema(description = "Conversation title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Me is one title.")
    private String title;

    @Schema(description = "Is not Pin.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean pinned;

    @Schema(description = "Role code.", example = "1")
    @Trans(type = TransType.SIMPLE, target = AiChatRoleDO.class, fields = {"name", "avatar"}, refs = {"roleName", "roleAvatar"})
    private Long roleId;

    @Schema(description = "Model code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @Trans(type = TransType.SIMPLE, target = AiModelDO.class, fields = "name", ref = "modelName")
    private Long modelId;

    @Schema(description = "Model key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ERNIE-Bot-turbo-0922")
    private String model;

    @Schema(description = "Model name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    private String modelName;

    @Schema(description = "Role Prompt", example = "A happy programmer")
    private String systemMessage;

    @Schema(description = "Temperature", requiredMode = Schema.RequiredMode.REQUIRED, example = "0.8")
    private Double temperature;

    @Schema(description = "Maximum tokens per reply.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4096")
    private Integer maxTokens;

    @Schema(description = "Maximum context messages.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer maxContexts;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    // ========== relation role info ==========

    @Schema(description = "RoleAvatar.", example = "https://www.iocoder.cn/1.png")
    private String roleAvatar;

    @Schema(description = "Role name.", example = "Yellow")
    private String roleName;

    // ========== 仅在【对话管理】时加载 ==========

    @Schema(description = "Message quantity.", example = "20")
    private Integer messageCount;

}
