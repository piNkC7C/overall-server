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
@Tag(name = "RPC service - role.")
public interface RoleApi {

    String PREFIX = ApiConstants.PREFIX + "/role";

    @GetMapping(PREFIX + "/valid")
    @Operation(summary = "Validate role valid.")
    @Parameter(name = "ids", description = "Role ID list.", example = "1,2", required = true)
    CommonResult<Boolean> validRoleList(@RequestParam("ids") Collection<Long> ids);

    @GetMapping(PREFIX + "/get")
    @Operation(summary = "Get role.")
    @Parameter(name = "id", description = "Role code.", example = "1", required = true)
    CommonResult<RoleRespDTO> getRole(@RequestParam("id") Long id);

    @GetMapping(PREFIX + "/list")
    @Operation(summary = "Get role list.")
    @Parameter(name = "ids", description = "Role ID list.", example = "1,2", required = true)
    CommonResult<List<RoleRespDTO>> getRoleList(@RequestParam("ids") Collection<Long> ids);

    default Map<Long, RoleRespDTO> getRoleMap(Collection<Long> ids) {
        return CollectionUtils.convertMap(getRoleList(ids).getCheckedData(), RoleRespDTO::getId);
    }

}
