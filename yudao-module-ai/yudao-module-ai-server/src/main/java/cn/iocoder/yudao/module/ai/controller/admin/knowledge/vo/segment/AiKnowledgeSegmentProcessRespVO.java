package cn.iocoder.yudao.module.ai.controller.admin.knowledge.vo.segment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "AI knowledge-base chunk vector progress response VO.")
@Data
public class AiKnowledgeSegmentProcessRespVO {

    @Schema(description = "Document code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long documentId;

    @Schema(description = "Total segment count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Long count;

    @Schema(description = "Vectorized segment count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    private Long embeddingCount;

}