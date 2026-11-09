package cn.iocoder.yudao.module.product.controller.app.favorite.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Schema(description = "用户 APP - 商品收藏的批量 Request VO") // At Favorite、cancelFavorite、 get Favorite
@Data
public class AppFavoriteBatchReqVO {

    @Schema(description = "商品 SPU 编号数组", requiredMode = Schema.RequiredMode.REQUIRED, example = "29502")
    @NotEmpty(message = "Product SPU ID list is required.")
    private List<Long> spuIds;

}
