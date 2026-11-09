package cn.iocoder.yudao.module.wms.controller.admin.md.item.vo.item;

import cn.iocoder.yudao.module.wms.controller.admin.md.item.vo.sku.WmsItemSkuRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - WMS 商品 Response VO")
@Data
@ExcelIgnoreUnannotated
public class WmsItemRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "商品编号", example = "ITEM001")
    @ExcelProperty("Product Code")
    private String code;

    @Schema(description = "商品名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Huawei nova flip.")
    @ExcelProperty("Product Name")
    private String name;

    @Schema(description = "商品分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long categoryId;

    @Schema(description = "商品分类名称", example = "Mobile")
    @ExcelProperty("Product Category")
    private String categoryName;

    @Schema(description = "单位", example = "Unit")
    @ExcelProperty("Unit")
    private String unit;

    @Schema(description = "商品品牌编号", example = "1")
    private Long brandId;

    @Schema(description = "商品品牌名称", example = "Huawei")
    @ExcelProperty("Product Brand")
    private String brandName;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "规格列表")
    private List<WmsItemSkuRespVO> skus;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
