package cn.iocoder.yudao.module.fms.controller.admin.ledger.vo.general;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;

@Schema(description = "Admin - FMS general ledger response.")
@Data
@ExcelIgnoreUnannotated
public class FmsLedgerGeneralRespVO {

    @Schema(description = "Line type.", example = "2")
    private Integer rowType;

    @Schema(description = "Account code.", example = "1024")
    private Long subjectId;

    @Schema(description = "Account code.", example = "1001")
    @ExcelProperty("Account Code")
    private String subjectCode;

    @Schema(description = "Account name.", example = "Cash on hand")
    @ExcelProperty("Account Name")
    private String subjectName;

    @Schema(description = "Accounting Period", example = "2026-08")
    @ExcelProperty("Period")
    private String period;

    @Schema(description = "Summary", example = "current periodTotal")
    @ExcelProperty("Memo")
    private String digest;

    @Schema(description = "Debit amount.")
    @ExcelProperty("Debit")
    private BigDecimal debitAmount;

    @Schema(description = "Credit amount.")
    @ExcelProperty("Credit")
    private BigDecimal creditAmount;

    @Schema(description = "Balance Direction.", example = "Debit")
    @ExcelProperty("Direction")
    private String balanceDirection;

    @Schema(description = "Balance.")
    @ExcelProperty("Balance")
    private BigDecimal balance;

}
