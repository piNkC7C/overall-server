package cn.iocoder.yudao.module.fms.controller.admin.ledger.vo.auxiliarybalance;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;

@Schema(description = "管理后台 - FMS 核算项目余额 Response VO")
@Data
@ExcelIgnoreUnannotated
public class FmsLedgerAuxiliaryBalanceRespVO {

    @Schema(description = "辅助核算项目编号", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long auxiliaryItemId;

    @Schema(description = "编码", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Code")
    private String code;

    @Schema(description = "项目名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Project Name")
    private String name;

    @Schema(description = "期初借方余额", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Opening Debit")
    private BigDecimal openingDebitAmount;

    @Schema(description = "期初贷方余额", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Opening Credit")
    private BigDecimal openingCreditAmount;

    @Schema(description = "本期借方发生额", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Period Debit")
    private BigDecimal periodDebitAmount;

    @Schema(description = "本期贷方发生额", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Period Credit")
    private BigDecimal periodCreditAmount;

    @Schema(description = "本年累计借方发生额", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("YTD Debit")
    private BigDecimal yearDebitAmount;

    @Schema(description = "本年累计贷方发生额", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("YTD Credit")
    private BigDecimal yearCreditAmount;

    @Schema(description = "期末借方余额", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Ending Debit")
    private BigDecimal endingDebitAmount;

    @Schema(description = "期末贷方余额", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Ending Credit")
    private BigDecimal endingCreditAmount;

}
