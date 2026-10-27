package cn.iocoder.yudao.module.pms.controller.admin.kb.library.vo.template;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - PMS knowledge base template create / edit request.")
@Data
public class PmsKnowledgeLibraryTemplateSaveReqVO {

    @Schema(description = "Template code.", example = "1024")
    private Long id;

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Product R&D")
    @NotBlank(message = "Template name is required.")
    @Size(max = 100, message = "Template name cannot exceed 100 characters.")
    private String name;

    @Schema(description = "Template bio.", example = "Provide complete product-process docs")
    @Size(max = 500, message = "Template bio cannot exceed 500 characters.")
    private String description;

    @Schema(description = "Template cover Address.", example = "/static/pms/kb/template/product.png")
    @Size(max = 255, message = "Template cover Address cannot exceed 255 characters.")
    private String coverUrl;

    @Schema(description = "Template status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Template status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Sort is required.")
    @PositiveOrZero(message = "Sort order cannot be less than 0.")
    private Integer sort;

    @Schema(description = "Templatedocument list.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Templatedocument is required.")
    @Valid
    private List<Document> documents;

    @Schema(description = "Templatedocument.")
    @Data
    public static class Document {

        @Schema(description = "Document title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Product requirement document.")
        @NotBlank(message = "Document title is required.")
        @Size(max = 255, message = "Document title cannot exceed 255 characters.")
        private String title;

        @Schema(description = "Document content.", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "Document content is required.")
        private String content;

    }

}
