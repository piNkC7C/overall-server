package cn.iocoder.yudao.module.promotion.controller.app.coupon;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.promotion.controller.app.coupon.vo.coupon.AppCouponPageReqVO;
import cn.iocoder.yudao.module.promotion.controller.app.coupon.vo.coupon.AppCouponRespVO;
import cn.iocoder.yudao.module.promotion.controller.app.coupon.vo.coupon.AppCouponTakeReqVO;
import cn.iocoder.yudao.module.promotion.convert.coupon.CouponConvert;
import cn.iocoder.yudao.module.promotion.dal.dataobject.coupon.CouponDO;
import cn.iocoder.yudao.module.promotion.dal.dataobject.coupon.CouponTemplateDO;
import cn.iocoder.yudao.module.promotion.enums.coupon.CouponTakeTypeEnum;
import cn.iocoder.yudao.module.promotion.service.coupon.CouponService;
import cn.iocoder.yudao.module.promotion.service.coupon.CouponTemplateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "User App - coupon.")
@RestController
@RequestMapping("/promotion/coupon")
@Validated
public class AppCouponController {

    @Resource
    private CouponService couponService;
    @Resource
    private CouponTemplateService couponTemplateService;

    @PostMapping("/take")
    @Operation(summary = "ClaimDiscountcoupon.")
    @Parameter(name = "templateId", description = "Coupontemplate code.", required = true, example = "1024")
    public CommonResult<Boolean> takeCoupon(@Valid @RequestBody AppCouponTakeReqVO reqVO) {
        // 1. 领取优惠劵
        Long userId = getLoginUserId();
        couponService.takeCoupon(reqVO.getTemplateId(), CollUtil.newHashSet(userId), CouponTakeTypeEnum.USER);

        // 2. 检查是否可以继续领取
        CouponTemplateDO couponTemplate = couponTemplateService.getCouponTemplate(reqVO.getTemplateId());
        boolean canTakeAgain = true;
        if (couponTemplate.getTakeLimitCount() != null && couponTemplate.getTakeLimitCount() > 0) {
            Integer takeCount = couponService.getTakeCount(reqVO.getTemplateId(), userId);
            canTakeAgain = takeCount < couponTemplate.getTakeLimitCount();
        }
        return success(canTakeAgain);
    }

    @GetMapping("/page")
    @Operation(summary = "Me coupon list.")
    public CommonResult<PageResult<AppCouponRespVO>> getCouponPage(AppCouponPageReqVO pageReqVO) {
        PageResult<CouponDO> pageResult = couponService.getCouponPage(
                CouponConvert.INSTANCE.convert(pageReqVO, Collections.singleton(getLoginUserId())));
        return success(BeanUtils.toBean(pageResult, AppCouponRespVO.class));
    }

    @GetMapping("/get")
    @Operation(summary = "Get coupon.")
    @Parameter(name = "id", description = "Coupon code.", required = true, example = "1024")
    public CommonResult<AppCouponRespVO> getCoupon(@RequestParam("id") Long id) {
        CouponDO coupon = couponService.getCoupon(getLoginUserId(), id);
        return success(BeanUtils.toBean(coupon, AppCouponRespVO.class));
    }

    @GetMapping(value = "/get-unused-count")
    @Operation(summary = "Get not used coupon quantity.")
    public CommonResult<Long> getUnusedCouponCount() {
        return success(couponService.getUnusedCouponCount(getLoginUserId()));
    }

}
