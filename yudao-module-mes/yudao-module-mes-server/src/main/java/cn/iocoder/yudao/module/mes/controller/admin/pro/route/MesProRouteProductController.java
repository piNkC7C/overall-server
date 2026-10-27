package cn.iocoder.yudao.module.mes.controller.admin.pro.route;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.mes.controller.admin.pro.route.vo.product.MesProRouteProductRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.pro.route.vo.product.MesProRouteProductSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.item.MesMdItemDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.unitmeasure.MesMdUnitMeasureDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.pro.route.MesProRouteProductDO;
import cn.iocoder.yudao.module.mes.service.md.item.MesMdItemService;
import cn.iocoder.yudao.module.mes.service.md.unitmeasure.MesMdUnitMeasureService;
import cn.iocoder.yudao.module.mes.service.pro.route.MesProRouteProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertMap;

@Tag(name = "Admin - MES routing pathproduct.")
@RestController
@RequestMapping("/mes/pro/route-product")
@Validated
public class MesProRouteProductController {

    @Resource
    private MesProRouteProductService routeProductService;

    @Resource
    private MesMdItemService itemService;

    @Resource
    private MesMdUnitMeasureService unitMeasureService;

    @PostMapping("/create")
    @Operation(summary = "Createrouting pathproduct.")
    @PreAuthorize("@ss.hasPermission('mes:pro-route:update')")
    public CommonResult<Long> createRouteProduct(@Valid @RequestBody MesProRouteProductSaveReqVO createReqVO) {
        return success(routeProductService.createRouteProduct(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updaterouting pathproduct.")
    @PreAuthorize("@ss.hasPermission('mes:pro-route:update')")
    public CommonResult<Boolean> updateRouteProduct(@Valid @RequestBody MesProRouteProductSaveReqVO updateReqVO) {
        routeProductService.updateRouteProduct(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deleterouting pathproduct.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:pro-route:update')")
    public CommonResult<Boolean> deleteRouteProduct(@RequestParam("id") Long id) {
        routeProductService.deleteRouteProduct(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get routing pathproduct.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:pro-route:query')")
    public CommonResult<MesProRouteProductRespVO> getRouteProduct(@RequestParam("id") Long id) {
        MesProRouteProductDO routeProduct = routeProductService.getRouteProduct(id);
        return success(buildRouteProductRespVO(routeProduct));
    }

    @GetMapping("/list-by-route")
    @Operation(summary = "By routing path get product list.")
    @Parameter(name = "routeId", description = "Routing path code.", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('mes:pro-route:query')")
    public CommonResult<List<MesProRouteProductRespVO>> getRouteProductListByRoute(@RequestParam("routeId") Long routeId) {
        List<MesProRouteProductDO> list = routeProductService.getRouteProductListByRouteId(routeId);
        return success(buildRouteProductRespVOList(list));
    }

    // ==================== 拼接 VO ====================

    private List<MesProRouteProductRespVO> buildRouteProductRespVOList(List<MesProRouteProductDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // 1. batch get relation data
        Map<Long, MesMdItemDO> itemMap = itemService.getItemMap(
                convertSet(list, MesProRouteProductDO::getItemId));
        Map<Long, MesMdUnitMeasureDO> unitMap = unitMeasureService.getUnitMeasureMap(
                convertSet(itemMap.values(), MesMdItemDO::getUnitMeasureId));
        // 2. 拼接 VO
        return BeanUtils.toBean(list, MesProRouteProductRespVO.class, vo -> {
            MapUtils.findAndThen(itemMap, vo.getItemId(), item -> {
                vo.setItemCode(item.getCode()).setItemName(item.getName())
                        .setSpecification(item.getSpecification());
                MapUtils.findAndThen(unitMap, item.getUnitMeasureId(),
                        unit -> vo.setUnitName(unit.getName()));
            });
        });
    }

    private MesProRouteProductRespVO buildRouteProductRespVO(MesProRouteProductDO routeProduct) {
        if (routeProduct == null) {
            return null;
        }
        return buildRouteProductRespVOList(ListUtil.of(routeProduct)).get(0);
    }

}
