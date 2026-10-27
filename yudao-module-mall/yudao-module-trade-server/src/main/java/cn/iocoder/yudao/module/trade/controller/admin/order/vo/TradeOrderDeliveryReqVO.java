package cn.iocoder.yudao.module.trade.controller.admin.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - order shipping request.")
@Data
public class TradeOrderDeliveryReqVO {

    @Schema(description = "Order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Order code is required.")
    private Long id;

    @Schema(description = "Shipping carrierID.", example = "1")
    @NotNull(message = "Shipping carrier cannot be empty.")
    private Long logisticsId;

    @Schema(description = "Shipping tracking number.", example = "SF123456789")
    private String logisticsNo;

}
