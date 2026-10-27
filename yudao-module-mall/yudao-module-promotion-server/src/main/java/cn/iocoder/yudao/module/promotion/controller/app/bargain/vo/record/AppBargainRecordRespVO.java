package cn.iocoder.yudao.module.promotion.controller.app.bargain.vo.record;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "User App - bargain record response.")
@Data
public class AppBargainRecordRespVO {

    @Schema(description = "Bargain record code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Product SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long spuId;
    @Schema(description = "Product SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long skuId;

    @Schema(description = "Campaign code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "22901")
    private Long activityId;

    @Schema(description = "Bargain record status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Current Price.", requiredMode = Schema.RequiredMode.REQUIRED, example = "102")
    private Integer bargainPrice;

    // ========== 活动相关 ==========

    @Schema(description = "Campaign name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sam.")
    private String activityName;

    @Schema(description = "Campaign end time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime endTime;

    @Schema(description = "Product Image", requiredMode = Schema.RequiredMode.REQUIRED,  // 从 SPU 的 picUrl 读取
            example = "https://www.iocoder.cn/xx.png")
    private String picUrl;

    // ========== 订单相关 ==========

    @Schema(description = "Order code.", example = "1024")
    private Long orderId;

    @Schema(description = "Payment status.", example = "true")
    private Boolean payStatus;

    @Schema(description = "Payment code.", example = "1024")
    private Long payOrderId;

}
