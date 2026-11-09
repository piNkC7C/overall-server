package cn.iocoder.yudao.framework.common.biz.system.oauth2.dto;

import cn.iocoder.yudao.framework.common.enums.UserTypeEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Schema(description = "RPC 服务 - OAuth2 访问令牌创建 Request DTO")
@Data
public class OAuth2AccessTokenCreateReqDTO implements Serializable {

    @Schema(description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "User ID is required.")
    private Long userId;

    @Schema(description = "用户类型，参见 UserTypeEnum 枚举", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "User type is required.")
    @InEnum(value = UserTypeEnum.class, message = "User type must be {value}.")
    private Integer userType;

    @Schema(description = "客户端编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudaoyuanma")
    @NotNull(message = "Client code is required.")
    private String clientId;

    @Schema(description = "授权范围的数组", example = "user_info")
    private List<String> scopes;

}
