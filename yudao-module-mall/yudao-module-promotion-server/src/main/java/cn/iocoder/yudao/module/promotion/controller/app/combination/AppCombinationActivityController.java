package cn.iocoder.yudao.module.promotion.controller.app.combination;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.product.api.spu.ProductSpuApi;
import cn.iocoder.yudao.module.product.api.spu.dto.ProductSpuRespDTO;
import cn.iocoder.yudao.module.promotion.controller.app.combination.vo.activity.AppCombinationActivityDetailRespVO;
import cn.iocoder.yudao.module.promotion.controller.app.combination.vo.activity.AppCombinationActivityRespVO;
import cn.iocoder.yudao.module.promotion.convert.combination.CombinationActivityConvert;
import cn.iocoder.yudao.module.promotion.dal.dataobject.combination.CombinationActivityDO;
import cn.iocoder.yudao.module.promotion.dal.dataobject.combination.CombinationProductDO;
import cn.iocoder.yudao.module.promotion.service.combination.CombinationActivityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;

@Tag(name = "User APP - group buy campaign.")
@RestController
@RequestMapping("/promotion/combination-activity")
@Validated
public class AppCombinationActivityController {

    @Resource
    private CombinationActivityService activityService;

    @Resource
    private ProductSpuApi spuApi;

    @GetMapping("/page")
    @Operation(summary = "Get group buy campaign page.")
    @PermitAll
    public CommonResult<PageResult<AppCombinationActivityRespVO>> getCombinationActivityPage(PageParam pageParam) {
        PageResult<CombinationActivityDO> pageResult = activityService.getCombinationActivityPage(pageParam);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(PageResult.empty(pageResult.getTotal()));
        }
        // 拼接返回
        List<CombinationProductDO> productList = activityService.getCombinationProductListByActivityIds(
                convertList(pageResult.getList(), CombinationActivityDO::getId));
        List<ProductSpuRespDTO> spuList = spuApi.getSpuList(convertList(pageResult.getList(), CombinationActivityDO::getSpuId)).getCheckedData();
        return success(CombinationActivityConvert.INSTANCE.convertAppPage(pageResult, productList, spuList));
    }

    @GetMapping("/list-by-ids")
    @Operation(summary = "Get group-buy campaign list, based on campaign IDs.")
    @Parameter(name = "ids", description = "Campaign ID list.", required = true, example = "[1024, 1025]")
    @PermitAll
    public CommonResult<List<AppCombinationActivityRespVO>> getCombinationActivityListByIds(@RequestParam("ids") List<Long> ids) {
        // 1. get enable campaign list
        List<CombinationActivityDO> activityList = activityService.getCombinationActivityListByIds(ids);
        activityList.removeIf(activity -> CommonStatusEnum.isDisable(activity.getStatus()));
        if (CollUtil.isEmpty(activityList)) {
            return success(Collections.emptyList());
        }
        // 2. 拼接返回
        List<CombinationProductDO> productList = activityService.getCombinationProductListByActivityIds(
                convertList(activityList, CombinationActivityDO::getId));
        List<ProductSpuRespDTO> spuList = spuApi.getSpuList(convertList(activityList, CombinationActivityDO::getSpuId)).getCheckedData();
        return success(CombinationActivityConvert.INSTANCE.convertAppList(activityList, productList, spuList));
    }

    @GetMapping("/get-detail")
    @Operation(summary = "Get group buy campaigndetail.")
    @Parameter(name = "id", description = "Campaign code.", required = true, example = "1024")
    @PermitAll
    public CommonResult<AppCombinationActivityDetailRespVO> getCombinationActivityDetail(@RequestParam("id") Long id) {
        // 1. get campaign
        CombinationActivityDO activity = activityService.getCombinationActivity(id);
        if (activity == null
                || ObjectUtil.equal(activity.getStatus(), CommonStatusEnum.DISABLE.getStatus())) {
            return success(null);
        }

        // 2. get campaignproduct
        List<CombinationProductDO> products = activityService.getCombinationProductsByActivityId(activity.getId());
        return success(CombinationActivityConvert.INSTANCE.convert3(activity, products));
    }

}
