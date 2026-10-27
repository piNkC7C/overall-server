package cn.iocoder.yudao.module.pms.controller.admin.kb.content.vo.folder;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - PMS knowledge baseDirectorytree response.")
@Data
public class PmsKnowledgeTreeRespVO {

    @Schema(description = "Knowledge base code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long libraryId;

    @Schema(description = "Current user is not can edit.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean writeStatus;

    @Schema(description = "Whether the current user can manage the folder tree.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean manageStatus;

    @Schema(description = "Root folder list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<FolderNode> folders;

    @Schema(description = "Root document list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<DocumentNode> documents;

    @Schema(description = "Knowledge-base folder tree node response VO.")
    @Data
    public static class FolderNode {

        @Schema(description = "Folder code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long id;

        @Schema(description = "Collaboration permission code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long permissionId;

        @Schema(description = "Current user collaboration level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
        private Integer currentUserLevel;

        @Schema(description = "Parent folder code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long parentId;

        @Schema(description = "Folder title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Productdocument.")
        private String title;

        @Schema(description = "Child folder list.", requiredMode = Schema.RequiredMode.REQUIRED)
        private List<FolderNode> children;

        @Schema(description = "Folder document list.", requiredMode = Schema.RequiredMode.REQUIRED)
        private List<DocumentNode> documents;
    }

    @Schema(description = "Knowledge-base document tree node response VO.")
    @Data
    public static class DocumentNode {

        @Schema(description = "Document code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long id;

        @Schema(description = "Collaboration permission code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long permissionId;

        @Schema(description = "Current user collaboration level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
        private Integer currentUserLevel;

        @Schema(description = "Parent document code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long parentId;

        @Schema(description = "Document title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ProductNotes.")
        private String title;

        @Schema(description = "Document type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
        private Integer type;

        @Schema(description = "File type.", example = "pdf")
        private String fileType;

        @Schema(description = "Child document list.", requiredMode = Schema.RequiredMode.REQUIRED)
        private List<DocumentNode> children;
    }

}
