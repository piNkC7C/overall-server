package cn.iocoder.yudao.module.product.controller.admin.category.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - product category create /update request.")
@Data
public class ProductCategorySaveReqVO {

    @Schema(description = "Category code.", example = "2")
    private Long id;

    @Schema(description = "Parent category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Parent category code is required.")
    private Long parentId;

    @Schema(description = "Category name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Office stationery")
    @NotBlank(message = "Category name is required.")
    private String name;

    @Schema(description = "Mobile category image.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Mobile category image cannot be empty.")
    private String picUrl;

    @Schema(description = "Category sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer sort;

    @Schema(description = "Enable status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Enable status is required.")
    private Integer status;

    @Schema(description = "CategoryDescription.", example = "Description")
    private String description;

}
