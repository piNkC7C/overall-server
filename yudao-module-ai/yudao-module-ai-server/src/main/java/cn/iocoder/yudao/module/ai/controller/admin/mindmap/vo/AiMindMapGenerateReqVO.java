package cn.iocoder.yudao.module.ai.controller.admin.mindmap.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Schema(description = "AI mind map create request VO.")
@Data
public class AiMindMapGenerateReqVO {

    @Schema(description = "Mind-map prompt.", example = "Java learning path")
    @NotBlank(message = "Mind-map prompt cannot be empty.")
    private String prompt;

}