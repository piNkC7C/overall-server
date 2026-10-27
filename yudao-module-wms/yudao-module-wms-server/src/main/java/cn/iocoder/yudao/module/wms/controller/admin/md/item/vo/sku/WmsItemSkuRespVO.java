package cn.iocoder.yudao.module.wms.controller.admin.md.item.vo.sku;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - WMS product SKU response.")
@Data
public class WmsItemSkuRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "SKU name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Black")
    private String name;

    @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long itemId;

    @Schema(description = "Product code.", example = "ITEM001")
    private String itemCode;

    @Schema(description = "Product name.", example = "Huawei nova flip.")
    private String itemName;

    @Schema(description = "Product category code.", example = "1")
    private Long categoryId;

    @Schema(description = "Product category name.", example = "Mobile")
    private String categoryName;

    @Schema(description = "Order characters.", example = "Unit")
    private String unit;

    @Schema(description = "Product brand code.", example = "1")
    private Long brandId;

    @Schema(description = "Product brand name.", example = "Huawei")
    private String brandName;

    @Schema(description = "Barcode.", example = "690000000001")
    private String barCode;

    @Schema(description = "SKU code.", example = "SKU001")
    private String code;

    @Schema(description = "Length, in cm.", example = "10.0")
    private BigDecimal length;

    @Schema(description = "Width, in cm.", example = "8.0")
    private BigDecimal width;

    @Schema(description = "High, order characters cm.", example = "1.0")
    private BigDecimal height;

    @Schema(description = "Gross Weight, order characters kg.", example = "1.000")
    private BigDecimal grossWeight;

    @Schema(description = "Net Weight, order characters kg.", example = "0.900")
    private BigDecimal netWeight;

    @Schema(description = "Cost, in dollars.", example = "5000.00")
    private BigDecimal costPrice;

    @Schema(description = "Sales price, in dollars.", example = "5288.00")
    private BigDecimal sellingPrice;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
