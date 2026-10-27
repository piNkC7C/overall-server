package cn.iocoder.yudao.framework.common.biz.system.oauth2.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Schema(description = "OAuth2 access token validation response VO.")
@Data
public class OAuth2AccessTokenCheckRespDTO implements Serializable {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Long userId;

    @Schema(description = "User type. See UserTypeEnum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer userType;

    @Schema(description = "User info.", example = "{\"nickname\": \"John\"}")
    private Map<String, String> userInfo;

    @Schema(description = "Tenant code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long tenantId;

    @Schema(description = "Scopes Array.", example = "user_info")
    private List<String> scopes;

    @Schema(description = "Expires at", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime expiresTime;

}
