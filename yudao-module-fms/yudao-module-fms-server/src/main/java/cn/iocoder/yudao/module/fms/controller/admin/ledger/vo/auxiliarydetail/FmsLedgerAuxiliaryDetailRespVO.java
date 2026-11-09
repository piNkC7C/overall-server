package cn.iocoder.yudao.module.fms.controller.admin.ledger.vo.auxiliarydetail;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "管理后台 - FMS 核算项目明细账 Response VO")
@Data
@ExcelIgnoreUnannotated
public class FmsLedgerAuxiliaryDetailRespVO {

    public static final Integer ROW_TYPE_OPENING = 1;
    public static final Integer ROW_TYPE_VOUCHER = 2;
    public static final Integer ROW_TYPE_PERIOD_TOTAL = 3;
    public static final Integer ROW_TYPE_YEAR_TOTAL = 4;

    @Schema(description = "行类型", example = "2")
    private Integer rowType;

    @Schema(description = "分录编号", example = "1024")
    private Long entryId;

    @Schema(description = "科目编号", example = "1024")
    private Long subjectId;

    @Schema(description = "科目编码", example = "1001")
    private String subjectCode;

    @Schema(description = "科目名称", example = "Cash on hand")
    private String subjectName;

    @Schema(description = "会计期间", example = "2026-08")
    private String period;

    @Schema(description = "日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ExcelProperty("Date")
    private LocalDate accountDate;

    @Schema(description = "凭证编号", example = "1024")
    private Long voucherId;

    @Schema(description = "凭证字号", example = "JV-1")
    @ExcelProperty("Voucher Word No")
    private String voucherNumber;

    @Schema(description = "摘要", example = "Office-supply expense")
    @ExcelProperty("Memo")
    private String digest;

    @Schema(description = "借方金额")
    @ExcelProperty("Debit")
    private BigDecimal debitAmount;

    @Schema(description = "贷方金额")
    @ExcelProperty("Credit")
    private BigDecimal creditAmount;

    @Schema(description = "余额方向", example = "Debit")
    @ExcelProperty("Direction")
    private String balanceDirection;

    @Schema(description = "余额")
    @ExcelProperty("Balance")
    private BigDecimal balance;

}
