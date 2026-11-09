package cn.iocoder.yudao.module.pms.controller.admin.kb.content.vo.folder;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - PMS 知识库文件夹新增/修改 Request VO")
@Data
public class PmsKnowledgeFolderSaveReqVO {

    @Schema(description = "文件夹编号", example = "1024")
    private Long id;

    @Schema(description = "知识库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Knowledge base code is required.")
    private Long libraryId;

    @Schema(description = "父文件夹编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Parent folder code is required.")
    private Long parentId;

    @Schema(description = "文件夹标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "Productdocument.")
    @NotBlank(message = "Folder title is required.")
    @Size(max = 255, message = "Folder title cannot exceed 255 characters.")
    private String title;

}
