package cn.iocoder.yudao.module.erp.controller.admin.stock;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.erp.controller.admin.stock.vo.warehouse.ErpWarehousePageReqVO;
import cn.iocoder.yudao.module.erp.controller.admin.stock.vo.warehouse.ErpWarehouseRespVO;
import cn.iocoder.yudao.module.erp.controller.admin.stock.vo.warehouse.ErpWarehouseSaveReqVO;
import cn.iocoder.yudao.module.erp.dal.dataobject.stock.ErpWarehouseDO;
import cn.iocoder.yudao.module.erp.service.stock.ErpWarehouseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
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
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;

@Tag(name = "Admin - ERP warehouse.")
@RestController
@RequestMapping("/erp/warehouse")
@Validated
public class ErpWarehouseController {

    @Resource
    private ErpWarehouseService warehouseService;

    @PostMapping("/create")
    @Operation(summary = "Createwarehouse.")
    @PreAuthorize("@ss.hasPermission('erp:warehouse:create')")
    public CommonResult<Long> createWarehouse(@Valid @RequestBody ErpWarehouseSaveReqVO createReqVO) {
        return success(warehouseService.createWarehouse(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updatewarehouse.")
    @PreAuthorize("@ss.hasPermission('erp:warehouse:update')")
    public CommonResult<Boolean> updateWarehouse(@Valid @RequestBody ErpWarehouseSaveReqVO updateReqVO) {
        warehouseService.updateWarehouse(updateReqVO);
        return success(true);
    }

    @PutMapping("/update-default-status")
    @Operation(summary = "Updatewarehouse default status.")
    @Parameters({
            @Parameter(name = "id", description = "Code.", required = true),
            @Parameter(name = "status", description = "Status.", required = true)
    })
    public CommonResult<Boolean> updateWarehouseDefaultStatus(@RequestParam("id") Long id,
                                                              @RequestParam("defaultStatus") Boolean defaultStatus) {
        warehouseService.updateWarehouseDefaultStatus(id, defaultStatus);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletewarehouse.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('erp:warehouse:delete')")
    public CommonResult<Boolean> deleteWarehouse(@RequestParam("id") Long id) {
        warehouseService.deleteWarehouse(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get warehouse.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('erp:warehouse:query')")
    public CommonResult<ErpWarehouseRespVO> getWarehouse(@RequestParam("id") Long id) {
        ErpWarehouseDO warehouse = warehouseService.getWarehouse(id);
        return success(BeanUtils.toBean(warehouse, ErpWarehouseRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get warehouse page.")
    @PreAuthorize("@ss.hasPermission('erp:warehouse:query')")
    public CommonResult<PageResult<ErpWarehouseRespVO>> getWarehousePage(@Valid ErpWarehousePageReqVO pageReqVO) {
        PageResult<ErpWarehouseDO> pageResult = warehouseService.getWarehousePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ErpWarehouseRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get warehouse simple list.", description = "Only enabled warehouses. Used for dropdowns.")
    public CommonResult<List<ErpWarehouseRespVO>> getWarehouseSimpleList() {
        List<ErpWarehouseDO> list = warehouseService.getWarehouseListByStatus(CommonStatusEnum.ENABLE.getStatus());
        return success(convertList(list, warehouse -> new ErpWarehouseRespVO().setId(warehouse.getId())
                .setName(warehouse.getName()).setDefaultStatus(warehouse.getDefaultStatus())));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Exportwarehouse Excel.")
    @PreAuthorize("@ss.hasPermission('erp:warehouse:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportWarehouseExcel(@Valid ErpWarehousePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ErpWarehouseDO> list = warehouseService.getWarehousePage(pageReqVO).getList();
        // Export Excel
        ExcelUtils.write(response, "Warehouses.xls", "Data", ErpWarehouseRespVO.class,
                        BeanUtils.toBean(list, ErpWarehouseRespVO.class));
    }

}