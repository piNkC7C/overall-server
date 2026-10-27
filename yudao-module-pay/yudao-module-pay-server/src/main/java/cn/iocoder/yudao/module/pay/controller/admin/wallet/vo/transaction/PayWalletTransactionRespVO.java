package cn.iocoder.yudao.module.pay.controller.admin.wallet.vo.transaction;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "App - wallet transactionpage response.")
@Data
public class PayWalletTransactionRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Wallet code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    private Long walletId;

    @Schema(description = "Business category.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer bizType;

    @Schema(description = "Trade amount, order characters Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Long price;

    @Schema(description = "Transaction title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Potatopotato.")
    private String title;

    @Schema(description = "Trade after balance, order characters Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Long balance;

    @Schema(description = "Trade time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    // TODO @jason：merchantOrderId 字段，需要在 PayWalletTransaction 存储下；然后，前端也返回下这个字段，界面也展示下商户名

}
