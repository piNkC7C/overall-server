package cn.iocoder.yudao.module.system.controller.admin.social.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - social user response.")
@Data
public class SocialUserRespVO {

    @Schema(description = "Primary key", requiredMode = Schema.RequiredMode.REQUIRED, example = "14569")
    private Long id;

    @Schema(description = "Social platform type", requiredMode = Schema.RequiredMode.REQUIRED, example = "30")
    private Integer type;

    @Schema(description = "Social openid.", requiredMode = Schema.RequiredMode.REQUIRED, example = "666")
    private String openid;

    @Schema(description = "Social token.", requiredMode = Schema.RequiredMode.REQUIRED, example = "666")
    private String token;

    @Schema(description = "Raw token JSON", requiredMode = Schema.RequiredMode.REQUIRED, example = "{}")
    private String rawTokenInfo;

    @Schema(description = "Nickname", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String nickname;

    @Schema(description = "UserAvatar.", example = "https://www.iocoder.cn/xxx.png")
    private String avatar;

    @Schema(description = "Raw user JSON", requiredMode = Schema.RequiredMode.REQUIRED, example = "{}")
    private String rawUserInfo;

    @Schema(description = "Last auth code", requiredMode = Schema.RequiredMode.REQUIRED, example = "666666")
    private String code;

    @Schema(description = "Last auth state", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456")
    private String state;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Update time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime updateTime;

}
