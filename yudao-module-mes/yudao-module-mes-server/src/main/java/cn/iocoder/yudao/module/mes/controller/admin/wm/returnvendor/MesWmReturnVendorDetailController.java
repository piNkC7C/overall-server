package cn.iocoder.yudao.module.mes.controller.admin.wm.returnvendor;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.mes.controller.admin.wm.returnvendor.vo.detail.MesWmReturnVendorDetailRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.wm.returnvendor.vo.detail.MesWmReturnVendorDetailSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.item.MesMdItemDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.unitmeasure.MesMdUnitMeasureDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.wm.returnvendor.MesWmReturnVendorDetailDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.wm.warehouse.MesWmWarehouseAreaDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.wm.warehouse.MesWmWarehouseDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.wm.warehouse.MesWmWarehouseLocationDO;
import cn.iocoder.yudao.module.mes.service.md.item.MesMdItemService;
import cn.iocoder.yudao.module.mes.service.md.unitmeasure.MesMdUnitMeasureService;
import cn.iocoder.yudao.module.mes.service.wm.returnvendor.MesWmReturnVendorDetailService;
import cn.iocoder.yudao.module.mes.service.wm.warehouse.MesWmWarehouseAreaService;
import cn.iocoder.yudao.module.mes.service.wm.warehouse.MesWmWarehouseLocationService;
import cn.iocoder.yudao.module.mes.service.wm.warehouse.MesWmWarehouseService;
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

@Tag(name = "Admin - MES supplier return detail.")
@RestController
@RequestMapping("/mes/wm/return-vendor-detail")
@Validated
public class MesWmReturnVendorDetailController {

    @Resource
    private MesWmReturnVendorDetailService returnVendorDetailService;

    @Resource
    private MesMdItemService itemService;

    @Resource
    private MesMdUnitMeasureService unitMeasureService;

    @Resource
    private MesWmWarehouseService warehouseService;

    @Resource
    private MesWmWarehouseLocationService locationService;

    @Resource
    private MesWmWarehouseAreaService areaService;

    @PostMapping("/create")
    @Operation(summary = "Createsupplier return detail.")
    @PreAuthorize("@ss.hasPermission('mes:wm-return-vendor:create')")
    public CommonResult<Long> createReturnVendorDetail(@Valid @RequestBody MesWmReturnVendorDetailSaveReqVO createReqVO) {
        return success(returnVendorDetailService.createReturnVendorDetail(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Edit supplier return detail.")
    @PreAuthorize("@ss.hasPermission('mes:wm-return-vendor:update')")
    public CommonResult<Boolean> updateReturnVendorDetail(@Valid @RequestBody MesWmReturnVendorDetailSaveReqVO updateReqVO) {
        returnVendorDetailService.updateReturnVendorDetail(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletesupplier return detail.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:wm-return-vendor:delete')")
    public CommonResult<Boolean> deleteReturnVendorDetail(@RequestParam("id") Long id) {
        returnVendorDetailService.deleteReturnVendorDetail(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get supplier return detail.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:wm-return-vendor:query')")
    public CommonResult<MesWmReturnVendorDetailRespVO> getReturnVendorDetail(@RequestParam("id") Long id) {
        MesWmReturnVendorDetailDO detail = returnVendorDetailService.getReturnVendorDetail(id);
        if (detail == null) {
            return success(null);
        }
        return success(buildRespVOList(Collections.singletonList(detail)).get(0));
    }

    @GetMapping("/list-by-line")
    @Operation(summary = "Get Supplier return detail list (by line ID).")
    @Parameter(name = "lineId", description = "Line code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:wm-return-vendor:query')")
    public CommonResult<List<MesWmReturnVendorDetailRespVO>> getReturnVendorDetailListByLineId(
            @RequestParam("lineId") Long lineId) {
        List<MesWmReturnVendorDetailDO> list = returnVendorDetailService.getReturnVendorDetailListByLineId(lineId);
        return success(buildRespVOList(list));
    }

    // ==================== 拼接 VO ====================

    private List<MesWmReturnVendorDetailRespVO> buildRespVOList(List<MesWmReturnVendorDetailDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // 1. get relation data
        Map<Long, MesMdItemDO> itemMap = itemService.getItemMap(
                convertSet(list, MesWmReturnVendorDetailDO::getItemId));
        Map<Long, MesMdUnitMeasureDO> unitMeasureMap = unitMeasureService.getUnitMeasureMap(
                convertSet(itemMap.values(), MesMdItemDO::getUnitMeasureId));
        Map<Long, MesWmWarehouseDO> warehouseMap = warehouseService.getWarehouseMap(
                convertSet(list, MesWmReturnVendorDetailDO::getWarehouseId));
        Map<Long, MesWmWarehouseLocationDO> locationMap = locationService.getWarehouseLocationMap(
                convertSet(list, MesWmReturnVendorDetailDO::getLocationId));
        Map<Long, MesWmWarehouseAreaDO> areaMap = areaService.getWarehouseAreaMap(
                convertSet(list, MesWmReturnVendorDetailDO::getAreaId));
        // 2. 构建结果
        return BeanUtils.toBean(list, MesWmReturnVendorDetailRespVO.class, vo -> {
            MapUtils.findAndThen(itemMap, vo.getItemId(), item -> {
                vo.setItemCode(item.getCode());
                vo.setItemName(item.getName());
                vo.setSpecification(item.getSpecification());
                MapUtils.findAndThen(unitMeasureMap, item.getUnitMeasureId(),
                        unitMeasure -> vo.setUnitMeasureName(unitMeasure.getName()));
            });
            MapUtils.findAndThen(warehouseMap, vo.getWarehouseId(),
                    warehouse -> vo.setWarehouseName(warehouse.getName()));
            MapUtils.findAndThen(locationMap, vo.getLocationId(),
                    location -> vo.setLocationName(location.getName()));
            MapUtils.findAndThen(areaMap, vo.getAreaId(),
                    area -> vo.setAreaName(area.getName()));
        });
    }

}
