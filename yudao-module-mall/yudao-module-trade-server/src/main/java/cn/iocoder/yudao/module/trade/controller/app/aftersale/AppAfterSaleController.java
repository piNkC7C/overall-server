package cn.iocoder.yudao.module.trade.controller.app.aftersale;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.trade.controller.app.aftersale.vo.AppAfterSaleCreateReqVO;
import cn.iocoder.yudao.module.trade.controller.app.aftersale.vo.AppAfterSaleDeliveryReqVO;
import cn.iocoder.yudao.module.trade.controller.app.aftersale.vo.AppAfterSalePageReqVO;
import cn.iocoder.yudao.module.trade.controller.app.aftersale.vo.AppAfterSaleRespVO;
import cn.iocoder.yudao.module.trade.dal.dataobject.aftersale.AfterSaleDO;
import cn.iocoder.yudao.module.trade.service.aftersale.AfterSaleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "User App - trade after-sales.")
@RestController
@RequestMapping("/trade/after-sale")
@Validated
@Slf4j
public class AppAfterSaleController {

    @Resource
    private AfterSaleService afterSaleService;

    @GetMapping(value = "/page")
    @Operation(summary = "Get after-sales page.")
    public CommonResult<PageResult<AppAfterSaleRespVO>> getAfterSalePage(AppAfterSalePageReqVO pageReqVO) {
        PageResult<AfterSaleDO> pageResult = afterSaleService.getAfterSalePage(getLoginUserId(), pageReqVO);
        return success(BeanUtils.toBean(pageResult, AppAfterSaleRespVO.class));
    }

    @GetMapping(value = "/get")
    @Operation(summary = "Get after-sales order.")
    @Parameter(name = "id", description = "After-sales code.", required = true, example = "1")
    public CommonResult<AppAfterSaleRespVO> getAfterSale(@RequestParam("id") Long id) {
        AfterSaleDO afterSale = afterSaleService.getAfterSale(getLoginUserId(), id);
        return success(BeanUtils.toBean(afterSale, AppAfterSaleRespVO.class));
    }

    @PostMapping(value = "/create")
    @Operation(summary = "Apply please after-sales.")
    public CommonResult<Long> createAfterSale(@Valid @RequestBody AppAfterSaleCreateReqVO createReqVO) {
        return success(afterSaleService.createAfterSale(getLoginUserId(), createReqVO));
    }

    @PutMapping(value = "/delivery")
    @Operation(summary = "Return the goods.")
    public CommonResult<Boolean> deliveryAfterSale(@Valid @RequestBody AppAfterSaleDeliveryReqVO deliveryReqVO) {
        afterSaleService.deliveryAfterSale(getLoginUserId(), deliveryReqVO);
        return success(true);
    }

    @DeleteMapping(value = "/cancel")
    @Operation(summary = "Cancel after-sales.")
    @Parameter(name = "id", description = "After-sales code.", required = true, example = "1")
    public CommonResult<Boolean> cancelAfterSale(@RequestParam("id") Long id) {
        afterSaleService.cancelAfterSale(getLoginUserId(), id);
        return success(true);
    }

}
