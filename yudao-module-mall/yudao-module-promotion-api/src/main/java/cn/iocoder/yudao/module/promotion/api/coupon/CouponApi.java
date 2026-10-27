package cn.iocoder.yudao.module.promotion.api.coupon;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.promotion.api.coupon.dto.CouponRespDTO;
import cn.iocoder.yudao.module.promotion.api.coupon.dto.CouponUseReqDTO;
import cn.iocoder.yudao.module.promotion.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - coupon.")
public interface CouponApi {

    String PREFIX = ApiConstants.PREFIX + "/coupon";

    @GetMapping(PREFIX + "/list-by-user-id")
    @Operation(summary = "Get user coupon list.")
    CommonResult<List<CouponRespDTO>> getCouponListByUserId(@RequestParam("userId") Long userId,
                                                            @RequestParam("status") Integer status);

    @PutMapping(PREFIX + "/use")
    @Operation(summary = "Usedcoupon.")
    CommonResult<Boolean> useCoupon(@RequestBody @Valid CouponUseReqDTO useReqDTO);

    @PutMapping(PREFIX + "/return-used")
    @Operation(summary = "Refund used coupons.")
    @Parameter(name = "id", description = "Coupon code.", required = true, example = "1")
    CommonResult<Boolean> returnUsedCoupon(@RequestParam("id") Long id);

    @PostMapping(PREFIX + "/take-by-admin")
    @Operation(summary = "Admin: grant coupons to users in bulk.") // 返回：优惠券编号列表
    @Parameters({
            @Parameter(name = "giveCoupons", description = "Key: coupontemplate code, value： a matching quantity.", required = true),
            @Parameter(name = "userId", description = "User ID.", required = true)
    })
    CommonResult<List<Long>> takeCouponsByAdmin(@RequestBody Map<Long, Integer> giveCoupons,
                                                @RequestParam("userId") Long userId);

    @PostMapping(PREFIX + "/invalidate-by-admin")
    @Operation(summary = "Admin: void a user's coupon.")
    @Parameters({
            @Parameter(name = "giveCouponIds", description = "Bonus coupon ID.", required = true),
            @Parameter(name = "userId", description = "User ID.", required = true)
    })
    CommonResult<Boolean> invalidateCouponsByAdmin(@RequestParam("giveCouponIds") List<Long> giveCouponIds,
                                                   @RequestParam("userId") Long userId);

}
