package cn.iocoder.yudao.module.system.controller.admin.permission;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.system.controller.admin.permission.vo.permission.PermissionAssignRoleDataScopeReqVO;
import cn.iocoder.yudao.module.system.controller.admin.permission.vo.permission.PermissionAssignRoleMenuReqVO;
import cn.iocoder.yudao.module.system.controller.admin.permission.vo.permission.PermissionAssignUserRoleReqVO;
import cn.iocoder.yudao.module.system.service.permission.PermissionService;
import cn.iocoder.yudao.module.system.service.tenant.TenantService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import java.util.Set;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - permission.")
@RestController
@RequestMapping("/system/permission")
public class PermissionController {

    @Resource
    private PermissionService permissionService;
    @Resource
    private TenantService tenantService;

    @Operation(summary = "Get menu IDs owned by the role.")
    @Parameter(name = "roleId", description = "Role code.", required = true)
    @GetMapping("/list-role-menus")
    @PreAuthorize("@ss.hasPermission('system:permission:assign-role-menu')")
    public CommonResult<Set<Long>> getRoleMenuList(@RequestParam("roleId") Long roleId) {
        return success(permissionService.getRoleMenuListByRoleId(roleId));
    }

    @PostMapping("/assign-role-menu")
    @Operation(summary = "Assign role menu.")
    @PreAuthorize("@ss.hasPermission('system:permission:assign-role-menu')")
    public CommonResult<Boolean> assignRoleMenu(@Validated @RequestBody PermissionAssignRoleMenuReqVO reqVO) {
        // 开启多租户的情况下，需要过滤掉未开通的菜单
        tenantService.handleTenantMenu(menuIds -> reqVO.getMenuIds().removeIf(menuId -> !CollUtil.contains(menuIds, menuId)));

        // Execute menu assign
        permissionService.assignRoleMenu(reqVO.getRoleId(), reqVO.getMenuIds());
        return success(true);
    }

    @PostMapping("/assign-role-data-scope")
    @Operation(summary = "Assign role data permission.")
    @PreAuthorize("@ss.hasPermission('system:permission:assign-role-data-scope')")
    public CommonResult<Boolean> assignRoleDataScope(@Valid @RequestBody PermissionAssignRoleDataScopeReqVO reqVO) {
        permissionService.assignRoleDataScope(reqVO.getRoleId(), reqVO.getDataScope(), reqVO.getDataScopeDeptIds());
        return success(true);
    }

    @Operation(summary = "Get role IDs owned by the admin.")
    @Parameter(name = "userId", description = "User ID.", required = true)
    @GetMapping("/list-user-roles")
    @PreAuthorize("@ss.hasPermission('system:permission:assign-user-role')")
    public CommonResult<Set<Long>> listAdminRoles(@RequestParam("userId") Long userId) {
        return success(permissionService.getUserRoleIdListByUserId(userId));
    }

    @Operation(summary = "Assign user role.")
    @PostMapping("/assign-user-role")
    @PreAuthorize("@ss.hasPermission('system:permission:assign-user-role')")
    public CommonResult<Boolean> assignUserRole(@Validated @RequestBody PermissionAssignUserRoleReqVO reqVO) {
        permissionService.assignUserRole(reqVO.getUserId(), reqVO.getRoleIds());
        return success(true);
    }

}
