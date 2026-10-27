package cn.iocoder.yudao.module.promotion.controller.app.combination.vo.activity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "User App - group buy campaigndetail response.")
@Data
public class AppCombinationActivityDetailRespVO {

    @Schema(description = "Group buy campaign code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Group buy campaign name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Summer group buy")
    private String name;

    @Schema(description = "Campaign status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Campaign start time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime startTime;

    @Schema(description = "Campaign end time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime endTime;

    @Schema(description = "Group-buy size.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Integer userSize;

    @Schema(description = "Succeeded group buy quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer successCount;

    @Schema(description = "Product SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long spuId;

    @Schema(description = "Purchase limit.", example = "10")
    private Integer totalLimitCount;

    @Schema(description = "Per-order purchase limit.", example = "5")
    private Integer singleLimitCount;

    @Schema(description = "Product info Array.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Product> products;

    @Schema(description = "Product info.")
    @Data
    public static class Product {

        @Schema(description = "Product SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4096")
        private Long skuId;

        @Schema(description = "Group buy amount, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
        private Integer combinationPrice;

    }

}
