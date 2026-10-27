package cn.iocoder.yudao.module.pms.controller.admin.kb.interaction.vo.share;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "PMS knowledge base documentPublic share response.")
@Data
public class PmsKnowledgeDocumentSharePublicRespVO {

    @Schema(description = "Document code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Document title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ProductNotes.")
    private String title;

    @Schema(description = "Document content or fileAddress.")
    private String content;

    @Schema(description = "Temporary file preview URL.")
    private String previewUrl;

    @Schema(description = "Document type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Integer type;

    @Schema(description = "File type.", example = "pdf")
    private String fileType;

    @Schema(description = "Update time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime updateTime;

}
