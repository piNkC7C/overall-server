package cn.iocoder.yudao.module.promotion.controller.app.combination.vo.activity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "User App - group buy campaign response.")
@Data
public class AppCombinationActivityRespVO {

    @Schema(description = "Group buy campaign code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Group buy campaign name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Summer group buy")
    private String name;

    @Schema(description = "Group-buy size.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Integer userSize;

    @Schema(description = "Product SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long spuId;

    @Schema(description = "Product SPU name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "One cabbage")
    private String spuName; // 从 SPU 的 name 读取
    @Schema(description = "Product Image", requiredMode = Schema.RequiredMode.REQUIRED, example = "4096")
    private String picUrl; // 从 SPU 的 picUrl 读取
    @Schema(description = "Market price, in cents", requiredMode = Schema.RequiredMode.REQUIRED, example = "50")
    private Integer marketPrice; // 从 SPU 的 marketPrice 读取

    @Schema(description = "Group buy amount, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer combinationPrice; // 从 products 获取最小 price 读取

}
