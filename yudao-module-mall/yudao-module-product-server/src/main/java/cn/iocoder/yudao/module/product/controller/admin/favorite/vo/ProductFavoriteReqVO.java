package cn.iocoder.yudao.module.product.controller.admin.favorite.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Schema(description = "Admin - productFavorite order response.")
@Data
@ToString(callSuper = true)
public class ProductFavoriteReqVO extends  ProductFavoriteBaseVO {

    @Schema(description = "Product SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "32734")
    @NotNull(message = "Product SPU code is required.")
    private Long spuId;
}
