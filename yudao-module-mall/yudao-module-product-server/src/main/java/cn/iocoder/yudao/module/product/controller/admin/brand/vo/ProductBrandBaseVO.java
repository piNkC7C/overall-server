package cn.iocoder.yudao.module.product.controller.admin.brand.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
* 商品品牌 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ProductBrandBaseVO {

    @Schema(description = "Brand name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Apple")
    @NotNull(message = "Brand name is required.")
    private String name;

    @Schema(description = "BrandImage.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "BrandImage is required.")
    private String picUrl;

    @Schema(description = "Brand sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Brand sort is required.")
    private Integer sort;

    @Schema(description = "BrandDescription.", example = "Description")
    private String description;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    private Integer status;

}
