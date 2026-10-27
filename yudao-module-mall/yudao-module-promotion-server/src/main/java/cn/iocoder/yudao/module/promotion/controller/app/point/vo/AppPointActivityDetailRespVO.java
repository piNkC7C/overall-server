package cn.iocoder.yudao.module.promotion.controller.app.point.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Points mall campaign detail response VO.")
@Data
public class AppPointActivityDetailRespVO {

    @Schema(description = "Points shop campaign code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11373")
    private Long id;

    @Schema(description = "Points shop campaignproduct.", requiredMode = Schema.RequiredMode.REQUIRED, example = "19509")
    private Long spuId;

    @Schema(description = "Campaign status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer status;

    @Schema(description = "Points mall stock (remaining stock deducted on points redemption).", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer stock;

    @Schema(description = "Points-mall campaign stock.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer totalStock;

    @Schema(description = "Notes.", example = "Looks good.")
    private String remark;

    @Schema(description = "Product info Array.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Product> products;

    //======================= 显示所需兑换积分最少的 SKU 信息 =======================

    @Schema(description = "Redeem points.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer point;

    @Schema(description = "Redeem amount, in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15860")
    private Integer price;

    @Schema(description = "Product info.")
    @Data
    public static class Product {

        @Schema(description = "Points shop product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "31718")
        private Long id;

        @Schema(description = "Product SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2736")
        private Long skuId;

        @Schema(description = "Redeemable quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3926")
        private Integer count;

        @Schema(description = "Redeem points.", requiredMode = Schema.RequiredMode.REQUIRED)
        private Integer point;

        @Schema(description = "Redeem amount, in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15860")
        private Integer price;

        @Schema(description = "Points shop productinventory.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
        private Integer stock;

    }

}
