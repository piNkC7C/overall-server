package cn.iocoder.yudao.module.system.api.permission;

import cn.iocoder.yudao.framework.common.biz.system.permission.PermissionCommonApi;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.system.enums.ApiConstants;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Set;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - permission.")
public interface PermissionApi extends PermissionCommonApi {

    String PREFIX = ApiConstants.PREFIX + "/permission";

    @GetMapping(PREFIX + "/user-role-id-list-by-role-id")
    @Operation(summary = "Get user IDs that have multiple roles.")
    @Parameter(name = "roleIds", description = "Role IDs.", example = "1,2", required = true)
    CommonResult<Set<Long>> getUserRoleIdListByRoleIds(@RequestParam("roleIds") Collection<Long> roleIds);

}