package cn.iocoder.yudao.module.erp.controller.admin.product.vo.product;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - ERP product create / edit request.")
@Data
public class ProductSaveReqVO {

    @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15672")
    private Long id;

    @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @NotEmpty(message = "Product name is required.")
    private String name;

    @Schema(description = "Productbarcode.", requiredMode = Schema.RequiredMode.REQUIRED, example = "X110")
    @NotEmpty(message = "Productbarcode is required.")
    private String barCode;

    @Schema(description = "Product category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11161")
    @NotNull(message = "Product category code is required.")
    private Long categoryId;

    @Schema(description = "Order characters code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8869")
    @NotNull(message = "Order characters code is required.")
    private Long unitId;

    @Schema(description = "Product status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Product status cannot be empty.")
    private Integer status;

    @Schema(description = "ProductSKU.", example = "Red")
    private String standard;

    @Schema(description = "Product notes.", example = "Example.")
    private String remark;

    @Schema(description = "Shelf life (days).", example = "10")
    private Integer expiryDay;

    @Schema(description = "Base weight (kg).", example = "1.00")
    private BigDecimal weight;

    @Schema(description = "Purchase price, in dollars.", example = "10.30")
    private BigDecimal purchasePrice;

    @Schema(description = "Sales price, in dollars.", example = "74.32")
    private BigDecimal salePrice;

    @Schema(description = "Min Price, in yuan.", example = "161.87")
    private BigDecimal minPrice;

}