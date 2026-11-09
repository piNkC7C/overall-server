package cn.iocoder.yudao.module.ai.controller.admin.mindmap.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Schema(description = "管理后台 - AI 思维导图生成 Request VO")
@Data
public class AiMindMapGenerateReqVO {

    @Schema(description = "思维导图内容提示", example = "Java learning path")
    @NotBlank(message = "Mind-map prompt cannot be empty.")
    private String prompt;

}