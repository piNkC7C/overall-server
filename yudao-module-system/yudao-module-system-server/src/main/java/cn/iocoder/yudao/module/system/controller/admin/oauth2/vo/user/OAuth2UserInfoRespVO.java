package cn.iocoder.yudao.module.system.controller.admin.oauth2.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Schema(description = "Admin - OAuth2 get userBasic Info response.")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OAuth2UserInfoRespVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Username.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String username;

    @Schema(description = "Nickname", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String nickname;

    @Schema(description = "Useremail.", example = "yudao@iocoder.cn")
    private String email;
    @Schema(description = "Mobile Number", example = "15601691300")
    private String mobile;

    @Schema(description = "UserGender, see SexEnum enum class.", example = "1")
    private Integer sex;

    @Schema(description = "UserAvatar.", example = "https://www.iocoder.cn/xxx.png")
    private String avatar;

    /**
     * 所在部门
     */
    private Dept dept;

    /**
     * 所属岗位数组
     */
    private List<Post> posts;

    @Schema(description = "Department.")
    @Data
    public static class Dept {

        @Schema(description = "Department code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Long id;

        @Schema(description = "Department name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Engineering.")
        private String name;

    }

    @Schema(description = "Post.")
    @Data
    public static class Post {

        @Schema(description = "Post code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Long id;

        @Schema(description = "Post name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Development")
        private String name;

    }

}
