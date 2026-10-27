package cn.iocoder.yudao.module.pms.controller.admin.kb.recycle.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - PMS knowledge base recycle bin contentPreview response.")
@Data
public class PmsKnowledgeRecyclePreviewRespVO {

    @Schema(description = "Content code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Content type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Integer type;

    @Schema(description = "Content name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ProductNotes.")
    private String name;

    @Schema(description = "DocumentBody or fileAddress.")
    private String content;

    @Schema(description = "File type.", example = "pdf")
    private String fileType;

    @Schema(description = "File Size, in bytes.", example = "102400")
    private Long fileSize;

}
