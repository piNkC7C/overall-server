package cn.iocoder.yudao.module.pms.controller.admin.kb.interaction.vo.comment;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - PMS knowledge base document comment save request.")
@Data
public class PmsKnowledgeDocumentCommentSaveReqVO {

    @Schema(description = "Document code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Document code is required.")
    private Long documentId;

    @Schema(description = "Root comment ID.", example = "0")
    private Long mainId;

    @Schema(description = "Reply object user ID.", example = "1")
    private Long replyUserId;

    @Schema(description = "Comment content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "The document is clear")
    @NotBlank(message = "Comment content is required.")
    @Size(max = 2000, message = "Comment content cannot exceed 2000 characters.")
    private String content;

}
