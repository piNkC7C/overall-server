package cn.iocoder.yudao.module.product.controller.admin.category.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Collection;

@Schema(description = "Admin - product category list search request.")
@Data
public class ProductCategoryListReqVO {

    @Schema(description = "Category name.", example = "Office stationery")
    private String name;

    @Schema(description = "Enable status.", example = "0")
    private Integer status;

    @Schema(description = "Parent category code.", example = "1")
    private Long parentId;

    @Schema(description = "Parent category ID list.", example = "1,2,3")
    private Collection<Long> parentIds;

}
