package cn.iocoder.yudao.module.ai.controller.admin.model.vo.chatRole;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.util.List;

@Schema(description = "AI chat persona create / update [ my ] request VO.")
@Data
public class AiChatRoleSaveMyReqVO {

    @Schema(description = "Role code.", example = "32746")
    private Long id;

    @Schema(description = "Role name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @NotEmpty(message = "Role name is required.")
    private String name;

    @Schema(description = "RoleAvatar.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/1.png")
    @NotEmpty(message = "RoleAvatar is required.")
    @URL(message = "RoleAvatar must be URL format.")
    private String avatar;

    @Schema(description = "RoleDescription.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Looks good.")
    @NotEmpty(message = "RoleDescription is required.")
    private String description;

    @Schema(description = "Role Prompt", requiredMode = Schema.RequiredMode.REQUIRED, example = "From now on you are a programmer. You are an excellent engineer with strong logic and always solve problems efficiently.")
    @NotEmpty(message = "Role Prompt is required.")
    private String systemMessage;

    @Schema(description = "Referenced knowledge base code list.", example = "1,2,3")
    private List<Long> knowledgeIds;

    @Schema(description = "Referenced tool code list.", example = "1,2,3")
    private List<Long> toolIds;

    @Schema(description = "Referenced MCP Client name list.", example = "filesystem")
    private List<String> mcpClientNames;

}