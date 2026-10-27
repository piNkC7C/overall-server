package cn.iocoder.yudao.module.erp.controller.admin.stock.vo.record;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.erp.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - ERP productinventorydetail response.")
@Data
@ExcelIgnoreUnannotated
public class ErpStockRecordRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "18909")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10625")
    private Long productId;

    @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "32407")
    private Long warehouseId;

    @Schema(description = "Inventory quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11084")
    @ExcelProperty("In/out Quantity")
    private BigDecimal count;

    @Schema(description = "Total stock.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4307")
    @ExcelProperty("Total Stock")
    private BigDecimal totalCount;

    @Schema(description = "Business type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @ExcelProperty(value = "Business Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.STOCK_RECORD_BIZ_TYPE)
    private Integer bizType;

    @Schema(description = "Business code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "27093")
    @ExcelProperty("Business ID")
    private Long bizId;

    @Schema(description = "Business item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23516")
    @ExcelProperty("Business Item ID")
    private Long bizItemId;

    @Schema(description = "Business order no.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Z110")
    @ExcelProperty("Business Order No")
    private String bizNo;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @Schema(description = "Creator.", requiredMode = Schema.RequiredMode.REQUIRED, example = "25682")
    private String creator;

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

    // ========== user info ==========

    @Schema(description = "Creator.", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    @ExcelProperty("Creator")
    private String creatorName;

}