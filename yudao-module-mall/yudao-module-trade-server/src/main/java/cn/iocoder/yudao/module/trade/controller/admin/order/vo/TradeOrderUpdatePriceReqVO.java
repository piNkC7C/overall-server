package cn.iocoder.yudao.module.trade.controller.admin.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Schema(description = "管理后台 - 订单改价 Request VO")
@Data
public class TradeOrderUpdatePriceReqVO {

    @Schema(description = "订单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Order code is required.")
    private Long id;

    @Schema(description = "订单调价，单位：分。正数，加价；负数，减价", requiredMode = Schema.RequiredMode.REQUIRED, example = "-100")
    @NotNull(message = "Order price adjustment cannot be empty.")
    private Integer adjustPrice;

}
