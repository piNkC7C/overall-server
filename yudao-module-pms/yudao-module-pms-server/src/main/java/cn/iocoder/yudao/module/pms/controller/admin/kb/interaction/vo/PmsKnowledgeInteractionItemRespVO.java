package cn.iocoder.yudao.module.pms.controller.admin.kb.interaction.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Knowledge interaction target response VO.")
@Data
public class PmsKnowledgeInteractionItemRespVO {

    @Schema(description = "Record code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Object type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Integer type;

    @Schema(description = "Object code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long entityId;

    @Schema(description = "Knowledge base code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long libraryId;

    @Schema(description = "Knowledge base name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Product knowledge base.")
    private String libraryName;

    @Schema(description = "Object name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ProductNotes.")
    private String name;

    @Schema(description = "Knowledge base bio.")
    private String description;

    @Schema(description = "Folder code.", example = "1024")
    private Long folderId;

    @Schema(description = "Document code.", example = "1024")
    private Long documentId;

    @Schema(description = "File type.", example = "pdf")
    private String fileType;

    @Schema(description = "File Size, in bytes.")
    private Long fileSize;

    @Schema(description = "Object update time.")
    private LocalDateTime targetUpdateTime;

    @Schema(description = "Record time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
