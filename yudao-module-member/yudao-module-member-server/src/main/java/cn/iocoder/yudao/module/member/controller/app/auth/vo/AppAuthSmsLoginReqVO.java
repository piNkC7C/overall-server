package cn.iocoder.yudao.module.member.controller.app.auth.vo;

import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.framework.common.validation.Mobile;
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

@Schema(description = "App phone + SMS sign-in request VO. If binding a social user, pass social* params.")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppAuthSmsLoginReqVO {

    @Schema(description = "Phone number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15601691300")
    @NotEmpty(message = "Phone number is required.")
    @Mobile
    private String mobile;

    @Schema(description = "SMS code", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotEmpty(message = "SMS code is required.")
    @Length(min = 4, max = 6, message = "SMS code length is 4-6 characters.")
    @Pattern(regexp = "^[0-9]+$", message = "SMS code must all is digits.")
    private String code;

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