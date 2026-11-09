package cn.iocoder.yudao.module.product.controller.app.favorite.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Schema(description = "用户 APP - 商品收藏的单个 Request VO") // At Favorite、cancelFavorite、 get Favorite
@Data
public class AppFavoriteReqVO {

    @Schema(description = "商品 SPU 编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "29502")
    @NotNull(message = "Product SPU code is required.")
    private Long spuId;

}
