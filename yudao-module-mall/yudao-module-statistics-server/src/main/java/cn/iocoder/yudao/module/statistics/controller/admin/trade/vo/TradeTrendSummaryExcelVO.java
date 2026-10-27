package cn.iocoder.yudao.module.statistics.controller.admin.trade.vo;

import cn.iocoder.yudao.framework.excel.core.convert.MoneyConvert;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelProperty;
import org.apache.fesod.sheet.annotation.format.DateTimeFormat;

import java.time.LocalDate;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY;

/**
 * 交易状况统计 Excel VO
 *
 * @author owen
 */
@Data
public class TradeTrendSummaryExcelVO {

    @ExcelProperty(value = "Date")
    @DateTimeFormat(FORMAT_YEAR_MONTH_DAY)
    private LocalDate date;

    @ExcelProperty(value = "Revenue", converter = MoneyConvert.class)
    private Integer turnoverPrice;

    @ExcelProperty(value = "Product Paid Amount", converter = MoneyConvert.class)
    private Integer orderPayPrice;

    @ExcelProperty(value = "Top-up Amount", converter = MoneyConvert.class)
    private Integer rechargePrice;

    @ExcelProperty(value = "Expense Amount", converter = MoneyConvert.class)
    private Integer expensePrice;

    @ExcelProperty(value = "Balance Paid Amount", converter = MoneyConvert.class)
    private Integer walletPayPrice;

    @ExcelProperty(value = "Paid Commission", converter = MoneyConvert.class)
    private Integer brokerageSettlementPrice;

    @ExcelProperty(value = "Product Refund Amount", converter = MoneyConvert.class)
    private Integer afterSaleRefundPrice;
}
