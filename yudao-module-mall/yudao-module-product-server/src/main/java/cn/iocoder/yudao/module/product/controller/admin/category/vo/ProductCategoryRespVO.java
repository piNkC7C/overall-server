package cn.iocoder.yudao.module.product.controller.admin.category.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - product category response.")
@Data
public class ProductCategoryRespVO {

    @Schema(description = "Category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Long id;

    @Schema(description = "Parent category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long parentId;

    @Schema(description = "Category name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Office stationery")
    private String name;

    @Schema(description = "Mobile category image.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String picUrl;

    @Schema(description = "Category sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer sort;

    @Schema(description = "Enable status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status;

    @Schema(description = "CategoryDescription.", example = "Description")
    private String description;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
