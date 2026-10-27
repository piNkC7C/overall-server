package cn.iocoder.yudao.module.mes.controller.admin.wm.warehouse;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.mes.controller.admin.wm.warehouse.vo.MesWmWarehousePageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.wm.warehouse.vo.MesWmWarehouseRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.wm.warehouse.vo.MesWmWarehouseSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.wm.warehouse.MesWmWarehouseDO;
import cn.iocoder.yudao.module.mes.service.wm.warehouse.MesWmWarehouseService;
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

@Tag(name = "Admin - MES warehouse.")
@RestController
@RequestMapping("/mes/wm/warehouse")
@Validated
public class MesWmWarehouseController {

    @Resource
    private MesWmWarehouseService warehouseService;

    @PostMapping("/create")
    @Operation(summary = "Createwarehouse.")
    @PreAuthorize("@ss.hasPermission('mes:wm-warehouse:create')")
    public CommonResult<Long> createWarehouse(@Valid @RequestBody MesWmWarehouseSaveReqVO createReqVO) {
        return success(warehouseService.createWarehouse(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updatewarehouse.")
    @PreAuthorize("@ss.hasPermission('mes:wm-warehouse:update')")
    public CommonResult<Boolean> updateWarehouse(@Valid @RequestBody MesWmWarehouseSaveReqVO updateReqVO) {
        warehouseService.updateWarehouse(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletewarehouse.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:wm-warehouse:delete')")
    public CommonResult<Boolean> deleteWarehouse(@RequestParam("id") Long id) {
        warehouseService.deleteWarehouse(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get warehouse.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:wm-warehouse:query')")
    public CommonResult<MesWmWarehouseRespVO> getWarehouse(@RequestParam("id") Long id) {
        MesWmWarehouseDO warehouse = warehouseService.getWarehouse(id);
        return success(BeanUtils.toBean(warehouse, MesWmWarehouseRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get warehouse page.")
    @PreAuthorize("@ss.hasPermission('mes:wm-warehouse:query')")
    public CommonResult<PageResult<MesWmWarehouseRespVO>> getWarehousePage(@Valid MesWmWarehousePageReqVO pageReqVO) {
        PageResult<MesWmWarehouseDO> pageResult = warehouseService.getWarehousePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, MesWmWarehouseRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get warehouse simple list.", description = "Used by frontend dropdowns.")
    public CommonResult<List<MesWmWarehouseRespVO>> getWarehouseSimpleList() {
        List<MesWmWarehouseDO> list = warehouseService.getWarehouseList();
        return success(BeanUtils.toBean(list, MesWmWarehouseRespVO.class));
    }

}
