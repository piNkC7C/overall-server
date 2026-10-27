package cn.iocoder.yudao.module.erp.controller.admin.stock.vo.stock;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;

@Schema(description = "Admin - ERP inventory response.")
@Data
@ExcelIgnoreUnannotated
public class ErpStockRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "17086")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "19614")
    private Long productId;

    @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2802")
    private Long warehouseId;

    @Schema(description = "Inventory quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "21935")
    @ExcelProperty("Inventory Quantity")
    private BigDecimal count;

    // ========== product info ==========

    @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Apple")
    @ExcelProperty("Product Name")
    private String productName;

    @Schema(description = "Product category.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Fruit")
    @ExcelProperty("Product Category")
    private String categoryName;

    @Schema(description = "Order characters.", requiredMode = Schema.RequiredMode.REQUIRED, example = "")
    @ExcelProperty("Unit")
    private String unitName;

    // ========== warehouse info ==========

    @Schema(description = "Warehouse name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @ExcelProperty("Warehouse Name")
    private String warehouseName;

}