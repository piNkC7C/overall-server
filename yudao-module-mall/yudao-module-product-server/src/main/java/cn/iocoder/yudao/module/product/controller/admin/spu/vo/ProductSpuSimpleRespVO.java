package cn.iocoder.yudao.module.product.controller.admin.spu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@Schema(description = "Admin - product SPU simple response.")
@Data
@ToString(callSuper = true)
public class ProductSpuSimpleRespVO {

    @Schema(description = "Primary key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "213")
    private Long id;

    @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cool T-shirt")
    private String name;

    @Schema(description = "ProductPrice, order characters used：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1999")
    private Integer price;

    @Schema(description = "ProductMarket Price, order characters used：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "199")
    private Integer marketPrice;

    @Schema(description = "Product Cost, in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "19")
    private Integer costPrice;

    @Schema(description = "Productinventory.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2000")
    private Integer stock;

    // ========== 统计相关字段 =========

    @Schema(description = "Product sales", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    private Integer salesCount;

    @Schema(description = "Virtual product sales.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20000")
    private Integer virtualSalesCount;

    @Schema(description = "Productviews.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2000")
    private Integer browseCount;

}
