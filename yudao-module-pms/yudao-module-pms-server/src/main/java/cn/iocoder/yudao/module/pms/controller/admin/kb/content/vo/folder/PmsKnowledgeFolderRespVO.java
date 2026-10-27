package cn.iocoder.yudao.module.pms.controller.admin.kb.content.vo.folder;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - PMS knowledge base folder response.")
@Data
public class PmsKnowledgeFolderRespVO {

    @Schema(description = "Folder code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Knowledge base code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long libraryId;

    @Schema(description = "Collaboration permission code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long permissionId;

    @Schema(description = "Current user collaboration level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Integer currentUserLevel;

    @Schema(description = "Parent folder code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long parentId;

    @Schema(description = "Folder title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Productdocument.")
    private String title;

    @Schema(description = "Direct child folder count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Integer childFolderCount;

    @Schema(description = "Direct document count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "12")
    private Integer documentCount;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Current user is not already follow.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean favoriteStatus;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Update time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime updateTime;

}
