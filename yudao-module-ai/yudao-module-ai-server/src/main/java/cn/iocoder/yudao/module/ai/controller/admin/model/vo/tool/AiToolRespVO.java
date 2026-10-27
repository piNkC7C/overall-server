package cn.iocoder.yudao.module.ai.controller.admin.model.vo.tool;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Schema(description = "Admin - AI tool response.")
@Data
public class AiToolRespVO {

    @Schema(description = "Tool code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "19661")
    private Long id;

    @Schema(description = "Tool name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alex.")
    private String name;

    @Schema(description = "ToolDescription.", example = "Example.")
    private String description;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}