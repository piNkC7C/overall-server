package cn.iocoder.yudao.module.member.controller.app.auth;

import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.enums.UserTypeEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.security.config.SecurityProperties;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import cn.iocoder.yudao.module.member.controller.app.auth.vo.*;
import cn.iocoder.yudao.module.member.convert.auth.AuthConvert;
import cn.iocoder.yudao.module.member.service.auth.MemberAuthService;
import cn.iocoder.yudao.module.system.api.social.SocialClientApi;
import cn.iocoder.yudao.module.system.api.social.dto.SocialWxJsapiSignatureRespDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "User APP - auth.")
@RestController
@RequestMapping("/member/auth")
@Validated
@Slf4j
public class AppAuthController {

    @Resource
    private MemberAuthService authService;

    @Resource
    private SocialClientApi socialClientApi;

    @Resource
    private SecurityProperties securityProperties;

    @PostMapping("/login")
    @Operation(summary = "UsedMobile + password sign-in.")
    @PermitAll
    public CommonResult<AppAuthLoginRespVO> login(@RequestBody @Valid AppAuthLoginReqVO reqVO) {
        return success(authService.login(reqVO));
    }

    @PostMapping("/logout")
    @Operation(summary = "Sign out.")
    @PermitAll
    public CommonResult<Boolean> logout(HttpServletRequest request) {
        String token = SecurityFrameworkUtils.obtainAuthorization(request,
                securityProperties.getTokenHeader(), securityProperties.getTokenParameter());
        if (StrUtil.isNotBlank(token)) {
            authService.logout(token);
        }
        return success(true);
    }

    @PostMapping("/refresh-token")
    @Operation(summary = "Refresh token.")
    @Parameter(name = "refreshToken", description = "Refresh token.", required = true)
    @PermitAll
    public CommonResult<AppAuthLoginRespVO> refreshToken(@RequestParam("refreshToken") String refreshToken) {
        return success(authService.refreshToken(refreshToken));
    }

    // ========== 短信登录相关 ==========

    @PostMapping("/sms-login")
    @Operation(summary = "UsedMobile + Verification code sign-in.")
    @PermitAll
    public CommonResult<AppAuthLoginRespVO> smsLogin(@RequestBody @Valid AppAuthSmsLoginReqVO reqVO) {
        return success(authService.smsLogin(reqVO));
    }

    @PostMapping("/send-sms-code")
    @Operation(summary = "Send SMS code.")
    @PermitAll
    public CommonResult<Boolean> sendSmsCode(@RequestBody @Valid AppAuthSmsSendReqVO reqVO) {
        authService.sendSmsCode(getLoginUserId(), reqVO);
        return success(true);
    }

    @PostMapping("/validate-sms-code")
    @Operation(summary = "Validate phone verification code.")
    @PermitAll
    public CommonResult<Boolean> validateSmsCode(@RequestBody @Valid AppAuthSmsValidateReqVO reqVO) {
        authService.validateSmsCode(getLoginUserId(), reqVO);
        return success(true);
    }

    // ========== 社交登录相关 ==========

    @GetMapping("/social-auth-redirect")
    @Operation(summary = "Social-auth redirect.")
    @Parameters({
            @Parameter(name = "type", description = "Social type.", required = true),
            @Parameter(name = "redirectUri", description = "Callback path.")
    })
    @PermitAll
    public CommonResult<String> socialAuthRedirect(@RequestParam("type") Integer type,
                                                   @RequestParam("redirectUri") String redirectUri) {
        return CommonResult.success(authService.getSocialAuthorizeUrl(type, redirectUri));
    }

    @PostMapping("/social-login")
    @Operation(summary = "Social quick sign-in with an authorization code.", description = "For guests whose social account is already bound to a user.")
    @PermitAll
    public CommonResult<AppAuthLoginRespVO> socialLogin(@RequestBody @Valid AppAuthSocialLoginReqVO reqVO) {
        return success(authService.socialLogin(reqVO));
    }

    @PostMapping("/weixin-mini-app-login")
    @Operation(summary = "WeChat mini program one-tap sign-in.")
    @PermitAll
    public CommonResult<AppAuthLoginRespVO> weixinMiniAppLogin(@RequestBody @Valid AppAuthWeixinMiniAppLoginReqVO reqVO) {
        return success(authService.weixinMiniAppLogin(reqVO));
    }

    @PostMapping("/create-weixin-jsapi-signature")
    @Operation(summary = "Create WeChat JS SDK init signature.",
            description = "See https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/JS-SDK.html.")
    @PermitAll
    public CommonResult<SocialWxJsapiSignatureRespDTO> createWeixinMpJsapiSignature(@RequestParam("url") String url) {
        SocialWxJsapiSignatureRespDTO signature = socialClientApi.createWxMpJsapiSignature(
                UserTypeEnum.MEMBER.getValue(), url).getCheckedData();
        return success(AuthConvert.INSTANCE.convert(signature));
    }

}
