package cn.iocoder.yudao.module.system.controller.admin.auth.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Schema(description = "Admin - sign-in user menu info response.")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthMenuRespVO {

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
    private List<AuthMenuRespVO> children;

}
