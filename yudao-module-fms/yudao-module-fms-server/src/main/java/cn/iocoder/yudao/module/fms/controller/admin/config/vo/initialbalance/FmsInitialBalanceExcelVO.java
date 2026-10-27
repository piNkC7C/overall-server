package cn.iocoder.yudao.module.fms.controller.admin.config.vo.initialbalance;

import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;

/**
 * FMS 初始余额 Excel VO
 *
 * @author 芋道源码
 */
@Data
@ExcelIgnoreUnannotated
public class FmsInitialBalanceExcelVO {

    /**
     * Excel 行号
     */
    private Integer rowNumber;
    /**
     * 科目编码
     */
    @ExcelProperty("Account Code")
    private String subjectCode;
    /**
     * 科目名称
     */
    @ExcelProperty("Account Name")
    private String subjectName;
    /**
     * 余额方向名称
     */
    @ExcelProperty("Direction")
    private String directionName;
    /**
     * 辅助核算项目，格式为“类别:名称/类别:名称”
     */
    @ExcelProperty("Auxiliary Item")
    private String auxiliaryItems;
    /**
     * 科目类型
     */
    private Integer subjectType;
    /**
     * 是否启用数量核算
     */
    private Boolean quantityAccounting;
    /**
     * 是否启用辅助核算
     */
    private Boolean auxiliaryAccounting;
    /**
     * 期初数量
     */
    @ExcelProperty("Opening Quantity")
    private BigDecimal openingQuantity;
    /**
     * 期初金额
     */
    @ExcelProperty("Opening Amount")
    private BigDecimal openingAmount;
    /**
     * 本年累计借方数量
     */
    @ExcelProperty("YTD Debit Quantity")
    private BigDecimal yearDebitQuantity;
    /**
     * 本年累计借方金额
     */
    @ExcelProperty("YTD Debit Amount")
    private BigDecimal yearDebitAmount;
    /**
     * 本年累计贷方数量
     */
    @ExcelProperty("YTD Credit Quantity")
    private BigDecimal yearCreditQuantity;
    /**
     * 本年累计贷方金额
     */
    @ExcelProperty("YTD Credit Amount")
    private BigDecimal yearCreditAmount;
    /**
     * 年初数量
     */
    @ExcelProperty("Opening-year Quantity")
    private BigDecimal yearOpeningQuantity;
    /**
     * 年初金额
     */
    @ExcelProperty("Opening-year Amount")
    private BigDecimal yearOpeningAmount;
    /**
     * 实际损益发生数量
     */
    @ExcelProperty("Actual P&L Quantity")
    private BigDecimal profitLossQuantity;
    /**
     * 实际损益发生金额
     */
    @ExcelProperty("Actual P&L Amount")
    private BigDecimal profitLossAmount;

}
