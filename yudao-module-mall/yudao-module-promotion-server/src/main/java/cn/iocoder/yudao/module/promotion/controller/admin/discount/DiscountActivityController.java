package cn.iocoder.yudao.module.promotion.controller.admin.discount;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.promotion.controller.admin.discount.vo.DiscountActivityCreateReqVO;
import cn.iocoder.yudao.module.promotion.controller.admin.discount.vo.DiscountActivityPageReqVO;
import cn.iocoder.yudao.module.promotion.controller.admin.discount.vo.DiscountActivityRespVO;
import cn.iocoder.yudao.module.promotion.controller.admin.discount.vo.DiscountActivityUpdateReqVO;
import cn.iocoder.yudao.module.promotion.convert.discount.DiscountActivityConvert;
import cn.iocoder.yudao.module.promotion.dal.dataobject.discount.DiscountActivityDO;
import cn.iocoder.yudao.module.promotion.dal.dataobject.discount.DiscountProductDO;
import cn.iocoder.yudao.module.promotion.service.discount.DiscountActivityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;

@Tag(name = "Admin - limited-time discount campaign.")
@RestController
@RequestMapping("/promotion/discount-activity")
@Validated
public class DiscountActivityController {

    @Resource
    private DiscountActivityService discountActivityService;

    @PostMapping("/create")
    @Operation(summary = "Create limited-time discount campaign.")
    @PreAuthorize("@ss.hasPermission('promotion:discount-activity:create')")
    public CommonResult<Long> createDiscountActivity(@Valid @RequestBody DiscountActivityCreateReqVO createReqVO) {
        return success(discountActivityService.createDiscountActivity(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update limited-time discount campaign.")
    @PreAuthorize("@ss.hasPermission('promotion:discount-activity:update')")
    public CommonResult<Boolean> updateDiscountActivity(@Valid @RequestBody DiscountActivityUpdateReqVO updateReqVO) {
        discountActivityService.updateDiscountActivity(updateReqVO);
        return success(true);
    }

    @PutMapping("/close")
    @Operation(summary = "Close limited-time discount campaign.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('promotion:discount-activity:close')")
    public CommonResult<Boolean> closeRewardActivity(@RequestParam("id") Long id) {
        discountActivityService.closeDiscountActivity(id);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete limited-time discount campaign.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('promotion:discount-activity:delete')")
    public CommonResult<Boolean> deleteDiscountActivity(@RequestParam("id") Long id) {
        discountActivityService.deleteDiscountActivity(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get limited-time discount campaign.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('promotion:discount-activity:query')")
    public CommonResult<DiscountActivityRespVO> getDiscountActivity(@RequestParam("id") Long id) {
        DiscountActivityDO discountActivity = discountActivityService.getDiscountActivity(id);
        if (discountActivity == null) {
            return success(null);
        }
        // 拼接结果
        List<DiscountProductDO> discountProducts = discountActivityService.getDiscountProductsByActivityId(id);
        return success(DiscountActivityConvert.INSTANCE.convert(discountActivity, discountProducts));
    }

    @GetMapping("/page")
    @Operation(summary = "Get limited-time discount campaign page.")
    @PreAuthorize("@ss.hasPermission('promotion:discount-activity:query')")
    public CommonResult<PageResult<DiscountActivityRespVO>> getDiscountActivityPage(@Valid DiscountActivityPageReqVO pageVO) {
        PageResult<DiscountActivityDO> pageResult = discountActivityService.getDiscountActivityPage(pageVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(PageResult.empty(pageResult.getTotal()));
        }

        // 拼接数据
        List<DiscountProductDO> products = discountActivityService.getDiscountProductsByActivityId(
                convertSet(pageResult.getList(), DiscountActivityDO::getId));
        return success(DiscountActivityConvert.INSTANCE.convertPage(pageResult, products));
    }

}
