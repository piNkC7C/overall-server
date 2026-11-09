package cn.iocoder.yudao.module.fms.controller.admin.ledger.vo.general;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;

@Schema(description = "管理后台 - FMS 总账 Response VO")
@Data
@ExcelIgnoreUnannotated
public class FmsLedgerGeneralRespVO {

    @Schema(description = "行类型", example = "2")
    private Integer rowType;

    @Schema(description = "科目编号", example = "1024")
    private Long subjectId;

    @Schema(description = "科目编码", example = "1001")
    @ExcelProperty("Account Code")
    private String subjectCode;

    @Schema(description = "科目名称", example = "Cash on hand")
    @ExcelProperty("Account Name")
    private String subjectName;

    @Schema(description = "会计期间", example = "2026-08")
    @ExcelProperty("Period")
    private String period;

    @Schema(description = "摘要", example = "current periodTotal")
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
