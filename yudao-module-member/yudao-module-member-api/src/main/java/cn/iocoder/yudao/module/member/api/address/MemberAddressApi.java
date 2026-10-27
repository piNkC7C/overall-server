package cn.iocoder.yudao.module.member.api.address;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.member.api.address.dto.MemberAddressRespDTO;
import cn.iocoder.yudao.module.member.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC - user shipping address.")
public interface MemberAddressApi {

    String PREFIX = ApiConstants.PREFIX + "/address";

    @GetMapping(PREFIX + "/get")
    @Operation(summary = "Getusershipping address.")
    @Parameters({
            @Parameter(name = "id", description = "Shipping-address ID.", required = true, example = "1024"),
            @Parameter(name = "userId", description = "User ID.", required = true, example = "2048"),
    })
    CommonResult<MemberAddressRespDTO> getAddress(@RequestParam("id") Long id,
                                                  @RequestParam("userId") Long userId);

    @GetMapping(PREFIX + "/get-default")
    @Operation(summary = "Get user default shipping address.")
    @Parameter(name = "userId", description = "User ID.", required = true, example = "2048")
    CommonResult<MemberAddressRespDTO> getDefaultAddress(@RequestParam("userId") Long userId);

}
