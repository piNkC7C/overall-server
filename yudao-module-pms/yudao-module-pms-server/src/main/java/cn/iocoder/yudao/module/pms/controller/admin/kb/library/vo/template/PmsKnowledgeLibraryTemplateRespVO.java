package cn.iocoder.yudao.module.pms.controller.admin.kb.library.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - PMS knowledge base template response.")
@Data
public class PmsKnowledgeLibraryTemplateRespVO {

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Product R&D")
    private String name;

    @Schema(description = "Template bio.", example = "Provide complete product-process docs")
    private String description;

    @Schema(description = "Template cover Address.", example = "/static/pms/kb/template/product.png")
    private String coverUrl;

    @Schema(description = "Template status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer sort;

    @Schema(description = "Templatedocument list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<PmsKnowledgeLibraryTemplateSaveReqVO.Document> documents;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
