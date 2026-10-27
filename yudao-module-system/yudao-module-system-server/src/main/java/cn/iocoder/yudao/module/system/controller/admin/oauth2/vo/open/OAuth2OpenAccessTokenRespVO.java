package cn.iocoder.yudao.module.system.controller.admin.oauth2.vo.open;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "[ open API ] access token response VO.")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OAuth2OpenAccessTokenRespVO {

    @Schema(description = "Access token.", requiredMode = Schema.RequiredMode.REQUIRED, example = "tudou")
    @JsonProperty("access_token")
    private String accessToken;

    @Schema(description = "Refresh token.", requiredMode = Schema.RequiredMode.REQUIRED, example = "nice")
    @JsonProperty("refresh_token")
    private String refreshToken;

    @Schema(description = "Token type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "bearer")
    @JsonProperty("token_type")
    private String tokenType;

    @Schema(description = "Expires at, order characters ：Seconds.", requiredMode = Schema.RequiredMode.REQUIRED, example = "42430")
    @JsonProperty("expires_in")
    private Long expiresIn;

    @Schema(description = "Scopes. Separate multiple scopes with spaces.", example = "user_info")
    private String scope;

}
