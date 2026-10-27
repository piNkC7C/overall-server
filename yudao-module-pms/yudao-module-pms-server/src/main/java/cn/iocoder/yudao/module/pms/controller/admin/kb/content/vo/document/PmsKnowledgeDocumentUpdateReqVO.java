package cn.iocoder.yudao.module.pms.controller.admin.kb.content.vo.document;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - PMS knowledge base document edit request.")
@Data
public class PmsKnowledgeDocumentUpdateReqVO {

    @Schema(description = "Document code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Document code is required.")
    private Long id;

    @Schema(description = "Document title.", example = "ProductNotes.")
    @Size(max = 255, message = "Document title cannot exceed 255 characters.")
    private String title;

    @Schema(description = "Document content or fileAddress.")
    private String content;

    @Schema(description = "Tag IDs. An empty collection clears tags.")
    private List<Long> labelIds;

    @Schema(description = "File type.", example = "pdf")
    @Size(max = 50, message = "File type cannot exceed 50 characters.")
    private String fileType;

    @Schema(description = "File Size, in bytes.", example = "102400")
    @Min(value = 0, message = "File size cannot be less than 0.")
    @Max(value = 104857600, message = "File size cannot exceed 100 MB.")
    private Long fileSize;

}
