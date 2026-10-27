package cn.iocoder.yudao.module.ai.controller.admin.model.vo.chatRole;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

import java.util.List;

@Schema(description = "AI chat persona create / update request VO.")
@Data
public class AiChatRoleSaveReqVO {

    @Schema(description = "Role code.", example = "32746")
    private Long id;

    @Schema(description = "Model code.", example = "17640")
    private Long modelId;

    @Schema(description = "Role name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @NotEmpty(message = "Role name is required.")
    private String name;

    @Schema(description = "RoleAvatar.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/1.png")
    @NotEmpty(message = "RoleAvatar is required.")
    @URL(message = "RoleAvatar must be URL format.")
    private String avatar;

    @Schema(description = "Role category.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Create")
    @NotEmpty(message = "Role category cannot be empty.")
    private String category;

    @Schema(description = "Role sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Role sort is required.")
    private Integer sort;

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

    @Schema(description = "Public", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Public is required.")
    private Boolean publicStatus;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

}