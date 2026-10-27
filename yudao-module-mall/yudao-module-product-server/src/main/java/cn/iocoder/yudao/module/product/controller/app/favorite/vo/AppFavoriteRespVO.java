package cn.iocoder.yudao.module.product.controller.app.favorite.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "User App - productFavorite response.")
@Data
public class AppFavoriteRespVO {

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

}
