package cn.iocoder.yudao.module.ai.controller.admin.knowledge.vo.segment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Schema(description = "AI knowledge-base chunk search request VO.")
@Data
public class AiKnowledgeSegmentSearchReqVO {

    @Schema(description = "Knowledge base code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Knowledge base code is required.")
    private Long knowledgeId;

    @Schema(description = "Content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "How to use this product")
    @NotEmpty(message = "Content is required.")
    private String content;

    @Schema(description = "Max return count.", example = "5")
    private Integer topK;

    @Schema(description = "Similarity threshold.", example = "0.7")
    private Double similarityThreshold;

}
