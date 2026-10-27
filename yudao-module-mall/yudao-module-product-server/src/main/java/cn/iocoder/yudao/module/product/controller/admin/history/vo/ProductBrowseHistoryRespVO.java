package cn.iocoder.yudao.module.product.controller.admin.history.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;

@Schema(description = "Admin - productViewsrecord response.")
@Data
@ExcelIgnoreUnannotated
public class ProductBrowseHistoryRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Product SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "29502")
    private Long spuId;

    // ========== 商品相关字段 ==========

    @Schema(description = "Product SPU name.", example = "Sam.")
    private String spuName;

    @Schema(description = "Product cover image", example = "https://domain/pic.png")
    private String picUrl;

    @Schema(description = "ProductUnit Price.", example = "100")
    private Integer price;

    @Schema(description = "Product sales", example = "100")
    private Integer salesCount;

    @Schema(description = "Inventory.", example = "100")
    private Integer stock;

}
