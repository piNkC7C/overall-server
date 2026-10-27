package cn.iocoder.yudao.module.pms.controller.admin.kb.content.vo.folder;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - PMS knowledge base folder create / edit request.")
@Data
public class PmsKnowledgeFolderSaveReqVO {

    @Schema(description = "Folder code.", example = "1024")
    private Long id;

    @Schema(description = "Knowledge base code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Knowledge base code is required.")
    private Long libraryId;

    @Schema(description = "Parent folder code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Parent folder code is required.")
    private Long parentId;

    @Schema(description = "Folder title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Productdocument.")
    @NotBlank(message = "Folder title is required.")
    @Size(max = 255, message = "Folder title cannot exceed 255 characters.")
    private String title;

}
