package cn.iocoder.yudao.module.system.controller.admin.auth.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Schema(description = "Sign-in user permission info response VO.")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthPermissionInfoRespVO {

    @Schema(description = "User info.", requiredMode = Schema.RequiredMode.REQUIRED)
    private UserVO user;

    @Schema(description = "Role key Array.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Set<String> roles;

    @Schema(description = "Action permission Array.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Set<String> permissions;

    @Schema(description = "Menutree.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<MenuVO> menus;

    @Schema(description = "User info VO.")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UserVO {

        @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long id;

        @Schema(description = "Nickname", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
        private String nickname;

        @Schema(description = "UserAvatar.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xx.jpg")
        private String avatar;

        @Schema(description = "Department code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
        private Long deptId;

        @Schema(description = "Username.", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao")
        private String username;

        @Schema(description = "Useremail.", example = "yudao@iocoder.cn")
        private String email;

    }

    @Schema(description = "Admin - sign-in user menu info response.")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class MenuVO {

        @Schema(description = "Menu name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
        private Long id;

        @Schema(description = "Parent menu ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long parentId;

        @Schema(description = "Menu name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
        private String name;

        @Schema(description = "Route path. Required for menu or directory types.", example = "post")
        private String path;

        @Schema(description = "Component path. Required for menu types.", example = "system/post/index")
        private String component;

        @Schema(description = "Component name", example = "SystemUser")
        private String componentName;

        @Schema(description = "Menu icon. Required for menu or directory types.", example = "/menu/list")
        private String icon;

        @Schema(description = "Visible", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
        private Boolean visible;

        @Schema(description = "Keep-alive", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
        private Boolean keepAlive;

        @Schema(description = "Always show", example = "false")
        private Boolean alwaysShow;

        /**
         * 子路由
         */
        private List<MenuVO> children;

    }

}
