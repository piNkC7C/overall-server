package cn.iocoder.yudao.module.ai.controller.admin.knowledge.vo.document;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - AI knowledge base document response.")
@Data
public class AiKnowledgeDocumentRespVO {

    @Schema(description = "Document code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "24790")
    private Long id;

    @Schema(description = "Knowledge base code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "24790")
    private Long knowledgeId;

    @Schema(description = "Document name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Java handbook")
    private String name;

    @Schema(description = "Document URL.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://doc.iocoder.cn")
    private String url;

    @Schema(description = "Document content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Java is an object-oriented language.....")
    private String content;

    @Schema(description = "Document content length.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Integer contentLength;

    @Schema(description = "Document Token quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer tokens;

    @Schema(description = "Max chunk tokens.", requiredMode = Schema.RequiredMode.REQUIRED, example = "512")
    private Integer segmentMaxTokens;

    @Schema(description = "Recall count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer retrievalCount;

    @Schema(description = "Document status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
