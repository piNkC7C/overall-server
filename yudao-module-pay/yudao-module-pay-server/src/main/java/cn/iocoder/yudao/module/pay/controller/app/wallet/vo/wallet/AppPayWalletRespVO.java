package cn.iocoder.yudao.module.pay.controller.app.wallet.vo.wallet;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "User APP - userwallet response.")
@Data
public class AppPayWalletRespVO {

    @Schema(description = "Wallet balance, order characters Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer balance;

    @Schema(description = "Total spend, in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1000")
    private Integer totalExpense;

    @Schema(description = "Total top-up, in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2000")
    private Integer totalRecharge;

}
