package cn.iocoder.yudao.module.pms.controller.admin.kb.content.vo.label;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - PMS knowledge base documenttag create / edit request.")
@Data
public class PmsKnowledgeDocumentLabelSaveReqVO {

    @Schema(description = "Documenttag code.", example = "1024")
    private Long id;

    @Schema(description = "Tag name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Product.")
    @NotBlank(message = "Tag name is required.")
    @Size(max = 255, message = "Tag name cannot exceed 255 characters.")
    private String name;

    @Schema(description = "Tag color.", requiredMode = Schema.RequiredMode.REQUIRED, example = "#409EFF")
    @NotBlank(message = "Tag color is required.")
    @Size(max = 20, message = "Tag color cannot exceed 20 characters.")
    private String color;

}
