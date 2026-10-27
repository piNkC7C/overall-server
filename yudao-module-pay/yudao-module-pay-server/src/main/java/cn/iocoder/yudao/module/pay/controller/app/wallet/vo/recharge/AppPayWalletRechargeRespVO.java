package cn.iocoder.yudao.module.pay.controller.app.wallet.vo.recharge;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "User APP - wallet top-up record Resp VO.")
@Data
public class AppPayWalletRechargeRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "User received balance.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer totalPrice;

    @Schema(description = "Actual payment amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    private Integer payPrice;

    @Schema(description = "WalletBonus amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "80")
    private Integer bonusPrice;

    @Schema(description = "Payment succeeded payment channel.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String payChannelCode;

    @Schema(description = "Payment channel name.", example = "WeChat Mini Program Pay")
    private String payChannelName;

    @Schema(description = "Payment code.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long payOrderId;

    @Schema(description = "Paid external order no.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String payOrderChannelOrderNo; // From PayOrderDO channelOrderNo field

    @Schema(description = "Order payment time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime payTime;

    @Schema(description = "Refund status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer refundStatus;

}
