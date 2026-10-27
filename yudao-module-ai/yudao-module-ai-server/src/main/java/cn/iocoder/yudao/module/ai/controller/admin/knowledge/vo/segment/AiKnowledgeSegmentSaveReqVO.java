package cn.iocoder.yudao.module.ai.controller.admin.knowledge.vo.segment;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(description = "Admin - AI create/updateknowledge basesegment request VO.")
@Data
public class AiKnowledgeSegmentSaveReqVO {

    @Schema(description = "Code.", example = "24790")
    private Long id;

    @Schema(description = "Knowledge base document code.", example = "1024")
    private Long documentId;

    @Schema(description = "Chunk content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Java handbook")
    @NotEmpty(message = "Chunk content cannot be empty.")
    private String content;

}
