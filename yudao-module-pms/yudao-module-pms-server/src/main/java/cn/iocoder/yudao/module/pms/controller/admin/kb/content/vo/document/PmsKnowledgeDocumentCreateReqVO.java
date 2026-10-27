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

@Schema(description = "Admin - PMS knowledge base document create request.")
@Data
public class PmsKnowledgeDocumentCreateReqVO {

    @Schema(description = "Knowledge base code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Knowledge base code is required.")
    private Long libraryId;

    @Schema(description = "Folder code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Folder code is required.")
    private Long folderId;

    @Schema(description = "Parent document code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Parent document code is required.")
    private Long parentId;

    @Schema(description = "Document title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ProductNotes.")
    @NotBlank(message = "Document title is required.")
    @Size(max = 255, message = "Document title cannot exceed 255 characters.")
    private String title;

    @Schema(description = "Document type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    @NotNull(message = "Document type is required.")
    @InEnum(PmsKnowledgeDocumentTypeEnum.class)
    private Integer type;

    @Schema(description = "Document content or fileAddress.")
    private String content;

    @Schema(description = "File type.", example = "pdf")
    @Size(max = 50, message = "File type cannot exceed 50 characters.")
    private String fileType;

    @Schema(description = "File Size, in bytes.", example = "102400")
    @Min(value = 0, message = "File size cannot be less than 0.")
    @Max(value = 104857600, message = "File size cannot exceed 100 MB.")
    private Long fileSize;

}
