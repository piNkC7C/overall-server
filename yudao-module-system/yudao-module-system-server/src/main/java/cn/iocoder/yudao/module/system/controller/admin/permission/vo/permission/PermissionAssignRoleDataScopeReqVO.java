package cn.iocoder.yudao.module.system.controller.admin.permission.vo.permission;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.system.enums.permission.DataScopeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Set;

@Schema(description = "Assign role data permission request VO.")
@Data
public class PermissionAssignRoleDataScopeReqVO {

    @Schema(description = "Role code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Role code is required.")
    private Long roleId;

    @Schema(description = "Data Range, see DataScopeEnum enum class.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Data Range is required.")
    @InEnum(value = DataScopeEnum.class, message = "Data Range must be {value}.")
    private Integer dataScope;

    @Schema(description = "Department code list, Only Range type is DEPT_CUSTOM time, this field only then need to need.", example = "1,3,5")
    private Set<Long> dataScopeDeptIds = Collections.emptySet(); // 兜底

}
