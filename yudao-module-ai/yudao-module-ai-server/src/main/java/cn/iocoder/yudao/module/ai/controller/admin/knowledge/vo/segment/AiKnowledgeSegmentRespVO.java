package cn.iocoder.yudao.module.ai.controller.admin.knowledge.vo.segment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "AI knowledge base document chunk response VO.")
@Data
public class AiKnowledgeSegmentRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "24790")
    private Long id;

    @Schema(description = "Document code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "24790")
    private Long documentId;

    @Schema(description = "Knowledge base code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "24790")
    private Long knowledgeId;

    @Schema(description = "Vector store ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1858496a-1dde-4edf-a43e-0aed08f37f8c")
    private String vectorId;

    @Schema(description = "Chunk content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Java handbook")
    private String content;

    @Schema(description = "Chunk content length.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer contentLength;

    @Schema(description = "Token quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer tokens;

    @Schema(description = "Recall count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer retrievalCount;

    @Schema(description = "Document status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long createTime;

}
