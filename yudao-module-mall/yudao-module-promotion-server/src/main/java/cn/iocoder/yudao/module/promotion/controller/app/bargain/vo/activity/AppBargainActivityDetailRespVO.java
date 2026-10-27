package cn.iocoder.yudao.module.promotion.controller.app.bargain.vo.activity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "User App - bargain campaign detail response.")
@Data
public class AppBargainActivityDetailRespVO {

    @Schema(description = "Bargain campaign code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Bargain campaign name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Summer bargain")
    private String name;

    @Schema(description = "Campaign start time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime startTime;

    @Schema(description = "Campaign end time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime endTime;

    @Schema(description = "Product SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long spuId;

    @Schema(description = "Product SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long skuId;

    @Schema(description = "ProductPrice, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer price;

    @Schema(description = "ProductDescription.", requiredMode = Schema.RequiredMode.REQUIRED, example = "I want tomatoes")
    private String description;

    @Schema(description = "Bargain inventory.", requiredMode = Schema.RequiredMode.REQUIRED, example = "512")
    private Integer stock;

    @Schema(description = "Product Image", requiredMode = Schema.RequiredMode.REQUIRED, example = "4096") // 从 SPU 的 picUrl 读取
    private String picUrl;

    @Schema(description = "Market price, in cents", requiredMode = Schema.RequiredMode.REQUIRED, example = "50") // 从 SPU 的 marketPrice 读取
    private Integer marketPrice;

    @Schema(description = "Bargain start price, in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    private Integer bargainFirstPrice;

    @Schema(description = "Bargain floor, in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer bargainMinPrice;

    @Schema(description = "Bargain succeeded quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer successUserCount;

}
