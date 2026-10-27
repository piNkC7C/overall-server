package cn.iocoder.yudao.module.infra.controller.admin.logger.vo.apierrorlog;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.infra.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "API error log response VO.")
@Data
@ExcelIgnoreUnannotated
public class ApiErrorLogRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Trace ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "66600cb6-7852-11eb-9439-0242ac130002")
    @ExcelProperty("Trace ID")
    private String traceId;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "666")
    @ExcelProperty("User ID")
    private Long userId;

    @Schema(description = "User type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "User Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.USER_TYPE)
    private Integer userType;

    @Schema(description = "App name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "dashboard")
    @ExcelProperty("App Name")
    private String applicationName;

    @Schema(description = "Request method.", requiredMode = Schema.RequiredMode.REQUIRED, example = "GET")
    @ExcelProperty("Request Method")
    private String requestMethod;

    @Schema(description = "Request URL.", requiredMode = Schema.RequiredMode.REQUIRED, example = "/xx/yy")
    @ExcelProperty("Request URL")
    private String requestUrl;

    @Schema(description = "Request params.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Request Params")
    private String requestParams;

    @Schema(description = "User IP.", requiredMode = Schema.RequiredMode.REQUIRED, example = "127.0.0.1")
    @ExcelProperty("User IP")
    private String userIp;

    @Schema(description = "User agent.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Mozilla/5.0")
    @ExcelProperty("User Agent")
    private String userAgent;

    @Schema(description = "Exception time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Exception Time")
    private LocalDateTime exceptionTime;

    @Schema(description = "Exception name.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Exception Name")
    private String exceptionName;

    @Schema(description = "Exception message.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Exception Message")
    private String exceptionMessage;

    @Schema(description = "Root cause message.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Root Cause Message")
    private String exceptionRootCauseMessage;

    @Schema(description = "Exception stack trace", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Stack Trace")
    private String exceptionStackTrace;

    @Schema(description = "Exception class name", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Exception Class")
    private String exceptionClassName;

    @Schema(description = "Exception class file", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Exception File")
    private String exceptionFileName;

    @Schema(description = "Exception method", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Exception Method")
    private String exceptionMethodName;

    @Schema(description = "Exception line number", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Exception Line")
    private Integer exceptionLineNumber;

    @Schema(description = "Process status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty(value = "Handling Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.API_ERROR_LOG_PROCESS_STATUS)
    private Integer processStatus;

    @Schema(description = "Process time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Handled Time")
    private LocalDateTime processTime;

    @Schema(description = "Process user ID.", example = "233")
    @ExcelProperty("Handler User ID")
    private Integer processUserId;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
