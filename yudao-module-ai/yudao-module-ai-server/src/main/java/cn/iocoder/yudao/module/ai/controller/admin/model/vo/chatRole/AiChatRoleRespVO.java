package cn.iocoder.yudao.module.ai.controller.admin.model.vo.chatRole;

import cn.iocoder.yudao.module.ai.dal.dataobject.model.AiModelDO;
import org.dromara.core.trans.anno.Trans;
import org.dromara.core.trans.constant.TransType;
import org.dromara.core.trans.vo.VO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "AI chat persona response VO.")
@Data
public class AiChatRoleRespVO implements VO {

    @Schema(description = "Role code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "32746")
    private Long id;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "9442")
    private Long userId;

    @Schema(description = "Model code.", example = "17640")
    @Trans(type = TransType.SIMPLE, target = AiModelDO.class, fields = { "name", "model" }, refs = { "modelName", "model" })
    private Long modelId;
    @Schema(description = "Model name.", example = "John.")
    private String modelName;
    @Schema(description = "Model key.", example = "gpt-3.5-turbo-0125")
    private String model;

    @Schema(description = "Role name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    private String name;

    @Schema(description = "RoleAvatar.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/1.png")
    private String avatar;

    @Schema(description = "Role category.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Create")
    private String category;

    @Schema(description = "Role sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer sort;

    @Schema(description = "RoleDescription.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Looks good.")
    private String description;

    @Schema(description = "Role Prompt", requiredMode = Schema.RequiredMode.REQUIRED)
    private String systemMessage;

    @Schema(description = "Referenced knowledge base code list.", example = "1,2,3")
    private List<Long> knowledgeIds;

    @Schema(description = "Referenced tool code list.", example = "1,2,3")
    private List<Long> toolIds;

    @Schema(description = "Referenced MCP Client name list.", example = "filesystem")
    private List<String> mcpClientNames;

    @Schema(description = "Public", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Boolean publicStatus;

    @Schema(description = "Status.", example = "1")
    private Integer status;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}