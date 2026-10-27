package cn.iocoder.yudao.module.pay.controller.admin.order.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.framework.excel.core.convert.MoneyConvert;
import cn.iocoder.yudao.module.pay.enums.DictTypeConstants;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

/**
 * 支付订单 Excel VO
 *
 * @author aquan
 */
@Data
public class PayOrderExcelVO {

    @ExcelProperty("Code")
    private Long id;

    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @ExcelProperty(value = "Payment Amount", converter = MoneyConvert.class)
    private Integer price;

    @ExcelProperty(value = "Refund Amount", converter = MoneyConvert.class)
    private Integer refundPrice;

    @ExcelProperty(value = "Fee Amount", converter = MoneyConvert.class)
    private Integer channelFeePrice;

    @ExcelProperty("Merchant Order No")
    private String merchantOrderId;

    @ExcelProperty(value = "Payment No")
    private String no;

    @ExcelProperty("Channel Order No")
    private String channelOrderNo;

    @ExcelProperty(value = "Payment Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.ORDER_STATUS)
    private Integer status;

    @ExcelProperty(value = "Channel ID / Name", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.CHANNEL_CODE)
    private String channelCode;

    @ExcelProperty("Order Paid Time")
    private LocalDateTime successTime;

    @ExcelProperty("Order Expire Time")
    private LocalDateTime expireTime;

    @ExcelProperty(value = "App Name")
    private String appName;

    @ExcelProperty("Product Title")
    private String subject;

    @ExcelProperty("Product Description")
    private String body;

}
