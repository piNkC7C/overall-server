package cn.iocoder.yudao.module.member.controller.app.social;

import cn.hutool.core.codec.Base64;
import cn.iocoder.yudao.framework.common.enums.UserTypeEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.member.controller.app.social.vo.*;
import cn.iocoder.yudao.module.system.api.social.SocialClientApi;
import cn.iocoder.yudao.module.system.api.social.SocialUserApi;
import cn.iocoder.yudao.module.system.api.social.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "User App - social user.")
@RestController
@RequestMapping("/member/social-user")
@Validated
public class AppSocialUserController {

    @Resource
    private SocialUserApi socialUserApi;
    @Resource
    private SocialClientApi socialClientApi;

    @PostMapping("/bind")
    @Operation(summary = "Social bind, used code Authorization code.")
    @PermitAll
    public CommonResult<String> socialBind(@RequestBody @Valid AppSocialUserBindReqVO reqVO) {
        SocialUserBindReqDTO reqDTO = new SocialUserBindReqDTO(getLoginUserId(), UserTypeEnum.MEMBER.getValue(),
                reqVO.getType(), reqVO.getCode(), reqVO.getState());
        String openid = socialUserApi.bindSocialUser(reqDTO).getCheckedData();
        return success(openid);
    }

    @DeleteMapping("/unbind")
    @Operation(summary = "Cancel social bind.")
    public CommonResult<Boolean> socialUnbind(@RequestBody AppSocialUserUnbindReqVO reqVO) {
        SocialUserUnbindReqDTO reqDTO = new SocialUserUnbindReqDTO(getLoginUserId(), UserTypeEnum.MEMBER.getValue(),
                reqVO.getType(), reqVO.getOpenid());
        socialUserApi.unbindSocialUser(reqDTO).checkError();
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get social user.")
    @Parameter(name = "type", description = "Social platform type. See SocialTypeEnum.", required = true, example = "10")
    public CommonResult<AppSocialUserRespVO> getSocialUser(@RequestParam("type") Integer type) {
        SocialUserRespDTO socialUser = socialUserApi.getSocialUserByUserId(UserTypeEnum.MEMBER.getValue(), getLoginUserId(), type).getCheckedData();
        return success(BeanUtils.toBean(socialUser, AppSocialUserRespVO.class));
    }

    @PostMapping("/wxa-qrcode")
    @Operation(summary = "Get the WeChat mini program QR code (base64 image).")
    @PermitAll
    public CommonResult<String> getWxaQrcode(@RequestBody @Valid AppSocialWxaQrcodeReqVO reqVO) {
        byte[] wxQrcode = socialClientApi.getWxaQrcode(BeanUtils.toBean(reqVO, SocialWxQrcodeReqDTO.class)).getCheckedData();
        return success(Base64.encode(wxQrcode));
    }

    @GetMapping("/get-subscribe-template-list")
    @Operation(summary = "Get WeChat mini program subscribe template list.")
    @PermitAll
    public CommonResult<List<AppSocialWxaSubscribeTemplateRespVO>> getSubscribeTemplateList() {
        List<SocialWxaSubscribeTemplateRespDTO> template = socialClientApi.getWxaSubscribeTemplateList(UserTypeEnum.MEMBER.getValue()).getCheckedData();
        return success(BeanUtils.toBean(template, AppSocialWxaSubscribeTemplateRespVO.class));
    }

}
