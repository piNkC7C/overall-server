package cn.iocoder.yudao.module.pay.controller.admin.transfer.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.framework.excel.core.convert.MoneyConvert;
import cn.iocoder.yudao.module.pay.enums.DictTypeConstants;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;
import java.time.LocalDateTime;
import java.util.Map;

@Schema(description = "Admin - transfer order response.")
@Data
@ExcelIgnoreUnannotated
public class PayTransferRespVO {

    @ExcelProperty("Transfer ID")
    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2931")
    private Long id;

    @ExcelProperty("Transfer No")
    @Schema(description = "Transfer order no.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String no;

    @Schema(description = "App code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "12831")
    private Long appId;

    @ExcelProperty("App Name")
    @Schema(description = "App name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String appName;

    @Schema(description = "Transfer channel code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "24833")
    private Long channelId;

    @ExcelProperty(value = "Transfer Channel", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.CHANNEL_CODE)
    @Schema(description = "Transfer channel code.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String channelCode;

    @ExcelProperty("Merchant Transfer No")
    @Schema(description = "Merchant transfer number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "17481")
    private String merchantTransferId;

    @ExcelProperty(value = "Transfer Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.TRANSFER_STATUS)
    @Schema(description = "Transfer status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer status;

    @ExcelProperty("Transfer Success Time")
    @Schema(description = "Transfer succeeded time.")
    private LocalDateTime successTime;

    @Schema(description = "Transfer amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "964")
    @ExcelProperty(value = "Transfer Amount", converter = MoneyConvert.class)
    private Integer price;

    @ExcelProperty("Transfer Title")
    @Schema(description = "Transfer title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Let's go!")
    private String subject;

    @Schema(description = "Receipt person Name.", example = "Alex.")
    @ExcelProperty("Payee Name")
    private String userName;

    @Schema(description = "Receipt person account.", requiredMode = Schema.RequiredMode.REQUIRED, example = "26589")
    @ExcelProperty("Payee Account")
    private String userAccount;

    @Schema(description = "Merchant async-notify URL.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    private String notifyUrl;

    @ExcelProperty("User IP")
    @Schema(description = "User IP.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String userIp;

    @Schema(description = "Channel extra params.")
    private Map<String, String> channelExtras;

    @Schema(description = "Channel transfer order no.")
    @ExcelProperty("Channel Transfer No")
    private String channelTransferNo;

    @Schema(description = "Channel error code.")
    private String channelErrorCode;

    @ExcelProperty("Channel Error Message")
    @Schema(description = "Call channel ErrorTip.")
    private String channelErrorMsg;

    @Schema(description = "Channel sync /Asyncnotification content.")
    private String channelNotifyData;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
