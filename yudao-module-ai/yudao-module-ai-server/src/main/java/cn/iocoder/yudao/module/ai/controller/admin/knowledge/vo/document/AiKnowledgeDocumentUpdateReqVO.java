package cn.iocoder.yudao.module.ai.controller.admin.knowledge.vo.document;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - AI knowledge base documentupdate request.")
@Data
public class AiKnowledgeDocumentUpdateReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15583")
    @NotNull(message = "Code is required.")
    private Long id;

    @Schema(description = "Name.", example = "Java handbook")
    private String name;

    @Schema(description = "Max chunk tokens.", example = "1000")
    private Integer segmentMaxTokens;

}
