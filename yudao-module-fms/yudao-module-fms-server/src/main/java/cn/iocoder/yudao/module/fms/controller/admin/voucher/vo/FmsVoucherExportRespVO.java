package cn.iocoder.yudao.module.fms.controller.admin.voucher.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;
import org.apache.fesod.sheet.annotation.format.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - FMS journal entryexport response.")
@Data
@ExcelIgnoreUnannotated
public class FmsVoucherExportRespVO {

    @Schema(description = "Journal entryDate.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Date")
    @DateTimeFormat("yyyy-MM-dd")
    private LocalDateTime voucherTime;

    @Schema(description = "Journal entry character.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Voucher Word")
    private String voucherWordName;

    @Schema(description = "Journal entry no.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Voucher No")
    private Integer voucherNumber;

    @Schema(description = "Summary", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Memo")
    private String digest;

    @Schema(description = "Account code.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Account Code")
    private String subjectCode;

    @Schema(description = "Account name.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Account Name")
    private String subjectName;

    @Schema(description = "Debit amount.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Debit Amount")
    private BigDecimal debitAmount;

    @Schema(description = "Credit amount.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Credit Amount")
    private BigDecimal creditAmount;

    @Schema(description = "Attachment count.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Attachment Count")
    private Integer attachmentCount;

    @Schema(description = "Prepared by.")
    @ExcelProperty("Prepared By")
    private String creatorUserName;

    @Schema(description = "Approval person.")
    @ExcelProperty("Approver")
    private String reviewerUserName;

}
