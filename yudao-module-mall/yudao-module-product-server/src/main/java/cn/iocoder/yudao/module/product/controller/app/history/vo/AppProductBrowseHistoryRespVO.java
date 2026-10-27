package cn.iocoder.yudao.module.product.controller.app.history.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "App - productViewsrecord response.")
@Data
public class AppProductBrowseHistoryRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Product SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "29502")
    private Long spuId;

    // ========== 商品相关字段 ==========

    @Schema(description = "Product SPU name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sam.")
    private String spuName;

    @Schema(description = "Product cover image", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/pic.png")
    private String picUrl;

    @Schema(description = "ProductUnit Price.", requiredMode = Schema.RequiredMode.REQUIRED, example = "50")
    private Integer price;

    @Schema(description = "Product sales", requiredMode = Schema.RequiredMode.REQUIRED, example = "60")
    private Integer salesCount;

    @Schema(description = "Inventory.", requiredMode = Schema.RequiredMode.REQUIRED, example = "80")
    private Integer stock;

}
