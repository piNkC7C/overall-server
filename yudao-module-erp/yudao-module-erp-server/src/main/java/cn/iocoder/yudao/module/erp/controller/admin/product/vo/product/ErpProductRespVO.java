package cn.iocoder.yudao.module.erp.controller.admin.product.vo.product;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - ERP product response.")
@Data
@ExcelIgnoreUnannotated
public class ErpProductRespVO {

    @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15672")
    @ExcelProperty("Product Code")
    private Long id;

    @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @ExcelProperty("Product Name")
    private String name;

    @Schema(description = "Productbarcode.", requiredMode = Schema.RequiredMode.REQUIRED, example = "X110")
    @ExcelProperty("Product Barcode")
    private String barCode;

    @Schema(description = "Product category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11161")
    private Long categoryId;
    @Schema(description = "Product category.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Fruit")
    @ExcelProperty("Product Category")
    private String categoryName;

    @Schema(description = "Order characters code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8869")
    private Long unitId;
    @Schema(description = "Order characters.", requiredMode = Schema.RequiredMode.REQUIRED, example = "")
    @ExcelProperty("Unit")
    private String unitName;

    @Schema(description = "Product status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("Product Status")
    private Integer status;

    @Schema(description = "ProductSKU.", example = "Red")
    @ExcelProperty("Product Spec")
    private String standard;

    @Schema(description = "Product notes.", example = "Example.")
    @ExcelProperty("Product Notes")
    private String remark;

    @Schema(description = "Shelf life (days).", example = "10")
    @ExcelProperty("Shelf Life (days)")
    private Integer expiryDay;

    @Schema(description = "Base weight (kg).", example = "1.00")
    @ExcelProperty("Base Weight (kg)")
    private BigDecimal weight;

    @Schema(description = "Purchase price, in dollars.", example = "10.30")
    @ExcelProperty("Purchase Price, In Dollars")
    private BigDecimal purchasePrice;

    @Schema(description = "Sales price, in dollars.", example = "74.32")
    @ExcelProperty("Sales Price, In Dollars")
    private BigDecimal salePrice;

    @Schema(description = "Min Price, in yuan.", example = "161.87")
    @ExcelProperty("Min Price, In Dollars")
    private BigDecimal minPrice;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}