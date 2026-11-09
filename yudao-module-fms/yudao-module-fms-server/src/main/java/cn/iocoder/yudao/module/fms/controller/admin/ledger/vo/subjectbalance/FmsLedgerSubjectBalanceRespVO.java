package cn.iocoder.yudao.module.fms.controller.admin.ledger.vo.subjectbalance;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Schema(description = "管理后台 - FMS 科目余额 Response VO")
@Data
@Accessors(chain = true)
@ExcelIgnoreUnannotated
public class FmsLedgerSubjectBalanceRespVO {

    public static final int NODE_TYPE_SUBJECT = 1;
    public static final int NODE_TYPE_AUXILIARY_COMBINATION = 2;

    @Schema(description = "节点唯一键", example = "S:1024")
    private String nodeKey;

    @Schema(description = "节点类型", example = "1")
    private Integer nodeType;

    @Schema(description = "科目编号", example = "1024")
    private Long subjectId;

    @Schema(description = "辅助核算组合编号", example = "2048")
    private Long assistCombinationId;

    @Schema(description = "科目编码", example = "1001")
    @ExcelProperty("Account Code")
    private String subjectCode;

    @Schema(description = "科目名称", example = "Cash on hand")
    @ExcelProperty("Account Name")
    private String subjectName;

    @Schema(description = "科目级次", example = "1")
    private Integer level;

    @Schema(description = "是否启用数量核算")
    private Boolean quantityAccounting;

    @Schema(description = "计量单位", example = "Pcs.")
    private String quantityUnit;

    @Schema(description = "期初借方余额")
    @ExcelProperty("Opening Debit")
    private BigDecimal openingDebitAmount;

    @Schema(description = "期初贷方余额")
    @ExcelProperty("Opening Credit")
    private BigDecimal openingCreditAmount;

    @Schema(description = "期初余额方向", example = "Debit")
    private String openingBalanceDirection;

    @Schema(description = "期初数量")
    private BigDecimal openingQuantity;

    @Schema(description = "期初单价")
    private BigDecimal openingUnitPrice;

    @Schema(description = "本期借方发生额")
    @ExcelProperty("Period Debit")
    private BigDecimal periodDebitAmount;

    @Schema(description = "本期贷方发生额")
    @ExcelProperty("Period Credit")
    private BigDecimal periodCreditAmount;

    @Schema(description = "本期借方数量")
    private BigDecimal periodDebitQuantity;

    @Schema(description = "本期贷方数量")
    private BigDecimal periodCreditQuantity;

    @Schema(description = "本年累计借方发生额")
    @ExcelProperty("YTD Debit")
    private BigDecimal yearDebitAmount;

    @Schema(description = "本年累计贷方发生额")
    @ExcelProperty("YTD Credit")
    private BigDecimal yearCreditAmount;

    @Schema(description = "本年累计借方数量")
    private BigDecimal yearDebitQuantity;

    @Schema(description = "本年累计贷方数量")
    private BigDecimal yearCreditQuantity;

    @Schema(description = "期末借方余额")
    @ExcelProperty("Ending Debit")
    private BigDecimal endingDebitAmount;

    @Schema(description = "期末贷方余额")
    @ExcelProperty("Ending Credit")
    private BigDecimal endingCreditAmount;

    @Schema(description = "期末余额方向", example = "Debit")
    private String endingBalanceDirection;

    @Schema(description = "期末数量")
    private BigDecimal endingQuantity;

    @Schema(description = "期末单价")
    private BigDecimal endingUnitPrice;

    @Schema(description = "下级科目")
    private List<FmsLedgerSubjectBalanceRespVO> children = new ArrayList<>();

}
