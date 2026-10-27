package cn.iocoder.yudao.module.system.controller.admin.oauth2.vo.client;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - OAuth2 client response.")
@Data
public class OAuth2ClientRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Client code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "tudou")
    private String clientId;

    @Schema(description = "Client secret.", requiredMode = Schema.RequiredMode.REQUIRED, example = "fan")
    private String secret;

    @Schema(description = "App name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Potato.")
    private String name;

    @Schema(description = "App icon", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xx.png")
    private String logo;

    @Schema(description = "AppDescription.", example = "Me is one app.")
    private String description;

    @Schema(description = "Status, see CommonStatusEnum enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Access token expiration date.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8640")
    private Integer accessTokenValiditySeconds;

    @Schema(description = "Refresh token expiration date.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8640000")
    private Integer refreshTokenValiditySeconds;

    @Schema(description = "Redirect URIs", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    private List<String> redirectUris;

    @Schema(description = "Grant types, see OAuth2GrantTypeEnum enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "password")
    private List<String> authorizedGrantTypes;

    @Schema(description = "Scopes", example = "user_info")
    private List<String> scopes;

    @Schema(description = "Auto-approve scopes", example = "user_info")
    private List<String> autoApproveScopes;

    @Schema(description = "Permission.", example = "system:user:query")
    private List<String> authorities;

    @Schema(description = "Resource.", example = "1024")
    private List<String> resourceIds;

    @Schema(description = "Extra info", example = "{yunai: true}")
    private String additionalInformation;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
