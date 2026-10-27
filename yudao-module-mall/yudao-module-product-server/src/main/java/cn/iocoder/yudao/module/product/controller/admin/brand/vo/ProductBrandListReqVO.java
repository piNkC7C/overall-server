package cn.iocoder.yudao.module.product.controller.admin.brand.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - product brand page request.")
@Data
public class ProductBrandListReqVO {

    @Schema(description = "Brand name.", example = "Apple")
    private String name;

}
