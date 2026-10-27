package cn.iocoder.yudao.module.product.controller.admin.brand.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Admin - brand simple info response.")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductBrandSimpleRespVO {

    @Schema(description = "Brand code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Brand name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Apple")
    private String name;

}
