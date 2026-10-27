package cn.iocoder.yudao.module.system.controller.admin.tenant.vo.packages;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Schema(description = "Admin - tenant plan response.")
@Data
public class TenantPackageRespVO {

    @Schema(description = "Plan ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Plan name", requiredMode = Schema.RequiredMode.REQUIRED, example = "VIP")
    private String name;

    @Schema(description = "Status, see CommonStatusEnum enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Notes.", example = "OK")
    private String remark;

    @Schema(description = "Relation menu code.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Set<Long> menuIds;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
