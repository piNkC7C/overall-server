package cn.iocoder.yudao.module.trade.controller.admin.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - trade orderStats response.")
@Data
public class TradeOrderSummaryRespVO {

    @Schema(description = "Order quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long orderCount;

    @Schema(description = "Order amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long orderPayPrice;

    @Schema(description = "Refund count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long afterSaleCount;

    @Schema(description = "Refund amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long afterSalePrice;

}
