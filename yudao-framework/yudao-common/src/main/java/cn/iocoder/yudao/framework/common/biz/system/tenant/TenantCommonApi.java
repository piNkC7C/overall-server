package cn.iocoder.yudao.framework.common.biz.system.tenant;

import cn.iocoder.yudao.framework.common.enums.RpcConstants;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = RpcConstants.SYSTEM_NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC - multi-tenant.")
public interface TenantCommonApi {

    String PREFIX = RpcConstants.SYSTEM_PREFIX + "/tenant";

    @GetMapping(PREFIX + "/id-list")
    @Operation(summary = "Get all Tenant ID.")
    CommonResult<List<Long>> getTenantIdList();

    @GetMapping(PREFIX + "/valid")
    @Operation(summary = "Validate tenant valid.")
    @Parameter(name = "id", description = "Tenant code.", required = true, example = "1024")
    CommonResult<Boolean> validTenant(@RequestParam("id") Long id);

}
