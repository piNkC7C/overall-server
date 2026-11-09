package cn.iocoder.yudao.module.pay.controller.admin.wallet.vo.wallet;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - 修改钱包余额 Request VO")
@Data
public class PayWalletUpdateBalanceReqVO {

    @Schema(description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "23788")
    @NotNull(message = "User ID is required.")
    private Long userId;

    @Schema(description = "变动余额，正数为增加，负数为减少", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Balance change cannot be empty.")
    private Integer balance;

}
