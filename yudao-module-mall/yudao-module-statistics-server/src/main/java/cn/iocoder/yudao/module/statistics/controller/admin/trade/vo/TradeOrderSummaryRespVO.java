package cn.iocoder.yudao.module.statistics.controller.admin.trade.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - trade orderStats response.")
@Data
public class TradeOrderSummaryRespVO {

    @Schema(description = "Paid order item count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer orderPayCount;

    @Schema(description = "Total paid amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer orderPayPrice;

}
