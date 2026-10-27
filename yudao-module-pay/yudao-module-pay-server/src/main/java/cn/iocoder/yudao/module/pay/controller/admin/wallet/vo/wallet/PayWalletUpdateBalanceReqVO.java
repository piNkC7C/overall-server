package cn.iocoder.yudao.module.pay.controller.admin.wallet.vo.wallet;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - edit wallet balance request.")
@Data
public class PayWalletUpdateBalanceReqVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23788")
    @NotNull(message = "User ID is required.")
    private Long userId;

    @Schema(description = "Change Balance, positive adds, negative subtracts.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Balance change cannot be empty.")
    private Integer balance;

}
