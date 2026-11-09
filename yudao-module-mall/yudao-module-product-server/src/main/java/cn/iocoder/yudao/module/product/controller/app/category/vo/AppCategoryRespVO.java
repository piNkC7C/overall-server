package cn.iocoder.yudao.module.product.controller.app.category.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "用户 APP - 商品分类 Response VO")
public class AppCategoryRespVO {

    @Schema(description = "分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Long id;

    @Schema(description = "父分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Parent category code is required.")
    private Long parentId;

    @Schema(description = "分类名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Office stationery")
    @NotBlank(message = "Category name is required.")
    private String name;

    @Schema(description = "分类图片", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "CategoryImage is required.")
    private String picUrl;

}
