package cn.iocoder.yudao.module.promotion.controller.app.bargain.vo.activity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "User App - bargain campaign response.")
@Data
public class AppBargainActivityRespVO {

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

    @Schema(description = "Bargain inventory.", requiredMode = Schema.RequiredMode.REQUIRED, example = "512")
    private Integer stock;

    @Schema(description = "Product Image", requiredMode = Schema.RequiredMode.REQUIRED,  // 从 SPU 的 picUrl 读取
            example = "4096")
    private String picUrl;
    @Schema(description = "Market price, in cents", requiredMode = Schema.RequiredMode.REQUIRED,  // 从 SPU 的 marketPrice 读取
            example = "50")
    private Integer marketPrice;

    @Schema(description = "Bargain floor, in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer bargainMinPrice;

}
