package cn.iocoder.yudao.module.member.controller.app.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "User APP - user person info response.")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppMemberUserInfoRespVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Nickname", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String nickname;

    @Schema(description = "UserAvatar.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xxx.png")
    private String avatar;

    @Schema(description = "Userphone number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15601691300")
    private String mobile;

    @Schema(description = "Email", example = "member@iocoder.cn")
    private String email;

    @Schema(description = "UserGender.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer sex;

    @Schema(description = "Points.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer point;

    @Schema(description = "XP.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer experience;

    @Schema(description = "User level.")
    private Level level;

    @Schema(description = "Become a promoter.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean brokerageEnabled;

    @Schema(description = "User App - member level.")
    @Data
    public static class Level {

        @Schema(description = "Level code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Long id;

        @Schema(description = "Level name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
        private String name;

        @Schema(description = "Level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Integer level;

        @Schema(description = "Level Icon.", example = "https://www.iocoder.cn/yudao.jpg")
        private String icon;

    }

}
