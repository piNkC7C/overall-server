package cn.iocoder.yudao.framework.common.biz.system.logger.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(name = "RPC 服务 - 系统操作日志 Create Request DTO")
@Data
public class OperateLogCreateReqDTO {

    @Schema(description = "链路追踪编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "89aca178-a370-411c-ae02-3f0d672be4ab")
    private String traceId;

    @Schema(description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "666")
    @NotNull(message = "User ID is required.")
    private Long userId;
    @Schema(description = "用户类型，参见 UserTypeEnum 枚举", requiredMode = Schema.RequiredMode.REQUIRED, example = "2" )
    @NotNull(message = "User type is required.")
    private Integer userType;
    @Schema(description = "操作模块类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "Order.")
    @NotEmpty(message = "Module type is required.")
    private String type;
    @Schema(description = "操作名", requiredMode = Schema.RequiredMode.REQUIRED, example = "Createorder.")
    @NotEmpty(message = "Action name is required.")
    private String subType;
    @Schema(description = "操作模块业务编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "188")
    @NotNull(message = "Module business code is required.")
    private Long bizId;
    @Schema(description = "操作内容", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "Update user 1: change gender from male to female, and name from John to Jane")
    @NotEmpty(message = "Action content is required.")
    private String action;
    @Schema(description = "拓展字段", example = "{\"orderId\": \"1\"}")
    private String extra;

    @Schema(description = "请求方法名", requiredMode = Schema.RequiredMode.REQUIRED, example = "GET")
    @NotEmpty(message = "Request method is required.")
    private String requestMethod;
    @Schema(description = "请求地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "/order/get")
    @NotEmpty(message = "Request URL is required.")
    private String requestUrl;
    @Schema(description = "用户 IP", requiredMode = Schema.RequiredMode.REQUIRED, example = "127.0.0.1")
    @NotEmpty(message = "User IP is required.")
    private String userIp;
    @Schema(description = "浏览器 UserAgent", requiredMode = Schema.RequiredMode.REQUIRED, example = "Mozilla/5.0")
    @NotEmpty(message = "User agent is required.")
    private String userAgent;

}
