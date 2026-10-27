package cn.iocoder.yudao.module.pay.controller.admin.refund.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.framework.excel.core.convert.MoneyConvert;
import cn.iocoder.yudao.module.pay.enums.DictTypeConstants;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

/**
 * 退款订单 Excel VO
 *
 * @author aquan
 */
@Data
public class PayRefundExcelVO {

    @ExcelProperty("Payment Refund ID")
    private Long id;

    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @ExcelProperty(value = "Payment Amount", converter = MoneyConvert.class)
    private Integer payPrice;

    @ExcelProperty(value = "Refund Amount", converter = MoneyConvert.class)
    private Integer refundPrice;

    @ExcelProperty("Merchant Refund No")
    private String merchantRefundId;
    @ExcelProperty("Refund No")
    private String no;
    @ExcelProperty("Channel Refund No")
    private String channelRefundNo;

    @ExcelProperty("Merchant Payment No")
    private String merchantOrderId;
    @ExcelProperty("Channel Payment No")
    private String channelOrderNo;

    @ExcelProperty(value = "Refund Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.REFUND_STATUS)
    private Integer status;

    @ExcelProperty(value = "Refund Channel", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.CHANNEL_CODE)
    private String channelCode;

    @ExcelProperty("Success Time")
    private LocalDateTime successTime;

    @ExcelProperty(value = "Payment App")
    private String appName;

    @ExcelProperty("Refund Reason")
    private String reason;

}
