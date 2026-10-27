package cn.iocoder.yudao.module.system.controller.admin.permission.vo.menu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - menu simple info response.")
@Data
public class MenuSimpleRespVO {

    @Schema(description = "Menu code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Menu name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String name;

    @Schema(description = "Parent menu ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long parentId;

    @Schema(description = "Type, see MenuTypeEnum enum class.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

}
