package cn.iocoder.yudao.module.product.controller.app.favorite.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Schema(description = "User APP - productFavorite order request.") // At Favorite、cancelFavorite、 get Favorite
@Data
public class AppFavoriteReqVO {

    @Schema(description = "Product SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "29502")
    @NotNull(message = "Product SPU code is required.")
    private Long spuId;

}
