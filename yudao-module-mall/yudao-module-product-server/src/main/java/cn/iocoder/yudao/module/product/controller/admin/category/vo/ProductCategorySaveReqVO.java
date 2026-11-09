package cn.iocoder.yudao.module.product.controller.admin.category.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - 商品分类新增/更新 Request VO")
@Data
public class ProductCategorySaveReqVO {

    @Schema(description = "分类编号", example = "2")
    private Long id;

    @Schema(description = "父分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Parent category code is required.")
    private Long parentId;

    @Schema(description = "分类名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Office stationery")
    @NotBlank(message = "Category name is required.")
    private String name;

    @Schema(description = "移动端分类图", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Mobile category image cannot be empty.")
    private String picUrl;

    @Schema(description = "分类排序", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer sort;

    @Schema(description = "开启状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Enable status is required.")
    private Integer status;

    @Schema(description = "分类描述", example = "Description")
    private String description;

}
