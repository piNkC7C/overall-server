package cn.iocoder.yudao.module.fms.controller.admin.config.vo.initialbalance;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Trial-balance response VO.")
@Data
public class FmsTrialBalanceRespVO {

    @Schema(description = "OpeningDebit amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1000.00")
    private BigDecimal openingDebitAmount;

    @Schema(description = "OpeningCredit amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1000.00")
    private BigDecimal openingCreditAmount;

    @Schema(description = "Opening difference.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0.00")
    private BigDecimal openingDifferenceAmount;

    @Schema(description = "YTD debit amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    private BigDecimal yearDebitAmount;

    @Schema(description = "YTD credit amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    private BigDecimal yearCreditAmount;

    @Schema(description = "YTD difference.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0.00")
    private BigDecimal yearDifferenceAmount;

    @Schema(description = "Balanced.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean balanced;

}
