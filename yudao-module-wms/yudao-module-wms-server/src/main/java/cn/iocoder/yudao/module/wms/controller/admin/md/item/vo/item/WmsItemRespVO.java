package cn.iocoder.yudao.module.wms.controller.admin.md.item.vo.item;

import cn.iocoder.yudao.module.wms.controller.admin.md.item.vo.sku.WmsItemSkuRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - WMS product response.")
@Data
@ExcelIgnoreUnannotated
public class WmsItemRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Product code.", example = "ITEM001")
    @ExcelProperty("Product Code")
    private String code;

    @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Huawei nova flip.")
    @ExcelProperty("Product Name")
    private String name;

    @Schema(description = "Product category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long categoryId;

    @Schema(description = "Product category name.", example = "Mobile")
    @ExcelProperty("Product Category")
    private String categoryName;

    @Schema(description = "Order characters.", example = "Unit")
    @ExcelProperty("Unit")
    private String unit;

    @Schema(description = "Product brand code.", example = "1")
    private Long brandId;

    @Schema(description = "Product brand name.", example = "Huawei")
    @ExcelProperty("Product Brand")
    private String brandName;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "SKU list.")
    private List<WmsItemSkuRespVO> skus;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
