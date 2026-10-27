package cn.iocoder.yudao.module.pay.controller.app.wallet.vo.transaction;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "App - wallet transactionpage response.")
@Data
public class AppPayWalletTransactionRespVO {

    @Schema(description = "Business category.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer bizType;

    @Schema(description = "Trade amount, order characters Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Long price;

    @Schema(description = "Transaction title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Potatopotato.")
    private String title;

    @Schema(description = "Trade time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
