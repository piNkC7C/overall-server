package cn.iocoder.yudao.module.wms.controller.admin.md.item.vo.sku;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - WMS product SKU create or update request.")
@Data
public class WmsItemSkuSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "SKU name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Black")
    @NotBlank(message = "SKU name is required.")
    @Size(max = 255, message = "SKU name length cannot exceed 255 characters.")
    private String name;

    @Schema(description = "Product code.", example = "1")
    private Long itemId;

    @Schema(description = "Barcode.", example = "690000000001")
    @Size(max = 64, message = "Barcode length cannot exceed 64 characters.")
    private String barCode;

    @Schema(description = "SKU code.", example = "SKU001")
    @Size(max = 64, message = "SKU code length cannot exceed 64 characters.")
    private String code;

    @Schema(description = "Length, in cm.", example = "10.0")
    @DecimalMin(value = "0", message = "Length cannot be less than 0.")
    private BigDecimal length;

    @Schema(description = "Width, in cm.", example = "8.0")
    @DecimalMin(value = "0", message = "Width cannot be less than 0.")
    private BigDecimal width;

    @Schema(description = "High, order characters cm.", example = "1.0")
    @DecimalMin(value = "0", message = "Height cannot be less than 0.")
    private BigDecimal height;

    @Schema(description = "Gross Weight, order characters kg.", example = "1.000")
    @DecimalMin(value = "0", message = "Gross weight cannot be less than 0.")
    private BigDecimal grossWeight;

    @Schema(description = "Net Weight, order characters kg.", example = "0.900")
    @DecimalMin(value = "0", message = "Net weight cannot be less than 0.")
    private BigDecimal netWeight;

    @Schema(description = "Cost, in dollars.", example = "5000.00")
    @DecimalMin(value = "0", message = "Cost price cannot be less than 0.")
    private BigDecimal costPrice;

    @Schema(description = "Sales price, in dollars.", example = "5288.00")
    @DecimalMin(value = "0", message = "Selling price cannot be less than 0.")
    private BigDecimal sellingPrice;

}
