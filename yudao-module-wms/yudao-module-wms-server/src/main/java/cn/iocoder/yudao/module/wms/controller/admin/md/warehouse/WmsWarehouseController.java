package cn.iocoder.yudao.module.wms.controller.admin.md.warehouse;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.wms.controller.admin.md.warehouse.vo.WmsWarehousePageReqVO;
import cn.iocoder.yudao.module.wms.controller.admin.md.warehouse.vo.WmsWarehouseRespVO;
import cn.iocoder.yudao.module.wms.controller.admin.md.warehouse.vo.WmsWarehouseSaveReqVO;
import cn.iocoder.yudao.module.wms.dal.dataobject.md.warehouse.WmsWarehouseDO;
import cn.iocoder.yudao.module.wms.service.md.warehouse.WmsWarehouseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - WMS warehouse.")
@RestController
@RequestMapping("/wms/warehouse")
@Validated
public class WmsWarehouseController {

    @Resource
    private WmsWarehouseService warehouseService;

    @PostMapping("/create")
    @Operation(summary = "Createwarehouse.")
    @PreAuthorize("@ss.hasPermission('wms:warehouse:create')")
    public CommonResult<Long> createWarehouse(@Valid @RequestBody WmsWarehouseSaveReqVO createReqVO) {
        return success(warehouseService.createWarehouse(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updatewarehouse.")
    @PreAuthorize("@ss.hasPermission('wms:warehouse:update')")
    public CommonResult<Boolean> updateWarehouse(@Valid @RequestBody WmsWarehouseSaveReqVO updateReqVO) {
        warehouseService.updateWarehouse(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletewarehouse.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('wms:warehouse:delete')")
    public CommonResult<Boolean> deleteWarehouse(@RequestParam("id") Long id) {
        warehouseService.deleteWarehouse(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get warehouse.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('wms:warehouse:query')")
    public CommonResult<WmsWarehouseRespVO> getWarehouse(@RequestParam("id") Long id) {
        WmsWarehouseDO warehouse = warehouseService.getWarehouse(id);
        return success(BeanUtils.toBean(warehouse, WmsWarehouseRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get warehouse page.")
    @PreAuthorize("@ss.hasPermission('wms:warehouse:query')")
    public CommonResult<PageResult<WmsWarehouseRespVO>> getWarehousePage(@Valid WmsWarehousePageReqVO pageReqVO) {
        PageResult<WmsWarehouseDO> pageResult = warehouseService.getWarehousePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, WmsWarehouseRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get warehouse simple list.", description = "Used by frontend dropdowns.")
    @PreAuthorize("@ss.hasPermission('wms:warehouse:query')")
    public CommonResult<List<WmsWarehouseRespVO>> getWarehouseSimpleList() {
        List<WmsWarehouseDO> list = warehouseService.getWarehouseList();
        return success(BeanUtils.toBean(list, WmsWarehouseRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Exportwarehouse Excel.")
    @PreAuthorize("@ss.hasPermission('wms:warehouse:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportWarehouseExcel(@Valid WmsWarehousePageReqVO pageReqVO,
                                     HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<WmsWarehouseDO> list = warehouseService.getWarehousePage(pageReqVO).getList();
        ExcelUtils.write(response, "Warehouses.xls", "Data", WmsWarehouseRespVO.class,
                BeanUtils.toBean(list, WmsWarehouseRespVO.class));
    }

}
