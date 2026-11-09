package cn.iocoder.yudao.module.wms.controller.admin.md.item.vo.sku;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - WMS 商品 SKU 创建/更新 Request VO")
@Data
public class WmsItemSkuSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "规格名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Black")
    @NotBlank(message = "SKU name is required.")
    @Size(max = 255, message = "SKU name length cannot exceed 255 characters.")
    private String name;

    @Schema(description = "商品编号", example = "1")
    private Long itemId;

    @Schema(description = "条码", example = "690000000001")
    @Size(max = 64, message = "Barcode length cannot exceed 64 characters.")
    private String barCode;

    @Schema(description = "规格编号", example = "SKU001")
    @Size(max = 64, message = "SKU code length cannot exceed 64 characters.")
    private String code;

    @Schema(description = "长，单位 cm", example = "10.0")
    @DecimalMin(value = "0", message = "Length cannot be less than 0.")
    private BigDecimal length;

    @Schema(description = "宽，单位 cm", example = "8.0")
    @DecimalMin(value = "0", message = "Width cannot be less than 0.")
    private BigDecimal width;

    @Schema(description = "高，单位 cm", example = "1.0")
    @DecimalMin(value = "0", message = "Height cannot be less than 0.")
    private BigDecimal height;

    @Schema(description = "毛重，单位 kg", example = "1.000")
    @DecimalMin(value = "0", message = "Gross weight cannot be less than 0.")
    private BigDecimal grossWeight;

    @Schema(description = "净重，单位 kg", example = "0.900")
    @DecimalMin(value = "0", message = "Net weight cannot be less than 0.")
    private BigDecimal netWeight;

    @Schema(description = "成本价，单位元", example = "5000.00")
    @DecimalMin(value = "0", message = "Cost price cannot be less than 0.")
    private BigDecimal costPrice;

    @Schema(description = "销售价，单位元", example = "5288.00")
    @DecimalMin(value = "0", message = "Selling price cannot be less than 0.")
    private BigDecimal sellingPrice;

}
