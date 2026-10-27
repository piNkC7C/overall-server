package cn.iocoder.yudao.module.fms.controller.admin.ledger.vo.auxiliarybalance;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;

@Schema(description = "Admin - FMS accounting item balance response.")
@Data
@ExcelIgnoreUnannotated
public class FmsLedgerAuxiliaryBalanceRespVO {

    @Schema(description = "Auxiliary accounting item code.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long auxiliaryItemId;

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Code")
    private String code;

    @Schema(description = "Item name.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Project Name")
    private String name;

    @Schema(description = "OpeningDebitbalance.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Opening Debit")
    private BigDecimal openingDebitAmount;

    @Schema(description = "OpeningCreditbalance.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Opening Credit")
    private BigDecimal openingCreditAmount;

    @Schema(description = "Current periodDebitturnover.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Period Debit")
    private BigDecimal periodDebitAmount;

    @Schema(description = "Current periodCreditturnover.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Period Credit")
    private BigDecimal periodCreditAmount;

    @Schema(description = "YTD debit turnover.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("YTD Debit")
    private BigDecimal yearDebitAmount;

    @Schema(description = "YTD credit turnover.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("YTD Credit")
    private BigDecimal yearCreditAmount;

    @Schema(description = "EndingDebitbalance.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Ending Debit")
    private BigDecimal endingDebitAmount;

    @Schema(description = "EndingCreditbalance.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Ending Credit")
    private BigDecimal endingCreditAmount;

}
