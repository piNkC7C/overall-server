package cn.iocoder.yudao.framework.common.biz.system.permission;

import cn.iocoder.yudao.framework.common.biz.system.permission.dto.DeptDataPermissionRespDTO;
import cn.iocoder.yudao.framework.common.enums.RpcConstants;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = RpcConstants.SYSTEM_NAME, primary = false) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - permission.")
public interface PermissionCommonApi {

    String PREFIX = RpcConstants.SYSTEM_PREFIX + "/permission";

    @GetMapping(PREFIX + "/has-any-permissions")
    @Operation(summary = "Check whether the user has any of the permissions.")
    @Parameters({
            @Parameter(name = "userId", description = "User ID.", example = "1", required = true),
            @Parameter(name = "permissions", description = "Permission.", example = "read,write", required = true)
    })
    CommonResult<Boolean> hasAnyPermissions(@RequestParam("userId") Long userId,
                                            @RequestParam("permissions") String... permissions);

    @GetMapping(PREFIX + "/has-any-roles")
    @Operation(summary = "Check whether the user has any of the roles.")
    @Parameters({
            @Parameter(name = "userId", description = "User ID.", example = "1", required = true),
            @Parameter(name = "roles", description = "RoleArray.", example = "2", required = true)
    })
    CommonResult<Boolean> hasAnyRoles(@RequestParam("userId") Long userId,
                                      @RequestParam("roles") String... roles);

    @GetMapping(PREFIX + "/get-dept-data-permission")
    @Operation(summary = "Get signed-in user department data permission.")
    @Parameter(name = "userId", description = "User ID.", example = "2", required = true)
    CommonResult<DeptDataPermissionRespDTO> getDeptDataPermission(@RequestParam("userId") Long userId);

}