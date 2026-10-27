package cn.iocoder.yudao.module.product.api.sku.dto;

import cn.iocoder.yudao.module.product.api.property.dto.ProductPropertyValueDetailRespDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "RPC service - product SKU info Response DTO.")
@Data
public class ProductSkuRespDTO {

    @Schema(description = "Product SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;
    @Schema(description = "SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long spuId;

    @Schema(description = "Attribute Array.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<ProductPropertyValueDetailRespDTO> properties;

    @Schema(description = "Sales Price, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer price;
    @Schema(description = "Market Price, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    private Integer marketPrice;
    @Schema(description = "Cost price, in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "300")
    private Integer costPrice;
    @Schema(description = "SKU barcode.", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456789")
    private String barCode;
    @Schema(description = "ImageAddress.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xxx.jpg")
    private String picUrl;

    @Schema(description = "Inventory.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer stock;
    @Schema(description = "Product weight, in kg.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1.5")
    private Double weight;
    @Schema(description = "Product volume, in m³.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3.0")
    private Double volume;

    @Schema(description = "Level-1 commission, in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "550")
    private Integer firstBrokeragePrice;
    @Schema(description = "Level-2 commission, in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "250")
    private Integer secondBrokeragePrice;

}
