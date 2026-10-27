package cn.iocoder.yudao.module.system.controller.admin.permission.vo.menu;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - menu create or update request.")
@Data
public class MenuSaveVO {

    @Schema(description = "Menu code.", example = "1024")
    private Long id;

    @Schema(description = "Menu name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotBlank(message = "Menu name is required.")
    @Size(max = 50, message = "Menu name length cannot exceed 50 characters.")
    private String name;

    @Schema(description = "Permission key. Required only when the menu type is a button.", example = "sys:menu:add")
    @Size(max = 100)
    private String permission;

    @Schema(description = "Type, see MenuTypeEnum enum class.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Menu type is required.")
    private Integer type;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "Parent menu ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Parent menu ID is required.")
    private Long parentId;

    @Schema(description = "Route path. Required for menu or directory types.", example = "post")
    @Size(max = 200, message = "Route path cannot exceed 200 characters.")
    private String path;

    @Schema(description = "Menu icon. Required for menu or directory types.", example = "/menu/list")
    private String icon;

    @Schema(description = "Component path. Required for menu types.", example = "system/post/index")
    @Size(max = 200, message = "Component path cannot exceed 255 characters.")
    private String component;

    @Schema(description = "Component name", example = "SystemUser")
    private String componentName;

    @Schema(description = "Status. See CommonStatusEnum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "Visible", example = "false")
    private Boolean visible;

    @Schema(description = "Keep-alive", example = "false")
    private Boolean keepAlive;

    @Schema(description = "Always show", example = "false")
    private Boolean alwaysShow;

}
