package cn.iocoder.yudao.module.system.controller.admin.permission.vo.permission;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Set;

@Schema(description = "Assign user roles request VO.")
@Data
public class PermissionAssignUserRoleReqVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "User ID is required.")
    private Long userId;

    @Schema(description = "Role code list.", example = "1,3,5")
    private Set<Long> roleIds = Collections.emptySet(); // 兜底

}
