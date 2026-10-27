package cn.iocoder.yudao.framework.common.biz.infra.logger.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "API error log create request VO.")
@Data
public class ApiErrorLogCreateReqDTO {

    @Schema(description = "Trace ID.", example = "89aca178-a370-411c-ae02-3f0d672be4ab")
    private String traceId;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long userId;
    @Schema(description = "User type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer userType;
    @Schema(description = "App name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "system-server")
    @NotNull(message = "App name is required.")
    private String applicationName;

    @Schema(description = "Request method.", requiredMode = Schema.RequiredMode.REQUIRED, example = "GET")
    @NotNull(message = "Http Request Method is required.")
    private String requestMethod;
    @Schema(description = "Request URL.", requiredMode = Schema.RequiredMode.REQUIRED, example = "/xxx/yyy")
    @NotNull(message = "Access Address is required.")
    private String requestUrl;
    @Schema(description = "Request params.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Request params is required.")
    private String requestParams;
    @Schema(description = "User IP.", requiredMode = Schema.RequiredMode.REQUIRED, example = "127.0.0.1")
    @NotNull(message = "Ip is required.")
    private String userIp;
    @Schema(description = "Browser user agent.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Mozilla/5.0")
    @NotNull(message = "User-Agent is required.")
    private String userAgent;

    @Schema(description = "Exception time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Exception time cannot be empty.")
    private LocalDateTime exceptionTime;
    @Schema(description = "Exception name.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Exception name is required.")
    private String exceptionName;
    @Schema(description = "Exception class name", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Exception class name is required.")
    private String exceptionClassName;
    @Schema(description = "Exception class file", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Exception class file is required.")
    private String exceptionFileName;
    @Schema(description = "Exception method", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Exception method is required.")
    private String exceptionMethodName;
    @Schema(description = "Exception line number", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Exception line number is required.")
    private Integer exceptionLineNumber;
    @Schema(description = "Exception stack traceException stack trace.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Exception stack trace is required.")
    private String exceptionStackTrace;
    @Schema(description = "Root cause message.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Root cause message is required.")
    private String exceptionRootCauseMessage;
    @Schema(description = "Exception message.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Exception message is required.")
    private String exceptionMessage;

}
