package cn.iocoder.yudao.module.fms.controller.admin.ledger.vo.quantitydetail;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "Admin - FMS QuantityAmountLedger response.")
@Data
@ExcelIgnoreUnannotated
public class FmsLedgerQuantityDetailRespVO {

    public static final Integer ROW_TYPE_OPENING = 1;
    public static final Integer ROW_TYPE_VOUCHER = 2;
    public static final Integer ROW_TYPE_PERIOD_TOTAL = 3;
    public static final Integer ROW_TYPE_YEAR_TOTAL = 4;

    @Schema(description = "Line type.", example = "2")
    private Integer rowType;

    @Schema(description = "Entry code.", example = "1024")
    private Long entryId;

    @Schema(description = "Account code.", example = "1024")
    private Long subjectId;

    @Schema(description = "Account code.", example = "1405")
    private String subjectCode;

    @Schema(description = "Account name.", example = "Inventoryproduct.")
    private String subjectName;

    @Schema(description = "Accounting Period", example = "2026-08")
    private String period;

    @Schema(description = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ExcelProperty("Date")
    private LocalDate accountDate;

    @Schema(description = "Journal entry code.", example = "1024")
    private Long voucherId;

    @Schema(description = "Journal entry character no.", example = "JV-1")
    @ExcelProperty("Voucher Word No")
    private String voucherNumber;

    @Schema(description = "Summary", example = "Purchase product.")
    @ExcelProperty("Memo")
    private String digest;

    @Schema(description = "Debit amount.")
    @ExcelProperty("Debit Amount")
    private BigDecimal debitAmount;

    @Schema(description = "Credit amount.")
    @ExcelProperty("Credit Amount")
    private BigDecimal creditAmount;

    @Schema(description = "Balance Direction.", example = "Debit")
    @ExcelProperty("Direction")
    private String balanceDirection;

    @Schema(description = "Balance.")
    @ExcelProperty("On-hand Amount")
    private BigDecimal balance;

    @Schema(description = "Debit quantity.")
    @ExcelProperty("Debit Quantity")
    private BigDecimal debitQuantity;

    @Schema(description = "Credit quantity.")
    @ExcelProperty("Credit Quantity")
    private BigDecimal creditQuantity;

    @Schema(description = "On-hand quantity.")
    @ExcelProperty("On-hand Quantity")
    private BigDecimal balanceQuantity;

    @Schema(description = "Unit Price")
    @ExcelProperty("Entry Unit Price")
    private BigDecimal unitPrice;

    @ExcelProperty("Opening Unit Price")
    private BigDecimal openingUnitPrice;

    @ExcelProperty("Period Unit Price")
    private BigDecimal periodUnitPrice;

    @ExcelProperty("Cumulative Unit Price")
    private BigDecimal yearUnitPrice;

    @ExcelProperty("Ending Unit Price")
    private BigDecimal endingUnitPrice;

    @Schema(description = "Unit of measure.", example = "Pcs.")
    @ExcelProperty("Unit")
    private String quantityUnit;

}
