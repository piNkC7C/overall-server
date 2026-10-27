package cn.iocoder.yudao.module.trade.controller.admin.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Order price-change request VO.")
@Data
public class TradeOrderUpdatePriceReqVO {

    @Schema(description = "Order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Order code is required.")
    private Long id;

    @Schema(description = "Order price adjustment in cents. Positive increases the price; negative decreases it.", requiredMode = Schema.RequiredMode.REQUIRED, example = "-100")
    @NotNull(message = "Order price adjustment cannot be empty.")
    private Integer adjustPrice;

}
