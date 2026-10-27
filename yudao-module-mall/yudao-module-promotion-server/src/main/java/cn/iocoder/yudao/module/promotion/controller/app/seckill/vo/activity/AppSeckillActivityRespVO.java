package cn.iocoder.yudao.module.promotion.controller.app.seckill.vo.activity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "User App - flash sale campaign response.")
@Data
public class AppSeckillActivityRespVO {

    @Schema(description = "Flash sale campaign code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Flash sale campaign name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "9 PM flash sale")
    private String name;

    @Schema(description = "Product SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long spuId;

    @Schema(description = "Product SPU name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "One cabbage")
    private String spuName; // 从 SPU 的 name 读取

    @Schema(description = "Product Image", requiredMode = Schema.RequiredMode.REQUIRED, // 从 SPU 的 picUrl 读取
            example = "https://www.iocoder.cn/xx.png")
    private String picUrl;

    @Schema(description = "Market price, in cents", requiredMode = Schema.RequiredMode.REQUIRED, // 从 SPU 的 marketPrice 读取
            example = "50")
    private Integer marketPrice;

    @Schema(description = "Flash sale campaign status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Flash-sale stock remaining.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer stock;
    @Schema(description = "Flash-sale stock (total).", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    private Integer totalStock;

    @Schema(description = "Flash sale amount, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer seckillPrice;

}
