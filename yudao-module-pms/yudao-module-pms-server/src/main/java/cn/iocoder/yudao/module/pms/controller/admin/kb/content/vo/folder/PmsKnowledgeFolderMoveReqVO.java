package cn.iocoder.yudao.module.pms.controller.admin.kb.content.vo.folder;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - PMS 知识库文件夹移动 Request VO")
@Data
public class PmsKnowledgeFolderMoveReqVO {

    @Schema(description = "文件夹编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Folder code is required.")
    private Long id;

    @Schema(description = "目标知识库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Target knowledge base code is required.")
    private Long targetLibraryId;

    @Schema(description = "目标父文件夹编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Target parent folder code is required.")
    private Long targetParentId;

}
