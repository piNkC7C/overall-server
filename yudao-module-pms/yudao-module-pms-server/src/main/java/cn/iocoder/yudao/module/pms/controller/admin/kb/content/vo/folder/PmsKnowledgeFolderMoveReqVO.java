package cn.iocoder.yudao.module.pms.controller.admin.kb.content.vo.folder;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - PMS knowledge base folder move request.")
@Data
public class PmsKnowledgeFolderMoveReqVO {

    @Schema(description = "Folder code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Folder code is required.")
    private Long id;

    @Schema(description = "Target knowledge base code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Target knowledge base code is required.")
    private Long targetLibraryId;

    @Schema(description = "Target parent folder code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Target parent folder code is required.")
    private Long targetParentId;

}
