package cn.iocoder.yudao.framework.common.biz.system.oauth2;

import cn.iocoder.yudao.framework.common.enums.RpcConstants;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.biz.system.oauth2.dto.OAuth2AccessTokenCheckRespDTO;
import cn.iocoder.yudao.framework.common.biz.system.oauth2.dto.OAuth2AccessTokenCreateReqDTO;
import cn.iocoder.yudao.framework.common.biz.system.oauth2.dto.OAuth2AccessTokenRespDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@FeignClient(name = RpcConstants.SYSTEM_NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC - OAuth2.0 token.")
public interface OAuth2TokenCommonApi {

    String PREFIX = RpcConstants.SYSTEM_PREFIX + "/oauth2/token";

    /**
     * 校验 Token 的 URL 地址，主要是提供给 Gateway 使用
     */
    @SuppressWarnings("HttpUrlsUsage")
    String URL_CHECK = "http://" + RpcConstants.SYSTEM_NAME + PREFIX + "/check";

    @PostMapping(PREFIX + "/create")
    @Operation(summary = "Create access token.")
    CommonResult<OAuth2AccessTokenRespDTO> createAccessToken(@Valid @RequestBody OAuth2AccessTokenCreateReqDTO reqDTO);

    @GetMapping(PREFIX + "/check")
    @Operation(summary = "Validate access token.")
    @Parameter(name = "accessToken", description = "Access token.", required = true, example = "tudou")
    CommonResult<OAuth2AccessTokenCheckRespDTO> checkAccessToken(@RequestParam("accessToken") String accessToken);

    @DeleteMapping(PREFIX + "/remove")
    @Operation(summary = "Remove access token.")
    @Parameter(name = "accessToken", description = "Access token.", required = true, example = "tudou")
    CommonResult<OAuth2AccessTokenRespDTO> removeAccessToken(@RequestParam("accessToken") String accessToken);

    @DeleteMapping(PREFIX + "/remove-by-user")
    @Operation(summary = "Remove user all access token.")
    @Parameters({
        @Parameter(name = "userId", description = "User ID.", required = true, example = "1024"),
        @Parameter(name = "userType", description = "User type.", required = true, example = "2")
    })
    CommonResult<Boolean> removeAccessToken(@RequestParam("userId") Long userId,
                                             @RequestParam("userType") Integer userType);

    @PutMapping(PREFIX + "/refresh")
    @Operation(summary = "Refresh access token.")
    @Parameters({
        @Parameter(name = "refreshToken", description = "Refresh token.", required = true, example = "haha"),
        @Parameter(name = "clientId", description = "Client code.", required = true, example = "yudaoyuanma")
    })
    CommonResult<OAuth2AccessTokenRespDTO> refreshAccessToken(@RequestParam("refreshToken") String refreshToken,
                                                              @RequestParam("clientId") String clientId);

}
