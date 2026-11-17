package cn.iocoder.yudao.module.system.api.permission;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.collection.CollectionUtils;
import cn.iocoder.yudao.module.system.api.permission.dto.RoleRespDTO;
import cn.iocoder.yudao.module.system.enums.ApiConstants;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC 服务 - 角色")
public interface RoleApi {

    String PREFIX = ApiConstants.PREFIX + "/role";

    @GetMapping(PREFIX + "/valid")
    @Operation(summary = "校验角色是否合法")
    @Parameter(name = "ids", description = "角色编号数组", example = "1,2", required = true)
    CommonResult<Boolean> validRoleList(@RequestParam("ids") Collection<Long> ids);

    @GetMapping(PREFIX + "/get")
    @Operation(summary = "获得角色")
    @Parameter(name = "id", description = "角色编号", example = "1", required = true)
    CommonResult<RoleRespDTO> getRole(@RequestParam("id") Long id);

    @GetMapping(PREFIX + "/list")
    @Operation(summary = "获得角色列表")
    @Parameter(name = "ids", description = "角色编号数组", example = "1,2", required = true)
    CommonResult<List<RoleRespDTO>> getRoleList(@RequestParam("ids") Collection<Long> ids);

    @GetMapping(PREFIX + "/list-by-codes")
    @Operation(summary = "获得角色列表（按编码）")
    @Parameter(name = "codes", description = "角色编码数组", example = "crm_admin,tenant_admin", required = true)
    CommonResult<List<RoleRespDTO>> getRoleListByCodes(@RequestParam("codes") Collection<String> codes);

    @GetMapping(PREFIX + "/create-if-absent")
    @Operation(summary = "按编码创建角色（不存在时）")
    @Parameter(name = "code", description = "角色编码", example = "crm_admin", required = true)
    @Parameter(name = "name", description = "角色名称", example = "CRM Admin", required = true)
    CommonResult<RoleRespDTO> createRoleIfAbsent(@RequestParam("code") String code,
                                                 @RequestParam("name") String name);

    default Map<Long, RoleRespDTO> getRoleMap(Collection<Long> ids) {
        return CollectionUtils.convertMap(getRoleList(ids).getCheckedData(), RoleRespDTO::getId);
    }

}
