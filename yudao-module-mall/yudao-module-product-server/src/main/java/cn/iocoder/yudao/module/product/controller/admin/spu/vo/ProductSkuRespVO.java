package cn.iocoder.yudao.module.product.controller.admin.spu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - product SKU response.")
@Data
public class ProductSkuRespVO {

    @Schema(description = "Primary key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Product SKU name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cool T-shirt")
    private String name;

    @Schema(description = "Sales Price, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1999")
    private Integer price;

    @Schema(description = "Market Price", example = "2999")
    private Integer marketPrice;

    @Schema(description = "Cost price.", example = "19")
    private Integer costPrice;

    @Schema(description = "Barcode.", example = "15156165456")
    private String barCode;

    @Schema(description = "ImageAddress.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xx.png")
    private String picUrl;

    @Schema(description = "Inventory.", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    private Integer stock;

    @Schema(description = "Product weight, in kg.", example = "1.2")
    private Double weight;

    @Schema(description = "Product volume, in m³.", example = "2.5")
    private Double volume;

    @Schema(description = "Level-1 commission, in cents.", example = "199")
    private Integer firstBrokeragePrice;

    @Schema(description = "Level-2 commission, in cents.", example = "19")
    private Integer secondBrokeragePrice;

    @Schema(description = "Attribute Array.")
    private List<ProductSkuSaveReqVO.Property> properties;

}
