package cn.iocoder.yudao.module.pay.controller.app.wallet.vo.recharge;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "User APP - createwallet top-up Resp VO.")
@Data
public class AppPayWalletRechargeCreateRespVO {

    @Schema(description = "Wallet top-up code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Payment code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Long payOrderId;

}
