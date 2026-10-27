package cn.iocoder.yudao.framework.common.biz.system.oauth2.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Schema(description = "RPC service - OAuth2 access token info Response DTO.")
@Data
public class OAuth2AccessTokenRespDTO implements Serializable {

    @Schema(description = "Access token.", requiredMode = Schema.RequiredMode.REQUIRED, example = "tudou")
    private String accessToken;

    @Schema(description = "Refresh token.", requiredMode = Schema.RequiredMode.REQUIRED, example = "haha")
    private String refreshToken;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Long userId;

    @Schema(description = "User type. See UserTypeEnum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1" )
    private Integer userType;

    @Schema(description = "Expires at", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime expiresTime;

}
