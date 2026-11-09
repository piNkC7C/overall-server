package cn.iocoder.yudao.module.infra.controller.admin.logger.vo.apierrorlog;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.infra.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - API 错误日志 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ApiErrorLogRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "链路追踪编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "66600cb6-7852-11eb-9439-0242ac130002")
    @ExcelProperty("Trace ID")
    private String traceId;

    @Schema(description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "666")
    @ExcelProperty("User ID")
    private Long userId;

    @Schema(description = "用户类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "User Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.USER_TYPE)
    private Integer userType;

    @Schema(description = "应用名", requiredMode = Schema.RequiredMode.REQUIRED, example = "dashboard")
    @ExcelProperty("App Name")
    private String applicationName;

    @Schema(description = "请求方法名", requiredMode = Schema.RequiredMode.REQUIRED, example = "GET")
    @ExcelProperty("Request Method")
    private String requestMethod;

    @Schema(description = "请求地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "/xx/yy")
    @ExcelProperty("Request URL")
    private String requestUrl;

    @Schema(description = "请求参数", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Request Params")
    private String requestParams;

    @Schema(description = "用户 IP", requiredMode = Schema.RequiredMode.REQUIRED, example = "127.0.0.1")
    @ExcelProperty("User IP")
    private String userIp;

    @Schema(description = "浏览器 UA", requiredMode = Schema.RequiredMode.REQUIRED, example = "Mozilla/5.0")
    @ExcelProperty("User Agent")
    private String userAgent;

    @Schema(description = "异常发生时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Exception Time")
    private LocalDateTime exceptionTime;

    @Schema(description = "异常名", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Exception Name")
    private String exceptionName;

    @Schema(description = "异常导致的消息", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Exception Message")
    private String exceptionMessage;

    @Schema(description = "异常导致的根消息", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Root Cause Message")
    private String exceptionRootCauseMessage;

    @Schema(description = "异常的栈轨迹", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Stack Trace")
    private String exceptionStackTrace;

    @Schema(description = "异常发生的类全名", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Exception Class")
    private String exceptionClassName;

    @Schema(description = "异常发生的类文件", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Exception File")
    private String exceptionFileName;

    @Schema(description = "异常发生的方法名", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Exception Method")
    private String exceptionMethodName;

    @Schema(description = "异常发生的方法所在行", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Exception Line")
    private Integer exceptionLineNumber;

    @Schema(description = "处理状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty(value = "Handling Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.API_ERROR_LOG_PROCESS_STATUS)
    private Integer processStatus;

    @Schema(description = "处理时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Handled Time")
    private LocalDateTime processTime;

    @Schema(description = "处理用户编号", example = "233")
    @ExcelProperty("Handler User ID")
    private Integer processUserId;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
