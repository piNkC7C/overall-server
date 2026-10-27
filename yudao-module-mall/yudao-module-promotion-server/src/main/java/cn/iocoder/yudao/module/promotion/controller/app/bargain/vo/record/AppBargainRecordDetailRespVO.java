package cn.iocoder.yudao.module.promotion.controller.app.bargain.vo.record;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "User App - bargain record detail response.")
@Data
public class AppBargainRecordDetailRespVO {

    public static final int HELP_ACTION_NONE = 1; // 帮砍动作 - 未帮砍，可以帮砍
    public static final int HELP_ACTION_FULL = 2; // 帮砍动作 - 未帮砍，无法帮砍（可帮砍次数已满)
    public static final int HELP_ACTION_SUCCESS = 3; // 帮砍动作 - 已帮砍

    // ========== bargain record ==========

    @Schema(description = "Bargain record code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "666")
    private Long userId;

    @Schema(description = "Product SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long spuId;
    @Schema(description = "Product SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long skuId;

    @Schema(description = "Campaign code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sam.")
    private Long activityId;

    @Schema(description = "Bargain start price, in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23")
    private Integer bargainFirstPrice;

    @Schema(description = "Current bargain, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23")
    private Integer bargainPrice;

    @Schema(description = "Bargain record status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    // ========== 订单相关 ========== 注意：只有是自己的砍价记录，才会返回，保证隐私性

    @Schema(description = "Order code.", example = "1024")
    private Long orderId;

    @Schema(description = "Payment status.", example = "true")
    private Boolean payStatus;

    @Schema(description = "Payment code.", example = "1024")
    private Long payOrderId;

    // ========== assist record ==========

    private Integer helpAction;

}
