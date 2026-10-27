package cn.iocoder.yudao.module.system.api.social;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.system.api.social.dto.SocialUserBindReqDTO;
import cn.iocoder.yudao.module.system.api.social.dto.SocialUserRespDTO;
import cn.iocoder.yudao.module.system.api.social.dto.SocialUserUnbindReqDTO;
import cn.iocoder.yudao.module.system.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - social user.")
public interface SocialUserApi {

    String PREFIX = ApiConstants.PREFIX + "/social-user";

    @PostMapping(PREFIX + "/bind")
    @Operation(summary = "Bind social user.")
    CommonResult<String> bindSocialUser(@Valid @RequestBody SocialUserBindReqDTO reqDTO);

    @DeleteMapping(PREFIX + "/unbind")
    @Operation(summary = "Cancel bind social user.")
    CommonResult<Boolean> unbindSocialUser(@Valid @RequestBody SocialUserUnbindReqDTO reqDTO);

    @GetMapping(PREFIX + "/get-by-user-id")
    @Operation(summary = "Get social user, based on userId.")
    @Parameters({
            @Parameter(name = "userType", description = "User type.", example = "2", required = true),
            @Parameter(name = "userId", description = "User ID.", example = "1024", required = true),
            @Parameter(name = "socialType", description = "Social platform type", example = "1", required = true),
    })
    CommonResult<SocialUserRespDTO> getSocialUserByUserId(@RequestParam("userType") Integer userType,
                                                          @RequestParam("userId") Long userId,
                                                          @RequestParam("socialType") Integer socialType);

    @GetMapping(PREFIX + "/get-by-code")
    @Operation(summary = "Get social.") // 在认证信息不正确的情况下，也会抛出 {@link ServiceException} 业务异常
    @Parameters({
            @Parameter(name = "userType", description = "User type.", example = "2", required = true),
            @Parameter(name = "socialType", description = "Social platform type", example = "1", required = true),
            @Parameter(name = "code", description = "Authorization code", example = "88888", required = true),
            @Parameter(name = "state", description = "state", example = "666", required = true),
    })
    CommonResult<SocialUserRespDTO> getSocialUserByCode(@RequestParam("userType") Integer userType,
                                                        @RequestParam("socialType") Integer socialType,
                                                        @RequestParam("code") String code,
                                                        @RequestParam("state") String state);

}
