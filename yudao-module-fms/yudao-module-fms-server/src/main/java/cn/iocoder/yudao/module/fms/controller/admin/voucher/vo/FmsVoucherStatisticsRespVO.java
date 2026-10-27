package cn.iocoder.yudao.module.fms.controller.admin.voucher.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;

@Schema(description = "FMS journal entry summary response VO.")
@Data
@ExcelIgnoreUnannotated
public class FmsVoucherStatisticsRespVO {

    @Schema(description = "Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long subjectId;

    @Schema(description = "Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1001")
    @ExcelProperty("Account Code")
    private String subjectCode;

    @Schema(description = "Account name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cash on hand")
    @ExcelProperty("Account Name")
    private String subjectName;

    @Schema(description = "Account Level", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer level;

    @Schema(description = "Debit amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @ExcelProperty("Debit Amount")
    private BigDecimal debitAmount;

    @Schema(description = "Credit amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @ExcelProperty("Credit Amount")
    private BigDecimal creditAmount;

}
