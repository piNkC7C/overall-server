package cn.iocoder.yudao.module.ai.controller.admin.model.vo.tool;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(description = "Admin - AI tool create / edit request.")
@Data
public class AiToolSaveReqVO {

    @Schema(description = "Tool code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "19661")
    private Long id;

    @Schema(description = "Tool name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alex.")
    @NotEmpty(message = "Tool name is required.")
    private String name;

    @Schema(description = "ToolDescription.", example = "Example.")
    private String description;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

}