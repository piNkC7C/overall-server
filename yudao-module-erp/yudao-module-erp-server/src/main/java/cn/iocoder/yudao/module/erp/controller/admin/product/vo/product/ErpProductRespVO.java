package cn.iocoder.yudao.module.erp.controller.admin.product.vo.product;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - ERP 产品 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ErpProductRespVO {

    @Schema(description = "产品编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "15672")
    @ExcelProperty("Product Code")
    private Long id;

    @Schema(description = "产品名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @ExcelProperty("Product Name")
    private String name;

    @Schema(description = "产品条码", requiredMode = Schema.RequiredMode.REQUIRED, example = "X110")
    @ExcelProperty("Product Barcode")
    private String barCode;

    @Schema(description = "产品分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "11161")
    private Long categoryId;
    @Schema(description = "产品分类", requiredMode = Schema.RequiredMode.REQUIRED, example = "Fruit")
    @ExcelProperty("Product Category")
    private String categoryName;

    @Schema(description = "单位编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "8869")
    private Long unitId;
    @Schema(description = "单位", requiredMode = Schema.RequiredMode.REQUIRED, example = "")
    @ExcelProperty("Unit")
    private String unitName;

    @Schema(description = "产品状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("Product Status")
    private Integer status;

    @Schema(description = "产品规格", example = "Red")
    @ExcelProperty("Product Spec")
    private String standard;

    @Schema(description = "产品备注", example = "Example.")
    @ExcelProperty("Product Notes")
    private String remark;

    @Schema(description = "保质期天数", example = "10")
    @ExcelProperty("Shelf Life (days)")
    private Integer expiryDay;

    @Schema(description = "基础重量（kg）", example = "1.00")
    @ExcelProperty("Base Weight (kg)")
    private BigDecimal weight;

    @Schema(description = "采购价格，单位：元", example = "10.30")
    @ExcelProperty("Purchase Price, In Dollars")
    private BigDecimal purchasePrice;

    @Schema(description = "销售价格，单位：元", example = "74.32")
    @ExcelProperty("Sales Price, In Dollars")
    private BigDecimal salePrice;

    @Schema(description = "最低价格，单位：元", example = "161.87")
    @ExcelProperty("Min Price, In Dollars")
    private BigDecimal minPrice;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}