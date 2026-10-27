package cn.iocoder.yudao.module.system.controller.admin.oauth2.vo.client;

import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.util.json.JsonUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Schema(description = "Admin - OAuth2 client create or update request.")
@Data
public class OAuth2ClientSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Client code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "tudou")
    @NotNull(message = "Client code is required.")
    private String clientId;

    @Schema(description = "Client secret.", requiredMode = Schema.RequiredMode.REQUIRED, example = "fan")
    @NotNull(message = "Client secret is required.")
    private String secret;

    @Schema(description = "App name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Potato.")
    @NotNull(message = "App name is required.")
    private String name;

    @Schema(description = "App icon", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xx.png")
    @NotNull(message = "App icon is required.")
    @URL(message = "App icon Address is invalid.")
    private String logo;

    @Schema(description = "AppDescription.", example = "Me is one app.")
    private String description;

    @Schema(description = "Status, see CommonStatusEnum enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "Access token expiration date.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8640")
    @NotNull(message = "Access token expiration date is required.")
    private Integer accessTokenValiditySeconds;

    @Schema(description = "Refresh token expiration date.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8640000")
    @NotNull(message = "Refresh token expiration date is required.")
    private Integer refreshTokenValiditySeconds;

    @Schema(description = "Redirect URIs", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    @NotNull(message = "Redirect URIs is required.")
    private List<@NotEmpty(message = "Redirect URI cannot be empty.") @URL(message = "Redirect URI format is invalid.") String> redirectUris;

    @Schema(description = "Grant types, see OAuth2GrantTypeEnum enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "password")
    @NotNull(message = "Grant types is required.")
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

    @AssertTrue(message = "Extra info must be JSON.")
    public boolean isAdditionalInformationJson() {
        return StrUtil.isEmpty(additionalInformation) || JsonUtils.isJson(additionalInformation);
    }

}
