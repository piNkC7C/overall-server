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

@Schema(description = "管理后台 - 转账单 Response VO")
@Data
@ExcelIgnoreUnannotated
public class PayTransferRespVO {

    @ExcelProperty("Transfer ID")
    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2931")
    private Long id;

    @ExcelProperty("Transfer No")
    @Schema(description = "转账单号", requiredMode = Schema.RequiredMode.REQUIRED)
    private String no;

    @Schema(description = "应用编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "12831")
    private Long appId;

    @ExcelProperty("App Name")
    @Schema(description = "应用名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String appName;

    @Schema(description = "转账渠道编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "24833")
    private Long channelId;

    @ExcelProperty(value = "Transfer Channel", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.CHANNEL_CODE)
    @Schema(description = "转账渠道编码", requiredMode = Schema.RequiredMode.REQUIRED)
    private String channelCode;

    @ExcelProperty("Merchant Transfer No")
    @Schema(description = "商户转账单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "17481")
    private String merchantTransferId;

    @ExcelProperty(value = "Transfer Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.TRANSFER_STATUS)
    @Schema(description = "转账状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer status;

    @ExcelProperty("Transfer Success Time")
    @Schema(description = "转账成功时间")
    private LocalDateTime successTime;

    @Schema(description = "转账金额", requiredMode = Schema.RequiredMode.REQUIRED, example = "964")
    @ExcelProperty(value = "Transfer Amount", converter = MoneyConvert.class)
    private Integer price;

    @ExcelProperty("Transfer Title")
    @Schema(description = "转账标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "Let's go!")
    private String subject;

    @Schema(description = "收款人姓名", example = "Alex.")
    @ExcelProperty("Payee Name")
    private String userName;

    @Schema(description = "收款人账号", requiredMode = Schema.RequiredMode.REQUIRED, example = "26589")
    @ExcelProperty("Payee Account")
    private String userAccount;

    @Schema(description = "异步通知商户地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    private String notifyUrl;

    @ExcelProperty("User IP")
    @Schema(description = "用户 IP", requiredMode = Schema.RequiredMode.REQUIRED)
    private String userIp;

    @Schema(description = "渠道的额外参数")
    private Map<String, String> channelExtras;

    @Schema(description = "渠道转账单号")
    @ExcelProperty("Channel Transfer No")
    private String channelTransferNo;

    @Schema(description = "调用渠道的错误码")
    private String channelErrorCode;

    @ExcelProperty("Channel Error Message")
    @Schema(description = "调用渠道的错误提示")
    private String channelErrorMsg;

    @Schema(description = "渠道的同步/异步通知的内容")
    private String channelNotifyData;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
