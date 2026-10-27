package cn.iocoder.yudao.module.promotion.controller.app.seckill.vo.activity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Flash-sale campaign detail response VO.")
@Data
public class AppSeckillActivityDetailRespVO {

    @Schema(description = "Flash sale campaign code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Flash sale campaign name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "9 PM flash sale")
    private String name;

    @Schema(description = "Campaign status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Campaign start time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime startTime;

    @Schema(description = "Campaign end time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime endTime;

    @Schema(description = "Product SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long spuId;

    @Schema(description = "Purchase limit.", example = "10")
    private Integer totalLimitCount;

    @Schema(description = "Per-order purchase limit.", example = "5")
    private Integer singleLimitCount;

    @Schema(description = "Flash-sale stock remaining.", requiredMode = Schema.RequiredMode.REQUIRED, example = "50")
    private Integer stock;

    @Schema(description = "Flash sale inventory (Total).", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer totalStock;

    @Schema(description = "Product info Array.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Product> products;

    @Schema(description = "Product info.")
    @Data
    public static class Product {

        @Schema(description = "Product SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4096")
        private Long skuId;

        @Schema(description = "Flash sale amount, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
        private Integer seckillPrice;

        @Schema(description = "Flash-sale limited stock.", requiredMode = Schema.RequiredMode.REQUIRED, example = "50")
        private Integer stock;

    }

}
