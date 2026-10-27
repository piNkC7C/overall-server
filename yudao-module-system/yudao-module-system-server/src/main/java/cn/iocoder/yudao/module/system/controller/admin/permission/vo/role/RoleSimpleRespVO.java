package cn.iocoder.yudao.module.system.controller.admin.permission.vo.role;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - role simple info response.")
@Data
public class RoleSimpleRespVO {

    @Schema(description = "Role code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Role name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String name;

}
