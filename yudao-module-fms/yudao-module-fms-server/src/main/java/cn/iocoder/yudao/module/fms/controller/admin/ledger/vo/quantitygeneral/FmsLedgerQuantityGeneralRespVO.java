package cn.iocoder.yudao.module.fms.controller.admin.ledger.vo.quantitygeneral;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnore;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Schema(description = "管理后台 - FMS 数量金额总账 Response VO")
@Data
@ExcelIgnoreUnannotated
public class FmsLedgerQuantityGeneralRespVO {

    @Schema(description = "科目编号", example = "1024")
    private Long subjectId;

    @Schema(description = "科目编码", example = "1405")
    @ExcelProperty({"Account", "Code"})
    private String subjectCode;

    @Schema(description = "科目名称", example = "Inventoryproduct.")
    @ExcelProperty({"Account", "Name"})
    private String subjectName;

    @Schema(description = "科目级次", example = "1")
    private Integer level;

    @Schema(description = "是否启用数量核算")
    private Boolean quantityAccounting;

    @Schema(description = "计量单位", example = "Pcs.")
    @ExcelProperty({"Basic Info", "Unit"})
    private String quantityUnit;

    @Schema(description = "期初余额方向", example = "Debit")
    @ExcelProperty({"Opening Balance", "Direction"})
    private String openingBalanceDirection;

    @Schema(description = "期初数量")
    @ExcelProperty({"Opening Balance", "Quantity"})
    private BigDecimal openingQuantity;

    @Schema(description = "期初单价")
    @ExcelProperty({"Opening Balance", "Unit Price"})
    private BigDecimal openingUnitPrice;

    @Schema(description = "期初借方余额")
    @ExcelIgnore
    private BigDecimal openingDebitAmount;

    @Schema(description = "期初贷方余额")
    @ExcelIgnore
    private BigDecimal openingCreditAmount;

    @ExcelProperty({"Opening Balance", "Amount"})
    private BigDecimal openingAmount;

    @Schema(description = "本期借方数量")
    @ExcelProperty({"Period Debit", "Quantity"})
    private BigDecimal periodDebitQuantity;

    @Schema(description = "本期借方发生额")
    @ExcelProperty({"Period Debit", "Amount"})
    private BigDecimal periodDebitAmount;

    @Schema(description = "本期贷方数量")
    @ExcelProperty({"Period Credit", "Quantity"})
    private BigDecimal periodCreditQuantity;

    @Schema(description = "本期贷方发生额")
    @ExcelProperty({"Period Credit", "Amount"})
    private BigDecimal periodCreditAmount;

    @Schema(description = "本年累计借方数量")
    @ExcelProperty({"YTD Debit", "Quantity"})
    private BigDecimal yearDebitQuantity;

    @Schema(description = "本年累计借方发生额")
    @ExcelProperty({"YTD Debit", "Amount"})
    private BigDecimal yearDebitAmount;

    @Schema(description = "本年累计贷方数量")
    @ExcelProperty({"YTD Credit", "Quantity"})
    private BigDecimal yearCreditQuantity;

    @Schema(description = "本年累计贷方发生额")
    @ExcelProperty({"YTD Credit", "Amount"})
    private BigDecimal yearCreditAmount;

    @Schema(description = "期末余额方向", example = "Debit")
    @ExcelProperty({"Ending Balance", "Direction"})
    private String endingBalanceDirection;

    @Schema(description = "期末数量")
    @ExcelProperty({"Ending Balance", "Quantity"})
    private BigDecimal endingQuantity;

    @Schema(description = "期末单价")
    @ExcelProperty({"Ending Balance", "Unit Price"})
    private BigDecimal endingUnitPrice;

    @Schema(description = "期末借方余额")
    @ExcelIgnore
    private BigDecimal endingDebitAmount;

    @Schema(description = "期末贷方余额")
    @ExcelIgnore
    private BigDecimal endingCreditAmount;

    @ExcelProperty({"Ending Balance", "Amount"})
    private BigDecimal endingAmount;

    @Schema(description = "下级科目")
    private List<FmsLedgerQuantityGeneralRespVO> children = new ArrayList<>();

}
