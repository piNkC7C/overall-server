package cn.iocoder.yudao.module.ai.controller.admin.knowledge.vo.knowledge;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - AI knowledge base response.")
@Data
public class AiKnowledgeRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "24790")
    private Long id;

    @Schema(description = "Knowledge base name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Platform user guide")
    private String name;

    @Schema(description = "Knowledge base Description.", example = "Helps you build a system quickly")
    private String description;

    @Schema(description = "Embedding modelID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "14")
    private Long embeddingModelId;

    @Schema(description = "Embedding model key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "qwen-72b-chat")
    private String embeddingModel;

    @Schema(description = "topK", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Integer topK;

    @Schema(description = "Similarity threshold.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0.7")
    private Double similarityThreshold;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
