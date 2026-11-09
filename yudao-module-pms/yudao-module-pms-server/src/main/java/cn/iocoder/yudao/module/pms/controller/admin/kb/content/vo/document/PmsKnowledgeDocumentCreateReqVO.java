package cn.iocoder.yudao.module.pms.controller.admin.kb.content.vo.document;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.pms.enums.kb.content.PmsKnowledgeDocumentTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - PMS 知识库文档新增 Request VO")
@Data
public class PmsKnowledgeDocumentCreateReqVO {

    @Schema(description = "知识库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Knowledge base code is required.")
    private Long libraryId;

    @Schema(description = "文件夹编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Folder code is required.")
    private Long folderId;

    @Schema(description = "父文档编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Parent document code is required.")
    private Long parentId;

    @Schema(description = "文档标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "ProductNotes.")
    @NotBlank(message = "Document title is required.")
    @Size(max = 255, message = "Document title cannot exceed 255 characters.")
    private String title;

    @Schema(description = "文档类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    @NotNull(message = "Document type is required.")
    @InEnum(PmsKnowledgeDocumentTypeEnum.class)
    private Integer type;

    @Schema(description = "文档内容或文件地址")
    private String content;

    @Schema(description = "文件类型", example = "pdf")
    @Size(max = 50, message = "File type cannot exceed 50 characters.")
    private String fileType;

    @Schema(description = "文件大小，单位：字节", example = "102400")
    @Min(value = 0, message = "File size cannot be less than 0.")
    @Max(value = 104857600, message = "File size cannot exceed 100 MB.")
    private Long fileSize;

}
