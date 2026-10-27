package cn.iocoder.yudao.module.pay.controller.admin.wallet.vo.wallet;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - userwalletdetail request.")
@Data
public class PayWalletUserReqVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "User ID is required.")
    private Long userId;

}
