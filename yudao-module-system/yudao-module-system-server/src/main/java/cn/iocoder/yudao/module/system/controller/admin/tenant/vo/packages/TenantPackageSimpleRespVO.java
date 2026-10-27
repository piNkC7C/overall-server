package cn.iocoder.yudao.module.system.controller.admin.tenant.vo.packages;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - tenant plan simple response.")
@Data
public class TenantPackageSimpleRespVO {

    @Schema(description = "Plan ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Plan ID is required.")
    private Long id;

    @Schema(description = "Plan name", requiredMode = Schema.RequiredMode.REQUIRED, example = "VIP")
    @NotNull(message = "Plan name is required.")
    private String name;

}
