package cn.iocoder.yudao.framework.common.biz.infra.logger.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "RPC 服务 - API 错误日志创建 Request DTO")
@Data
public class ApiErrorLogCreateReqDTO {

    @Schema(description = "链路追踪编号", example = "89aca178-a370-411c-ae02-3f0d672be4ab")
    private String traceId;

    @Schema(description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long userId;
    @Schema(description = "用户类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer userType;
    @Schema(description = "应用名", requiredMode = Schema.RequiredMode.REQUIRED, example = "system-server")
    @NotNull(message = "App name is required.")
    private String applicationName;

    @Schema(description = "请求方法名", requiredMode = Schema.RequiredMode.REQUIRED, example = "GET")
    @NotNull(message = "Http Request Method is required.")
    private String requestMethod;
    @Schema(description = "请求地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "/xxx/yyy")
    @NotNull(message = "Access Address is required.")
    private String requestUrl;
    @Schema(description = "请求参数", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Request params is required.")
    private String requestParams;
    @Schema(description = "用户 IP", requiredMode = Schema.RequiredMode.REQUIRED, example = "127.0.0.1")
    @NotNull(message = "Ip is required.")
    private String userIp;
    @Schema(description = "浏览器 UserAgent", requiredMode = Schema.RequiredMode.REQUIRED, example = "Mozilla/5.0")
    @NotNull(message = "User-Agent is required.")
    private String userAgent;

    @Schema(description = "异常时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Exception time cannot be empty.")
    private LocalDateTime exceptionTime;
    @Schema(description = "异常名", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Exception name is required.")
    private String exceptionName;
    @Schema(description = "异常发生的类全名", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Exception class name is required.")
    private String exceptionClassName;
    @Schema(description = "异常发生的类文件", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Exception class file is required.")
    private String exceptionFileName;
    @Schema(description = "异常发生的方法名", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Exception method is required.")
    private String exceptionMethodName;
    @Schema(description = "异常发生的方法所在行", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Exception line number is required.")
    private Integer exceptionLineNumber;
    @Schema(description = "异常的栈轨迹异常的栈轨迹", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Exception stack trace is required.")
    private String exceptionStackTrace;
    @Schema(description = "异常导致的根消息", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Root cause message is required.")
    private String exceptionRootCauseMessage;
    @Schema(description = "异常导致的消息", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Exception message is required.")
    private String exceptionMessage;

}
