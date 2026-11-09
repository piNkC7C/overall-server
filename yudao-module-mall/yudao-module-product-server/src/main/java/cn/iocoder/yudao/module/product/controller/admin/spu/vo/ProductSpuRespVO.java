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

@Schema(description = "管理后台 - 商品 SPU Response VO")
@Data
@ExcelIgnoreUnannotated
public class ProductSpuRespVO {

    @Schema(description = "商品 SPU 编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "111")
    @ExcelProperty("Product Code")
    private Long id;

    @Schema(description = "商品名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cool T-shirt")
    @ExcelProperty("Product Name")
    private String name;

    @Schema(description = "关键字", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cool, smooth, and sweat-free")
    @ExcelProperty("Keywords")
    private String keyword;

    @Schema(description = "商品简介", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cool T-shirt intro")
    @ExcelProperty("Product Intro")
    private String introduction;

    @Schema(description = "商品详情", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cool tee details")
    @ExcelProperty("Product Details")
    private String description;

    @Schema(description = "商品分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Product Category ID")
    private Long categoryId;

    @Schema(description = "商品品牌编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Product Brand ID")
    private Long brandId;

    @Schema(description = "商品封面图", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xx.png")
    @ExcelProperty("Product Cover Image")
    private String picUrl;

    @Schema(description = "商品轮播图", requiredMode = Schema.RequiredMode.REQUIRED, example = "[https://www.iocoder.cn/xx.png, https://www.iocoder.cn/xxx.png]")
    private List<String> sliderPicUrls;

    @Schema(description = "排序字段", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Sort Field")
    private Integer sort;

    @Schema(description = "商品状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Product Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.PRODUCT_SPU_STATUS)
    private Integer status;

    @Schema(description = "商品创建时间", requiredMode = Schema.RequiredMode.REQUIRED, example = "2023-05-24 00:00:00")
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    // ========== SKU 相关字段 =========

    @Schema(description = "规格类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @ExcelProperty("Spec Type")
    private Boolean specType;

    @Schema(description = "商品价格", requiredMode = Schema.RequiredMode.REQUIRED, example = "1999")
    @ExcelProperty(value = "Product Price", converter = MoneyConvert.class)
    private Integer price;

    @Schema(description = "市场价，单位使用：分", requiredMode = Schema.RequiredMode.REQUIRED, example = "199")
    @ExcelProperty(value = "Market Price", converter = MoneyConvert.class)
    private Integer marketPrice;

    @Schema(description = "成本价，单位使用：分", requiredMode = Schema.RequiredMode.REQUIRED, example = "19")
    @ExcelProperty(value = "Cost", converter = MoneyConvert.class)
    private Integer costPrice;

    @Schema(description = "商品库存", requiredMode = Schema.RequiredMode.REQUIRED, example = "10000")
    @ExcelProperty("Inventory")
    private Integer stock;

    @Schema(description = "SKU 数组")
    private List<ProductSkuRespVO> skus;

    // ========== 物流相关字段 =========

    @Schema(description = "配送方式数组", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private List<Integer> deliveryTypes;

    @Schema(description = "物流配置模板编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "111")
    @ExcelProperty("Shipping Template ID")
    private Long deliveryTemplateId;

    // ========== 营销相关字段 =========

    @Schema(description = "赠送积分", requiredMode = Schema.RequiredMode.REQUIRED, example = "111")
    @ExcelProperty("Bonus Points")
    private Integer giveIntegral;

    @Schema(description = "分销类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @ExcelProperty("Distribution Type")
    private Boolean subCommissionType;

    // ========== 统计相关字段 =========

    @Schema(description = "商品销量", requiredMode = Schema.RequiredMode.REQUIRED, example = "2000")
    @ExcelProperty("Product Sales")
    private Integer salesCount;

    @Schema(description = "虚拟销量", example = "66")
    @ExcelProperty("Virtual Sales")
    private Integer virtualSalesCount;

    @Schema(description = "浏览量", requiredMode = Schema.RequiredMode.REQUIRED, example = "888")
    @ExcelProperty("Product Clicks")
    private Integer browseCount;

}
