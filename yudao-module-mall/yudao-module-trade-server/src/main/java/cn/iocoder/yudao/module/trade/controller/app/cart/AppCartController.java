package cn.iocoder.yudao.module.trade.controller.app.cart;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.trade.controller.app.cart.vo.*;
import cn.iocoder.yudao.module.trade.service.cart.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "App - Cart.")
@RestController
@RequestMapping("/trade/cart")
@RequiredArgsConstructor
@Validated
@Slf4j
public class AppCartController {

    @Resource
    private CartService cartService;

    @PostMapping("/add")
    @Operation(summary = "Add a cart item.")
    public CommonResult<Long> addCart(@Valid @RequestBody AppCartAddReqVO addCountReqVO) {
        return success(cartService.addCart(getLoginUserId(), addCountReqVO));
    }

    @PutMapping("/update-count")
    @Operation(summary = "Update cart item quantity.")
    public CommonResult<Boolean> updateCartCount(@Valid @RequestBody AppCartUpdateCountReqVO updateReqVO) {
        cartService.updateCartCount(getLoginUserId(), updateReqVO);
        return success(true);
    }

    @PutMapping("/update-selected")
    @Operation(summary = "Update cart item selected state.")
    public CommonResult<Boolean> updateCartSelected(@Valid @RequestBody AppCartUpdateSelectedReqVO updateReqVO) {
        cartService.updateCartSelected(getLoginUserId(), updateReqVO);
        return success(true);
    }

    @PutMapping("/reset")
    @Operation(summary = "Reset cart items.")
    public CommonResult<Boolean> resetCart(@Valid @RequestBody AppCartResetReqVO updateReqVO) {
        cartService.resetCart(getLoginUserId(), updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete a cart item.")
    @Parameter(name = "ids", description = "Cart product ID.", required = true, example = "1024,2048")
    public CommonResult<Boolean> deleteCart(@RequestParam("ids") List<Long> ids) {
        cartService.deleteCart(getLoginUserId(), ids);
        return success(true);
    }

    @GetMapping("get-count")
    @Operation(summary = "Get the user's cart item count.")
    public CommonResult<Integer> getCartCount() {
        return success(cartService.getCartCount(getLoginUserId()));
    }

    @GetMapping("/list")
    @Operation(summary = "Get the user's cart.")
    public CommonResult<AppCartListRespVO> getCartList() {
        return success(cartService.getCartList(getLoginUserId()));
    }

}
