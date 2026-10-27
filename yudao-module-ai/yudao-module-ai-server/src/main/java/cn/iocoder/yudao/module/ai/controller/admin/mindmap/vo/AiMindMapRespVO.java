package cn.iocoder.yudao.module.ai.controller.admin.mindmap.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "AI mind map response VO.")
@Data
public class AiMindMapRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3373")
    private Long id;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4325")
    private Long userId;

    @Schema(description = "Create contentTip.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Java learning path")
    private String prompt;

    @Schema(description = "Generated mind-map content.")
    private String generatedContent;

    @Schema(description = "Platform", requiredMode = Schema.RequiredMode.REQUIRED, example = "OpenAI")
    private String platform;

    @Schema(description = "Model.", requiredMode = Schema.RequiredMode.REQUIRED, example = "gpt-3.5-turbo-0125")
    private String model;

    @Schema(description = "Error info.")
    private String errorMessage;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}