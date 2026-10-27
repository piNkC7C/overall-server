package cn.iocoder.yudao.module.trade.controller.app.cart.vo;

import cn.iocoder.yudao.module.trade.controller.app.base.sku.AppProductSkuBaseRespVO;
import cn.iocoder.yudao.module.trade.controller.app.base.spu.AppProductSpuBaseRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "User cart list response VO.")
@Data
public class AppCartListRespVO {

    /**
     * 有效的购物项数组
     */
    private List<Cart> validList;

    /**
     * 无效的购物项数组
     */
    private List<Cart> invalidList;

    @Schema(description = "Cart item.")
    @Data
    public static class Cart {

        @Schema(description = "Cart item ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long id;

        @Schema(description = "Product quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Integer count;

        @Schema(description = "Selected.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
        private Boolean selected;

        /**
         * 商品 SPU
         */
        private AppProductSpuBaseRespVO spu;
        /**
         * 商品 SKU
         */
        private AppProductSkuBaseRespVO sku;

    }

}
