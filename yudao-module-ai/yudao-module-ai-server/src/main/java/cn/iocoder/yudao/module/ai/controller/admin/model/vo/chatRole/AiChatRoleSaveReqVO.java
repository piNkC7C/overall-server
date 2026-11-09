package cn.iocoder.yudao.module.ai.controller.admin.model.vo.chatRole;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

import java.util.List;

@Schema(description = "管理后台 - AI 聊天角色新增/修改 Request VO")
@Data
public class AiChatRoleSaveReqVO {

    @Schema(description = "角色编号", example = "32746")
    private Long id;

    @Schema(description = "模型编号", example = "17640")
    private Long modelId;

    @Schema(description = "角色名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @NotEmpty(message = "Role name is required.")
    private String name;

    @Schema(description = "角色头像", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/1.png")
    @NotEmpty(message = "RoleAvatar is required.")
    @URL(message = "RoleAvatar must be URL format.")
    private String avatar;

    @Schema(description = "角色类别", requiredMode = Schema.RequiredMode.REQUIRED, example = "Create")
    @NotEmpty(message = "Role category cannot be empty.")
    private String category;

    @Schema(description = "角色排序", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Role sort is required.")
    private Integer sort;

    @Schema(description = "角色描述", requiredMode = Schema.RequiredMode.REQUIRED, example = "Looks good.")
    @NotEmpty(message = "RoleDescription is required.")
    private String description;

    @Schema(description = "角色设定", requiredMode = Schema.RequiredMode.REQUIRED, example = "From now on you are a programmer. You are an excellent engineer with strong logic and always solve problems efficiently.")
    @NotEmpty(message = "Role Prompt is required.")
    private String systemMessage;

    @Schema(description = "引用的知识库编号列表", example = "1,2,3")
    private List<Long> knowledgeIds;

    @Schema(description = "引用的工具编号列表", example = "1,2,3")
    private List<Long> toolIds;

    @Schema(description = "引用的 MCP Client 名字列表", example = "filesystem")
    private List<String> mcpClientNames;

    @Schema(description = "是否公开", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Public is required.")
    private Boolean publicStatus;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

}