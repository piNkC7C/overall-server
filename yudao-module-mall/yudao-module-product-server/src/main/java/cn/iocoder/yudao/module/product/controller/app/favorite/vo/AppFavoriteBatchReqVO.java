package cn.iocoder.yudao.module.product.controller.app.favorite.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Schema(description = "User APP - productFavorite batch request.") // At Favorite、cancelFavorite、 get Favorite
@Data
public class AppFavoriteBatchReqVO {

    @Schema(description = "Product SPU ID list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "29502")
    @NotEmpty(message = "Product SPU ID list is required.")
    private List<Long> spuIds;

}
