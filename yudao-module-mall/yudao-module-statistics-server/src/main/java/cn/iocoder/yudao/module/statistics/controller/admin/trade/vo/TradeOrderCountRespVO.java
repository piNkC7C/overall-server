package cn.iocoder.yudao.module.statistics.controller.admin.trade.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - trade order quantity response.")
@Data
public class TradeOrderCountRespVO {

    @Schema(description = "To ship.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long undelivered;

    @Schema(description = "To write off.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long pickUp;

    @Schema(description = "Refund.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long afterSaleApply;

    @Schema(description = "Withdrawals pending review.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long auditingWithdraw;

}
