package cn.iocoder.yudao.module.system.controller.app.tenant.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "User App - tenant response.")
@Data
public class AppTenantRespVO {

    @Schema(description = "Tenant code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Tenant name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String name;

}
