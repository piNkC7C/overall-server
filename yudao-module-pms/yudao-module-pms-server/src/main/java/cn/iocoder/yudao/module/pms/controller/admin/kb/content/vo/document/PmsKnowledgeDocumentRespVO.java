package cn.iocoder.yudao.module.pms.controller.admin.kb.content.vo.document;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - PMS knowledge base document response.")
@Data
public class PmsKnowledgeDocumentRespVO {

    @Schema(description = "Document code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Knowledge base code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long libraryId;

    @Schema(description = "Collaboration permission code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long permissionId;

    @Schema(description = "Current user collaboration level.", example = "3")
    private Integer currentUserLevel;

    @Schema(description = "Whether the current user can download.", example = "true")
    private Boolean downloadStatus;

    @Schema(description = "Knowledge base name.", example = "Product knowledge base.")
    private String libraryName;

    @Schema(description = "Folder code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long folderId;

    @Schema(description = "Parent document code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long parentId;

    @Schema(description = "Document title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ProductNotes.")
    private String title;

    @Schema(description = "BodySummary.")
    private String contentSummary;

    @Schema(description = "Document content or fileAddress.")
    private String content;

    @Schema(description = "File preview URL. Still usable for online preview when download is not allowed.")
    private String previewUrl;

    @Schema(description = "Document type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Integer type;

    @Schema(description = "File type.", example = "pdf")
    private String fileType;

    @Schema(description = "File Size, in bytes.", example = "102400")
    private Long fileSize;

    @Schema(description = "Document status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Tag code list.", example = "[1024, 2048]")
    private List<Long> labelIds;

    @Schema(description = "Creator user ID.", example = "1")
    private Long creatorUserId;

    @Schema(description = "Creator Name.", example = "Overall.")
    private String creatorUserName;

    @Schema(description = "Current user is not already follow.")
    private Boolean favoriteStatus;

    @Schema(description = "Current user is not already Like.")
    private Boolean likeStatus;

    @Schema(description = "Likeuser list.")
    private List<LikeUser> likeUsers;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Update time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime updateTime;

    @Schema(description = "Admin - PMS knowledge documentLikeuser response.")
    @Data
    public static class LikeUser {

        @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Long id;

        @Schema(description = "Nickname", example = "Overall.")
        private String nickname;

        @Schema(description = "UserAvatar.")
        private String avatar;

    }

}
