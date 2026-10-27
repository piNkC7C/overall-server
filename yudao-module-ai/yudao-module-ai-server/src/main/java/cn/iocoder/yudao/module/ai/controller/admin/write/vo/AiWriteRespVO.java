package cn.iocoder.yudao.module.ai.controller.admin.write.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "AI writing response VO.")
@Data
public class AiWriteRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5311")
    private Long id;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "28404")
    private Long userId;

    @Schema(description = "Writing type.", example = "1")
    private Integer type;

    @Schema(description = "Platform", requiredMode = Schema.RequiredMode.REQUIRED, example = "TongYi")
    private String platform;

    @Schema(description = "Model.", requiredMode = Schema.RequiredMode.REQUIRED, example = "qwen")
    private String model;

    @Schema(description = "Create contentTip.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Write: Tian Ji's horse race")
    private String prompt;

    @Schema(description = "Created by content.", example = "You are doing great")
    private String generatedContent;

    @Schema(description = "Original text.", example = "Really?")
    private String originalContent;

    @Schema(description = "Length Prompt.", example = "1")
    private Integer length;

    @Schema(description = "Format Prompt.", example = "2")
    private Integer format;

    @Schema(description = "TonePrompt.", example = "3")
    private Integer tone;

    @Schema(description = "LanguagePrompt.", example = "4")
    private Integer language;

    @Schema(description = "Error info.")
    private String errorMessage;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}