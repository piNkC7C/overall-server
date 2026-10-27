package cn.iocoder.yudao.module.member.controller.app.user;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.member.controller.app.user.vo.*;
import cn.iocoder.yudao.module.member.convert.user.MemberUserConvert;
import cn.iocoder.yudao.module.member.dal.dataobject.level.MemberLevelDO;
import cn.iocoder.yudao.module.member.dal.dataobject.user.MemberUserDO;
import cn.iocoder.yudao.module.member.service.level.MemberLevelService;
import cn.iocoder.yudao.module.member.service.user.MemberUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "App - user profile.")
@RestController
@RequestMapping("/member/user")
@Validated
@Slf4j
public class AppMemberUserController {

    @Resource
    private MemberUserService userService;
    @Resource
    private MemberLevelService levelService;

    @GetMapping("/get")
    @Operation(summary = "Get Basic Info.")
    public CommonResult<AppMemberUserInfoRespVO> getUserInfo() {
        MemberUserDO user = userService.getUser(getLoginUserId());
        MemberLevelDO level = levelService.getLevel(user.getLevelId());
        return success(MemberUserConvert.INSTANCE.convert(user, level));
    }

    @PutMapping("/update")
    @Operation(summary = "Edit Basic Info.")
    public CommonResult<Boolean> updateUser(@RequestBody @Valid AppMemberUserUpdateReqVO reqVO) {
        userService.updateUser(getLoginUserId(), reqVO);
        return success(true);
    }

    @PutMapping("/update-mobile")
    @Operation(summary = "Edit userMobile.")
    public CommonResult<Boolean> updateUserMobile(@RequestBody @Valid AppMemberUserUpdateMobileReqVO reqVO) {
        userService.updateUserMobile(getLoginUserId(), reqVO);
        return success(true);
    }

    @PutMapping("/update-mobile-by-weixin")
    @Operation(summary = "Update the user phone from a WeChat mini program authorization code.")
    public CommonResult<Boolean> updateUserMobileByWeixin(@RequestBody @Valid AppMemberUserUpdateMobileByWeixinReqVO reqVO) {
        userService.updateUserMobileByWeixin(getLoginUserId(), reqVO);
        return success(true);
    }

    @PutMapping("/update-password")
    @Operation(summary = "Edit user password.", description = "User edit password time used.")
    public CommonResult<Boolean> updateUserPassword(@RequestBody @Valid AppMemberUserUpdatePasswordReqVO reqVO) {
        userService.updateUserPassword(getLoginUserId(), reqVO);
        return success(true);
    }

    @PutMapping("/reset-password")
    @Operation(summary = "Reset password.", description = "Used when the user forgot the password.")
    @PermitAll
    public CommonResult<Boolean> resetUserPassword(@RequestBody @Valid AppMemberUserResetPasswordReqVO reqVO) {
        userService.resetUserPassword(reqVO);
        return success(true);
    }

}