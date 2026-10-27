package cn.iocoder.yudao.module.fms.controller.admin.closing.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "FMS closing overview response VO.")
@Data
public class FmsClosingOverviewRespVO {

    @Schema(description = "Accounting Period", example = "2026-08")
    private String month;

    @Schema(description = "Is not already closing.")
    private Boolean closed;

    @Schema(description = "Is not require journal entry approval.")
    private Boolean voucherReviewRequired;

    @Schema(description = "Unapprovedjournal entry quantity.", example = "2")
    private Long pendingVoucherCount;

    @Schema(description = "Journal entry quantity.", example = "12")
    private Long voucherCount;

    @Schema(description = "P&L account balance.", example = "9100.00")
    private BigDecimal profitLossBalance;

    @Schema(description = "Balance-sheet difference.", example = "0.00")
    private BigDecimal balanceSheetDifference;

    @Schema(description = "Close P&L journal entry code.", example = "1024")
    private Long profitLossVoucherId;

    @Schema(description = "Opening balance is in trial balance.")
    private Boolean initialBalanceBalanced;

    @Schema(description = "Voucher numbers are consecutive.")
    private Boolean voucherNumberContinuous;

    @Schema(description = "Need to need close P&L time is not already createjournal entry.")
    private Boolean profitLossVoucherGenerated;

    @Schema(description = "Income statement is reconciled.")
    private Boolean incomeStatementBalanced;

    @Schema(description = "Income-statement accounts not in formulas.", example = "0")
    private Integer incomeStatementUnmappedSubjectCount;

    @Schema(description = "Balance-sheet P&L is closed.")
    private Boolean balanceSheetProfitLossTransferred;

    @Schema(description = "Balance sheet is balanced.")
    private Boolean balanceSheetBalanced;

    @Schema(description = "Balance-sheet accounts not in formulas.", example = "0")
    private Integer balanceSheetUnmappedSubjectCount;

    @Schema(description = "Is not meet All closing condition.")
    private Boolean canClose;

}
