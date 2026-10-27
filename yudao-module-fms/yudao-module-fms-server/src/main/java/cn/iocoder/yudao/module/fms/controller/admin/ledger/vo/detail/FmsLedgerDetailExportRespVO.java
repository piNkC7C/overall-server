package cn.iocoder.yudao.module.fms.controller.admin.ledger.vo.detail;

import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * FMS 明细账导出 Response VO
 *
 * @author 芋道源码
 */
@Data
@ExcelIgnoreUnannotated
public class FmsLedgerDetailExportRespVO {

    @ExcelProperty("Account")
    private String subject;

    @ExcelProperty("Date")
    private LocalDate accountDate;

    @ExcelProperty("Voucher Word No")
    private String voucherNumber;

    @ExcelProperty("Memo")
    private String digest;

    @ExcelProperty("Debit")
    private BigDecimal debitAmount;

    @ExcelProperty("Credit")
    private BigDecimal creditAmount;

    @ExcelProperty("Direction")
    private String balanceDirection;

    @ExcelProperty("Balance")
    private BigDecimal balance;

}
