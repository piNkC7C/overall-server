package cn.iocoder.yudao.module.system.controller.admin.social.vo.client;

import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.enums.UserTypeEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.system.enums.social.SocialTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;

@Schema(description = "Admin - social client create or update request.")
@Data
public class SocialClientSaveReqVO {

    @Schema(description = "Code.", example = "27162")
    private Long id;

    @Schema(description = "App name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Yudao shop.")
    @NotNull(message = "App name is required.")
    private String name;

    @Schema(description = "Social platform type", requiredMode = Schema.RequiredMode.REQUIRED, example = "31")
    @NotNull(message = "Social platform type is required")
    @InEnum(SocialTypeEnum.class)
    private Integer socialType;

    @Schema(description = "User type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "User type is required.")
    @InEnum(UserTypeEnum.class)
    private Integer userType;

    @Schema(description = "Client code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "wwd411c69a39ad2e54")
    @NotNull(message = "Client code is required.")
    private String clientId;

    @Schema(description = "Client secret.", requiredMode = Schema.RequiredMode.REQUIRED, example = "peter")
    @NotNull(message = "Client secret is required.")
    private String clientSecret;

    @Schema(description = "Authorizer web app ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2000045")
    private String agentId;

    @Schema(description = "Public key", example = "2000045")
    private String publicKey;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @AssertTrue(message = "AgentId is required.")
    @JsonIgnore
    public boolean isAgentIdValid() {
        // If is WeCom, must enter agentId attribute
        return !Objects.equals(socialType, SocialTypeEnum.WECHAT_ENTERPRISE.getType())
                || !StrUtil.isEmpty(agentId);
    }

    @AssertTrue(message = "PublicKey is required.")
    @JsonIgnore
    public boolean isPublicKeyValid() {
        // 如果是支付宝，必须填写 publicKey 属性
        return !Objects.equals(socialType, SocialTypeEnum.ALIPAY_MINI_PROGRAM.getType())
                || !StrUtil.isEmpty(publicKey);
    }

}
