package cn.iocoder.yudao.module.product.controller.app.category.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "User APP - product category response.")
public class AppCategoryRespVO {

    @Schema(description = "Category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Long id;

    @Schema(description = "Parent category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Parent category code is required.")
    private Long parentId;

    @Schema(description = "Category name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Office stationery")
    @NotBlank(message = "Category name is required.")
    private String name;

    @Schema(description = "CategoryImage.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "CategoryImage is required.")
    private String picUrl;

}
