package cn.iocoder.yudao.module.system.controller.admin.oauth2.vo.token;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Schema(description = "Admin - access token response.")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OAuth2AccessTokenRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Access token.", requiredMode = Schema.RequiredMode.REQUIRED, example = "tudou")
    private String accessToken;

    @Schema(description = "Refresh token.", requiredMode = Schema.RequiredMode.REQUIRED, example = "nice")
    private String refreshToken;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "666")
    private Long userId;

    @Schema(description = "User type. See UserTypeEnum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer userType;

    @Schema(description = "Client code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private String clientId;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Expires at", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime expiresTime;

}
