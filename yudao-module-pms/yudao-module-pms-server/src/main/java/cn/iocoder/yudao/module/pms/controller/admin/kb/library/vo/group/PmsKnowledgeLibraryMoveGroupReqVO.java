package cn.iocoder.yudao.module.pms.controller.admin.kb.library.vo.group;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - PMS knowledge base move group request.")
@Data
public class PmsKnowledgeLibraryMoveGroupReqVO {

    @Schema(description = "Knowledge base code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Knowledge base code is required.")
    private Long libraryId;

    @Schema(description = "Target group Code; empty means remove group.", example = "2048")
    private Long groupId;

}
