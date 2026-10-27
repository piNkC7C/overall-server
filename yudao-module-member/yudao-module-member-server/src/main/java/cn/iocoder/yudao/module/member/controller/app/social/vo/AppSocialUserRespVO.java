package cn.iocoder.yudao.module.member.controller.app.social.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "User APP - social user response.")
@Data
public class AppSocialUserRespVO {

    @Schema(description = "Social user openid.", requiredMode = Schema.RequiredMode.REQUIRED, example = "IPRmJ0wvBptiPIlGEZiPewGwiEiE")
    private String openid;

    @Schema(description = "Social user Nickname.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String nickname;

    @Schema(description = "Social user Avatar.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/1.png")
    private String avatar;

}
