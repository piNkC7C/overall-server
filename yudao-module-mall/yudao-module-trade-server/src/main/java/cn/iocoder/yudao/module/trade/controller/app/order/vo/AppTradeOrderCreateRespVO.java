package cn.iocoder.yudao.module.trade.controller.app.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "User App - trade ordercreate response.")
@Data
public class AppTradeOrderCreateRespVO {

    @Schema(description = "Order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Payment code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long payOrderId;

}
