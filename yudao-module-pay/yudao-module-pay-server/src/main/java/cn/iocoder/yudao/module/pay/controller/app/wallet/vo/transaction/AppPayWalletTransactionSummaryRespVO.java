package cn.iocoder.yudao.module.pay.controller.app.wallet.vo.transaction;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "App - wallet transactionStats request.")
@Data
public class AppPayWalletTransactionSummaryRespVO {

    @Schema(description = "Total spend, in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1000")
    private Integer totalExpense;

    @Schema(description = "Cumulative income in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2000")
    private Integer totalIncome;

}
