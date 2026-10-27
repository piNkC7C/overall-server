package cn.iocoder.yudao.module.product.controller.admin.spu.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.framework.excel.core.convert.MoneyConvert;
import cn.iocoder.yudao.module.product.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - product SPU response.")
@Data
@ExcelIgnoreUnannotated
public class ProductSpuRespVO {

    @Schema(description = "Product SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "111")
    @ExcelProperty("Product Code")
    private Long id;

    @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cool T-shirt")
    @ExcelProperty("Product Name")
    private String name;

    @Schema(description = "Keyword.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cool, smooth, and sweat-free")
    @ExcelProperty("Keywords")
    private String keyword;

    @Schema(description = "Product bio.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cool T-shirt intro")
    @ExcelProperty("Product Intro")
    private String introduction;

    @Schema(description = "Product details.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cool tee details")
    @ExcelProperty("Product Details")
    private String description;

    @Schema(description = "Product category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Product Category ID")
    private Long categoryId;

    @Schema(description = "Product brand code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Product Brand ID")
    private Long brandId;

    @Schema(description = "Product cover image", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xx.png")
    @ExcelProperty("Product Cover Image")
    private String picUrl;

    @Schema(description = "Product carousel images.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[https://www.iocoder.cn/xx.png, https://www.iocoder.cn/xxx.png]")
    private List<String> sliderPicUrls;

    @Schema(description = "Sort field.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Sort Field")
    private Integer sort;

    @Schema(description = "Product status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Product Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.PRODUCT_SPU_STATUS)
    private Integer status;

    @Schema(description = "Productcreate time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2023-05-24 00:00:00")
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    // ========== SKU 相关字段 =========

    @Schema(description = "SKU type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @ExcelProperty("Spec Type")
    private Boolean specType;

    @Schema(description = "ProductPrice.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1999")
    @ExcelProperty(value = "Product Price", converter = MoneyConvert.class)
    private Integer price;

    @Schema(description = "Market Price, order characters used：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "199")
    @ExcelProperty(value = "Market Price", converter = MoneyConvert.class)
    private Integer marketPrice;

    @Schema(description = "Cost, in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "19")
    @ExcelProperty(value = "Cost", converter = MoneyConvert.class)
    private Integer costPrice;

    @Schema(description = "Productinventory.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10000")
    @ExcelProperty("Inventory")
    private Integer stock;

    @Schema(description = "SKU Array.")
    private List<ProductSkuRespVO> skus;

    // ========== 物流相关字段 =========

    @Schema(description = "Delivery MethodArray.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private List<Integer> deliveryTypes;

    @Schema(description = "Shipping template ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "111")
    @ExcelProperty("Shipping Template ID")
    private Long deliveryTemplateId;

    // ========== 营销相关字段 =========

    @Schema(description = "Bonus points.", requiredMode = Schema.RequiredMode.REQUIRED, example = "111")
    @ExcelProperty("Bonus Points")
    private Integer giveIntegral;

    @Schema(description = "Distribution type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @ExcelProperty("Distribution Type")
    private Boolean subCommissionType;

    // ========== 统计相关字段 =========

    @Schema(description = "Product sales", requiredMode = Schema.RequiredMode.REQUIRED, example = "2000")
    @ExcelProperty("Product Sales")
    private Integer salesCount;

    @Schema(description = "Virtual sales.", example = "66")
    @ExcelProperty("Virtual Sales")
    private Integer virtualSalesCount;

    @Schema(description = "Views.", requiredMode = Schema.RequiredMode.REQUIRED, example = "888")
    @ExcelProperty("Product Clicks")
    private Integer browseCount;

}
