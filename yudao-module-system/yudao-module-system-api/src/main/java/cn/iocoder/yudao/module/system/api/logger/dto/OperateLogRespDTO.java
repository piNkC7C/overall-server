package cn.iocoder.yudao.module.system.api.logger.dto;

import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import org.dromara.core.trans.anno.Trans;
import org.dromara.core.trans.constant.TransType;
import org.dromara.core.trans.vo.VO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(name = "RPC service - SystemActivity Log Response DTO.")
@Data
public class OperateLogRespDTO implements VO {

    @Schema(description = "Log ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Trace ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "89aca178-a370-411c-ae02-3f0d672be4ab")
    private String traceId;
    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "666")
    @Trans(type = TransType.AUTO_TRANS, key = AdminUserApi.PREFIX, fields = "nickname", ref = "userName")
    private Long userId;
    @Schema(description = "Username.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String userName;
    @Schema(description = "User type. See UserTypeEnum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2" )
    private Integer userType;
    @Schema(description = "Module type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Order.")
    private String type;
    @Schema(description = "Action name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Createorder.")
    private String subType;
    @Schema(description = "Module business code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "188")
    private Long bizId;
    @Schema(description = "Action content.", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "Update user 1: change gender from male to female, and name from John to Jane")
    private String action;
    @Schema(description = "Extra JSON", example = "{\"orderId\": \"1\"}")
    private String extra;

    @Schema(description = "Request method.", requiredMode = Schema.RequiredMode.REQUIRED, example = "GET")
    private String requestMethod;
    @Schema(description = "Request URL.", requiredMode = Schema.RequiredMode.REQUIRED, example = "/order/get")
    private String requestUrl;
    @Schema(description = "User IP.", requiredMode = Schema.RequiredMode.REQUIRED, example = "127.0.0.1")
    private String userIp;
    @Schema(description = "Browser user agent.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Mozilla/5.0")
    private String userAgent;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
