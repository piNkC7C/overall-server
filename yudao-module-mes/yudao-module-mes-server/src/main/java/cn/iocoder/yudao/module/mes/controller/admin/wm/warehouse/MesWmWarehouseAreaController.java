package cn.iocoder.yudao.module.mes.controller.admin.wm.warehouse;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.mes.controller.admin.wm.warehouse.vo.area.MesWmWarehouseAreaPageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.wm.warehouse.vo.area.MesWmWarehouseAreaRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.wm.warehouse.vo.area.MesWmWarehouseAreaSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.wm.warehouse.MesWmWarehouseAreaDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.wm.warehouse.MesWmWarehouseLocationDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.wm.warehouse.MesWmWarehouseDO;
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

@Tag(name = "Admin - MES bin.")
@RestController
@RequestMapping("/mes/wm/warehouse-area")
@Validated
public class MesWmWarehouseAreaController {

    @Resource
    private MesWmWarehouseAreaService areaService;

    @Resource
    private MesWmWarehouseLocationService locationService;

    @Resource
    private MesWmWarehouseService warehouseService;

    @PostMapping("/create")
    @Operation(summary = "Createbin.")
    @PreAuthorize("@ss.hasPermission('mes:wm-warehouse:create')")
    public CommonResult<Long> createWarehouseArea(@Valid @RequestBody MesWmWarehouseAreaSaveReqVO createReqVO) {
        return success(areaService.createWarehouseArea(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updatebin.")
    @PreAuthorize("@ss.hasPermission('mes:wm-warehouse:update')")
    public CommonResult<Boolean> updateWarehouseArea(@Valid @RequestBody MesWmWarehouseAreaSaveReqVO updateReqVO) {
        areaService.updateWarehouseArea(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletebin.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:wm-warehouse:delete')")
    public CommonResult<Boolean> deleteWarehouseArea(@RequestParam("id") Long id) {
        areaService.deleteWarehouseArea(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get bin.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:wm-warehouse:query')")
    public CommonResult<MesWmWarehouseAreaRespVO> getWarehouseArea(@RequestParam("id") Long id) {
        MesWmWarehouseAreaDO area = areaService.getWarehouseArea(id);
        if (area == null) {
            return success(null);
        }
        return success(buildWarehouseAreaRespVOList(Collections.singletonList(area)).get(0));
    }

    @GetMapping("/page")
    @Operation(summary = "Get bin page.")
    @PreAuthorize("@ss.hasPermission('mes:wm-warehouse:query')")
    public CommonResult<PageResult<MesWmWarehouseAreaRespVO>> getWarehouseAreaPage(@Valid MesWmWarehouseAreaPageReqVO pageReqVO) {
        PageResult<MesWmWarehouseAreaDO> pageResult = areaService.getWarehouseAreaPage(pageReqVO);
        return success(new PageResult<>(buildWarehouseAreaRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get bin simple list.", description = "Can filter by zone.")
    public CommonResult<List<MesWmWarehouseAreaRespVO>> getWarehouseAreaSimpleList(
            @Parameter(name = "locationId", description = "Zone code.") @RequestParam(value = "locationId", required = false) Long locationId) {
        List<MesWmWarehouseAreaDO> list = areaService.getWarehouseAreaList(locationId);
        return success(buildWarehouseAreaRespVOList(list));
    }

    // ==================== 拼接 VO ====================

    /**
     * 批量构建库位响应 VO 列表（填充库区、仓库信息）
     *
     * @param list 库位列表
     * @return 响应 VO 列表
     */
    private List<MesWmWarehouseAreaRespVO> buildWarehouseAreaRespVOList(List<MesWmWarehouseAreaDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // 1. get zone info
        Map<Long, MesWmWarehouseLocationDO> locationMap = locationService.getWarehouseLocationMap(
                convertSet(list, MesWmWarehouseAreaDO::getLocationId));
        Map<Long, MesWmWarehouseDO> warehouseMap = warehouseService.getWarehouseMap(
                convertSet(locationMap.values(), MesWmWarehouseLocationDO::getWarehouseId));
        // 2. 构建结果
        return BeanUtils.toBean(list, MesWmWarehouseAreaRespVO.class, vo -> {
            MapUtils.findAndThen(locationMap, vo.getLocationId(), location -> {
                vo.setLocationName(location.getName());
                vo.setWarehouseId(location.getWarehouseId());
                MapUtils.findAndThen(warehouseMap, location.getWarehouseId(), warehouse -> vo.setWarehouseName(warehouse.getName()));
            });
        });
    }

}
