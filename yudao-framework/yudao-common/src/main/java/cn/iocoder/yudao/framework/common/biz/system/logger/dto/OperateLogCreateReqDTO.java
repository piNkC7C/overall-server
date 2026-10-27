package cn.iocoder.yudao.framework.common.biz.system.logger.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(name = "RPC service - SystemActivity Log Create Request DTO.")
@Data
public class OperateLogCreateReqDTO {

    @Schema(description = "Trace ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "89aca178-a370-411c-ae02-3f0d672be4ab")
    private String traceId;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "666")
    @NotNull(message = "User ID is required.")
    private Long userId;
    @Schema(description = "User type. See UserTypeEnum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2" )
    @NotNull(message = "User type is required.")
    private Integer userType;
    @Schema(description = "Module type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Order.")
    @NotEmpty(message = "Module type is required.")
    private String type;
    @Schema(description = "Action name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Createorder.")
    @NotEmpty(message = "Action name is required.")
    private String subType;
    @Schema(description = "Module business code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "188")
    @NotNull(message = "Module business code is required.")
    private Long bizId;
    @Schema(description = "Action content.", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "Update user 1: change gender from male to female, and name from John to Jane")
    @NotEmpty(message = "Action content is required.")
    private String action;
    @Schema(description = "Extra JSON", example = "{\"orderId\": \"1\"}")
    private String extra;

    @Schema(description = "Request method.", requiredMode = Schema.RequiredMode.REQUIRED, example = "GET")
    @NotEmpty(message = "Request method is required.")
    private String requestMethod;
    @Schema(description = "Request URL.", requiredMode = Schema.RequiredMode.REQUIRED, example = "/order/get")
    @NotEmpty(message = "Request URL is required.")
    private String requestUrl;
    @Schema(description = "User IP.", requiredMode = Schema.RequiredMode.REQUIRED, example = "127.0.0.1")
    @NotEmpty(message = "User IP is required.")
    private String userIp;
    @Schema(description = "Browser user agent.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Mozilla/5.0")
    @NotEmpty(message = "User agent is required.")
    private String userAgent;

}
