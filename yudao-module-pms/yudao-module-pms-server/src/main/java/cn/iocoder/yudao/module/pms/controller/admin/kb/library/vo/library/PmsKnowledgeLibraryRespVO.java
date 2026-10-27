package cn.iocoder.yudao.module.pms.controller.admin.kb.library.vo.library;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - PMS knowledge base response.")
@Data
public class PmsKnowledgeLibraryRespVO {

    @Schema(description = "Knowledge base code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Knowledge base name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Product knowledge base.")
    private String name;

    @Schema(description = "Knowledge base bio.")
    private String description;

    @Schema(description = "Public", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean openStatus;

    @Schema(description = "Knowledge base cover.")
    private String coverUrl;

    @Schema(description = "Creator user ID.", example = "1")
    private Long creatorUserId;

    @Schema(description = "Creator Name.", example = "Overall.")
    private String creatorUserName;

    @Schema(description = "Member quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    private Integer memberCount;

    @Schema(description = "Document quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "12")
    private Long documentCount;

    @Schema(description = "File quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4")
    private Long fileCount;

    @Schema(description = "Current user is not can edit content.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean writeStatus;

    @Schema(description = "Current user is not is knowledge base admin.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean adminStatus;

    @Schema(description = "Whether the current user can leave the knowledge base.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean exitStatus;

    @Schema(description = "Current user is not already follow.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean favoriteStatus;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
