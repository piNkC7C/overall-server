package cn.iocoder.yudao.module.system.controller.admin.sms.vo.log;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.framework.excel.core.convert.JsonConvert;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;
import java.util.Map;

@Schema(description = "管理后台 - 短信日志 Response VO")
@Data
@ExcelIgnoreUnannotated
public class SmsLogRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "短信渠道编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @ExcelProperty("SMS Channel ID")
    private Long channelId;

    @Schema(description = "短信渠道编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "ALIYUN")
    @ExcelProperty("SMS Channel Code")
    private String channelCode;

    @Schema(description = "模板编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    @ExcelProperty("Template ID")
    private Long templateId;

    @Schema(description = "模板编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "test-01")
    @ExcelProperty("Template Code")
    private String templateCode;

    @Schema(description = "短信类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "SMS Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.SMS_TEMPLATE_TYPE)
    private Integer templateType;

    @Schema(description = "短信内容", requiredMode = Schema.RequiredMode.REQUIRED, example = "Hi, your verification code is 1024")
    @ExcelProperty("SMS Content")
    private String templateContent;

    @Schema(description = "短信参数", requiredMode = Schema.RequiredMode.REQUIRED, example = "name,code")
    @ExcelProperty(value = "SMS Params", converter = JsonConvert.class)
    private Map<String, Object> templateParams;

    @Schema(description = "短信 API 的模板编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "SMS_207945135")
    @ExcelProperty("SMS API Template ID")
    private String apiTemplateId;

    @Schema(description = "手机号", requiredMode = Schema.RequiredMode.REQUIRED, example = "15601691300")
    @ExcelProperty("Phone Number")
    private String mobile;

    @Schema(description = "用户编号", example = "10")
    @ExcelProperty("User ID")
    private Long userId;

    @Schema(description = "用户类型", example = "1")
    @ExcelProperty(value = "User Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.USER_TYPE)
    private Integer userType;

    @Schema(description = "发送状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Send Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.SMS_SEND_STATUS)
    private Integer sendStatus;

    @Schema(description = "发送时间")
    @ExcelProperty("Sent Time")
    private LocalDateTime sendTime;

    @Schema(description = "短信 API 发送结果的编码", example = "SUCCESS")
    @ExcelProperty("SMS API Result Code")
    private String apiSendCode;

    @Schema(description = "短信 API 发送失败的提示", example = "Succeeded.")
    @ExcelProperty("SMS API Failure Message")
    private String apiSendMsg;

    @Schema(description = "短信 API 发送返回的唯一请求 ID", example = "3837C6D3-B96F-428C-BBB2-86135D4B5B99")
    @ExcelProperty("SMS API Request ID")
    private String apiRequestId;

    @Schema(description = "短信 API 发送返回的序号", example = "62923244790")
    @ExcelProperty("SMS API Sequence")
    private String apiSerialNo;

    @Schema(description = "接收状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty(value = "Receive Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.SMS_RECEIVE_STATUS)
    private Integer receiveStatus;

    @Schema(description = "接收时间")
    @ExcelProperty("Received Time")
    private LocalDateTime receiveTime;

    @Schema(description = "API 接收结果的编码", example = "DELIVRD")
    @ExcelProperty("API Result Code")
    private String apiReceiveCode;

    @Schema(description = "API 接收结果的说明", example = "UserReceive succeeded.")
    @ExcelProperty("API Result Message")
    private String apiReceiveMsg;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
