package cn.iocoder.yudao.module.system.controller.admin.social.vo.client;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - social client response.")
@Data
public class SocialClientRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "27162")
    private Long id;

    @Schema(description = "App name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Yudao shop.")
    private String name;

    @Schema(description = "Social platform type", requiredMode = Schema.RequiredMode.REQUIRED, example = "31")
    private Integer socialType;

    @Schema(description = "User type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer userType;

    @Schema(description = "Client code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "wwd411c69a39ad2e54")
    private String clientId;

    @Schema(description = "Client secret.", requiredMode = Schema.RequiredMode.REQUIRED, example = "peter")
    private String clientSecret;

    @Schema(description = "Authorizer web app ID.", example = "2000045")
    private String agentId;

    @Schema(description = "Public key", example = "2000045")
    private String publicKey;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
