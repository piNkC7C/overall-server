package cn.iocoder.yudao.module.ai.controller.admin.model.vo.chatRole;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "AI chat persona page request VO.")
@Data
public class AiChatRolePageReqVO extends PageParam {

    @Schema(description = "Role name.", example = "Jane.")
    private String name;

    @Schema(description = "Role category.", example = "Create")
    private String category;

    @Schema(description = "Public", example = "1")
    private Boolean publicStatus;

}