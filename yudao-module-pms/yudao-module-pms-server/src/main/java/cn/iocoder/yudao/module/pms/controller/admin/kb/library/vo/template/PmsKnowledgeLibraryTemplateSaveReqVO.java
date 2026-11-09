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

@Schema(description = "管理后台 - PMS 知识库模板新增/修改 Request VO")
@Data
public class PmsKnowledgeLibraryTemplateSaveReqVO {

    @Schema(description = "模板编号", example = "1024")
    private Long id;

    @Schema(description = "模板名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Product R&D")
    @NotBlank(message = "Template name is required.")
    @Size(max = 100, message = "Template name cannot exceed 100 characters.")
    private String name;

    @Schema(description = "模板简介", example = "Provide complete product-process docs")
    @Size(max = 500, message = "Template bio cannot exceed 500 characters.")
    private String description;

    @Schema(description = "模板封面地址", example = "/static/pms/kb/template/product.png")
    @Size(max = 255, message = "Template cover Address cannot exceed 255 characters.")
    private String coverUrl;

    @Schema(description = "模板状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Template status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "显示顺序", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Sort is required.")
    @PositiveOrZero(message = "Sort order cannot be less than 0.")
    private Integer sort;

    @Schema(description = "模板文档列表", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Templatedocument is required.")
    @Valid
    private List<Document> documents;

    @Schema(description = "模板文档")
    @Data
    public static class Document {

        @Schema(description = "文档标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "Product requirement document.")
        @NotBlank(message = "Document title is required.")
        @Size(max = 255, message = "Document title cannot exceed 255 characters.")
        private String title;

        @Schema(description = "文档内容", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "Document content is required.")
        private String content;

    }

}
