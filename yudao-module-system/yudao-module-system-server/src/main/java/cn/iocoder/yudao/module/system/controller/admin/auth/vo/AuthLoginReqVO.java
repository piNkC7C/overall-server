package cn.iocoder.yudao.module.system.controller.admin.auth.vo;

import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.system.enums.social.SocialTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Schema(description = "Account password sign-in request VO.")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthLoginReqVO extends CaptchaVerificationReqVO {

    @Schema(description = "Account.", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudaoyuanma")
    @NotEmpty(message = "Sign-in account is required.")
    @Length(min = 4, max = 30, message = "Account length is 4-30 characters.")
    @Pattern(regexp = "^[a-zA-Z0-9]{4,30}$", message = "Account format is digits and letters.")
    private String username;

    @Schema(description = "Password.", requiredMode = Schema.RequiredMode.REQUIRED, example = "buzhidao")
    @NotEmpty(message = "Password is required.")
    @Length(min = 4, max = 16, message = "Password must be 4-16 characters.")
    private String password;

    // ========== 绑定社交登录时，需要传递如下参数 ==========

    @Schema(description = "Social platform type. See SocialTypeEnum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @InEnum(SocialTypeEnum.class)
    private Integer socialType;

    @Schema(description = "Authorization code", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private String socialCode;

    @Schema(description = "state", requiredMode = Schema.RequiredMode.REQUIRED, example = "9b2ffbc1-7425-4155-9894-9d5c08541d62")
    private String socialState;

    @AssertTrue(message = "Authorization code is required")
    public boolean isSocialCodeValid() {
        return socialType == null || StrUtil.isNotEmpty(socialCode);
    }

    @AssertTrue(message = "OAuth state cannot be empty.")
    public boolean isSocialState() {
        return socialType == null || StrUtil.isNotEmpty(socialState);
    }

}