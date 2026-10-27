package cn.iocoder.yudao.module.system.controller.admin.social.vo.user;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.system.enums.social.SocialTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - cancel social bind request.")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SocialUserUnbindReqVO {

    @Schema(description = "Social platform type. See UserSocialTypeEnum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @InEnum(SocialTypeEnum.class)
    @NotNull(message = "Social platform type is required")
    private Integer type;

    @Schema(description = "Social user openid.", requiredMode = Schema.RequiredMode.REQUIRED, example = "IPRmJ0wvBptiPIlGEZiPewGwiEiE")
    @NotEmpty(message = "Social user openid is required.")
    private String openid;

}
