package cn.iocoder.yudao.module.pms.controller.admin.kb.recycle.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - PMS knowledge base recycle bin record response.")
@Data
public class PmsKnowledgeRecycleRespVO {

    @Schema(description = "Recycle bin record code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Knowledge base code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long libraryId;

    @Schema(description = "Object type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Integer type;

    @Schema(description = "Object code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long entityId;

    @Schema(description = "Object name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ProductNotes.")
    private String name;

    @Schema(description = "File Size, in bytes.")
    private Long fileSize;

    @Schema(description = "Delete person user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long deleteUserId;

    @Schema(description = "Delete person Name.", example = "Overall.")
    private String deleteUserName;

    @Schema(description = "Delete time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime deleteTime;

    @Schema(description = "Parent object ID. Used to build hierarchy in trash detail.", example = "2048")
    private Long parentId;

    @Schema(description = "Folder Code, used to build hierarchy in trash detail.", example = "2048")
    private Long folderId;

}
