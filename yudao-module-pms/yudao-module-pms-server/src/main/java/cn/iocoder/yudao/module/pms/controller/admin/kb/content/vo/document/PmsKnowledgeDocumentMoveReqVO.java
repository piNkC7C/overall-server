package cn.iocoder.yudao.module.pms.controller.admin.kb.content.vo.document;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - PMS knowledge base document move request.")
@Data
public class PmsKnowledgeDocumentMoveReqVO {

    @Schema(description = "Document code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Document code is required.")
    private Long id;

    @Schema(description = "Target knowledge base code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Target knowledge base code is required.")
    private Long targetLibraryId;

    @Schema(description = "Target folder code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Target folder code is required.")
    private Long targetFolderId;

    @Schema(description = "Target parent document code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Target parent document code is required.")
    private Long targetParentId;

}
