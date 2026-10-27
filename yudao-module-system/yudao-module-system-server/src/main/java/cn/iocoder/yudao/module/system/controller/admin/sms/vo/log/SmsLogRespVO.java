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

@Schema(description = "SMS log response VO.")
@Data
@ExcelIgnoreUnannotated
public class SmsLogRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "SMS channel code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @ExcelProperty("SMS Channel ID")
    private Long channelId;

    @Schema(description = "SMS channel code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ALIYUN")
    @ExcelProperty("SMS Channel Code")
    private String channelCode;

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    @ExcelProperty("Template ID")
    private Long templateId;

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "test-01")
    @ExcelProperty("Template Code")
    private String templateCode;

    @Schema(description = "SMS type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "SMS Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.SMS_TEMPLATE_TYPE)
    private Integer templateType;

    @Schema(description = "SMS content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Hi, your verification code is 1024")
    @ExcelProperty("SMS Content")
    private String templateContent;

    @Schema(description = "SMS parameter.", requiredMode = Schema.RequiredMode.REQUIRED, example = "name,code")
    @ExcelProperty(value = "SMS Params", converter = JsonConvert.class)
    private Map<String, Object> templateParams;

    @Schema(description = "SMS API template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "SMS_207945135")
    @ExcelProperty("SMS API Template ID")
    private String apiTemplateId;

    @Schema(description = "Phone number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15601691300")
    @ExcelProperty("Phone Number")
    private String mobile;

    @Schema(description = "User ID.", example = "10")
    @ExcelProperty("User ID")
    private Long userId;

    @Schema(description = "User type.", example = "1")
    @ExcelProperty(value = "User Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.USER_TYPE)
    private Integer userType;

    @Schema(description = "Send status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Send Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.SMS_SEND_STATUS)
    private Integer sendStatus;

    @Schema(description = "Send time.")
    @ExcelProperty("Sent Time")
    private LocalDateTime sendTime;

    @Schema(description = "SMS API send result code.", example = "SUCCESS")
    @ExcelProperty("SMS API Result Code")
    private String apiSendCode;

    @Schema(description = "SMS API send failed Tip.", example = "Succeeded.")
    @ExcelProperty("SMS API Failure Message")
    private String apiSendMsg;

    @Schema(description = "SMS API request ID", example = "3837C6D3-B96F-428C-BBB2-86135D4B5B99")
    @ExcelProperty("SMS API Request ID")
    private String apiRequestId;

    @Schema(description = "SMS API serial", example = "62923244790")
    @ExcelProperty("SMS API Sequence")
    private String apiSerialNo;

    @Schema(description = "Receive status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty(value = "Receive Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.SMS_RECEIVE_STATUS)
    private Integer receiveStatus;

    @Schema(description = "Receive time.")
    @ExcelProperty("Received Time")
    private LocalDateTime receiveTime;

    @Schema(description = "API Receive result code.", example = "DELIVRD")
    @ExcelProperty("API Result Code")
    private String apiReceiveCode;

    @Schema(description = "API Receive result Notes.", example = "UserReceive succeeded.")
    @ExcelProperty("API Result Message")
    private String apiReceiveMsg;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
