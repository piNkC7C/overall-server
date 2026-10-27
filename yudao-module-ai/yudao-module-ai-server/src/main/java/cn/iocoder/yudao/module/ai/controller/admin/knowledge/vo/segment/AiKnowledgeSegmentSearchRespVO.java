package cn.iocoder.yudao.module.ai.controller.admin.knowledge.vo.segment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "AI knowledge-base chunk search response VO.")
@Data
public class AiKnowledgeSegmentSearchRespVO extends AiKnowledgeSegmentRespVO {

    @Schema(description = "Document name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Product user guide")
    private String documentName;

    @Schema(description = "Similarity score.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0.95")
    private Double score;

}