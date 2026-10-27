package cn.iocoder.yudao.module.mes.controller.admin.wm.productreceipt;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.mes.controller.admin.wm.productreceipt.vo.MesWmProductReceiptPageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.wm.productreceipt.vo.MesWmProductReceiptRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.wm.productreceipt.vo.MesWmProductReceiptSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.item.MesMdItemDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.unitmeasure.MesMdUnitMeasureDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.pro.workorder.MesProWorkOrderDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.wm.productreceipt.MesWmProductReceiptDO;
import cn.iocoder.yudao.module.mes.service.md.item.MesMdItemService;
import cn.iocoder.yudao.module.mes.service.md.unitmeasure.MesMdUnitMeasureService;
import cn.iocoder.yudao.module.mes.service.pro.workorder.MesProWorkOrderService;
import cn.iocoder.yudao.module.mes.service.wm.productreceipt.MesWmProductReceiptService;
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
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;

@Tag(name = "Admin - MES product receiving order.")
@RestController
@RequestMapping("/mes/wm/product-receipt")
@Validated
public class MesWmProductReceiptController {

    @Resource
    private MesWmProductReceiptService productReceiptService;

    @Resource
    private MesProWorkOrderService workOrderService;

    @Resource
    private MesMdItemService itemService;

    @Resource
    private MesMdUnitMeasureService unitMeasureService;

    @PostMapping("/create")
    @Operation(summary = "Createproduct receiving order.")
    @PreAuthorize("@ss.hasPermission('mes:wm-product-receipt:create')")
    public CommonResult<Long> createProductReceipt(@Valid @RequestBody MesWmProductReceiptSaveReqVO createReqVO) {
        return success(productReceiptService.createProductReceipt(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Edit product receiving order.")
    @PreAuthorize("@ss.hasPermission('mes:wm-product-receipt:update')")
    public CommonResult<Boolean> updateProductReceipt(@Valid @RequestBody MesWmProductReceiptSaveReqVO updateReqVO) {
        productReceiptService.updateProductReceipt(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deleteproduct receiving order.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:wm-product-receipt:delete')")
    public CommonResult<Boolean> deleteProductReceipt(@RequestParam("id") Long id) {
        productReceiptService.deleteProductReceipt(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get product receiving order.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:wm-product-receipt:query')")
    public CommonResult<MesWmProductReceiptRespVO> getProductReceipt(@RequestParam("id") Long id) {
        MesWmProductReceiptDO receipt = productReceiptService.getProductReceipt(id);
        if (receipt == null) {
            return success(null);
        }
        return success(buildRespVOList(Collections.singletonList(receipt)).get(0));
    }

    @GetMapping("/page")
    @Operation(summary = "Get product receiving order page.")
    @PreAuthorize("@ss.hasPermission('mes:wm-product-receipt:query')")
    public CommonResult<PageResult<MesWmProductReceiptRespVO>> getProductReceiptPage(
            @Valid MesWmProductReceiptPageReqVO pageReqVO) {
        PageResult<MesWmProductReceiptDO> pageResult = productReceiptService.getProductReceiptPage(pageReqVO);
        return success(new PageResult<>(buildRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Exportproduct receiving order Excel.")
    @PreAuthorize("@ss.hasPermission('mes:wm-product-receipt:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportProductReceiptExcel(@Valid MesWmProductReceiptPageReqVO pageReqVO,
                                        HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        PageResult<MesWmProductReceiptDO> pageResult = productReceiptService.getProductReceiptPage(pageReqVO);
        ExcelUtils.write(response, "Product Receipt Orders.xls", "Data", MesWmProductReceiptRespVO.class,
                buildRespVOList(pageResult.getList()));
    }

    @PutMapping("/submit")
    @Operation(summary = "Submit product receiving order.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:wm-product-receipt:update')")
    public CommonResult<Boolean> submitProductReceipt(@RequestParam("id") Long id) {
        productReceiptService.submitProductReceipt(id);
        return success(true);
    }

    @PutMapping("/stock")
    @Operation(summary = "Execute put away.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:wm-product-receipt:update')")
    public CommonResult<Boolean> stockProductReceipt(@RequestParam("id") Long id) {
        productReceiptService.stockProductReceipt(id);
        return success(true);
    }

    @PutMapping("/finish")
    @Operation(summary = "Execute inbound.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:wm-product-receipt:finish')")
    public CommonResult<Boolean> finishProductReceipt(@RequestParam("id") Long id) {
        productReceiptService.finishProductReceipt(id);
        return success(true);
    }

    @PutMapping("/cancel")
    @Operation(summary = "Cancelproduct receiving order.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:wm-product-receipt:update')")
    public CommonResult<Boolean> cancelProductReceipt(@RequestParam("id") Long id) {
        productReceiptService.cancelProductReceipt(id);
        return success(true);
    }

    @GetMapping("/check-quantity")
    @Operation(summary = "Validate product-receipt line quantities.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:wm-product-receipt:query')")
    public CommonResult<Boolean> checkProductReceiptQuantity(@RequestParam("id") Long id) {
        return success(productReceiptService.checkProductReceiptQuantity(id));
    }

    // ==================== 拼接 VO ====================

    private List<MesWmProductReceiptRespVO> buildRespVOList(List<MesWmProductReceiptDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // 1. get relation data
        Map<Long, MesProWorkOrderDO> workOrderMap = workOrderService.getWorkOrderMap(
                convertSet(list, MesWmProductReceiptDO::getWorkOrderId));
        Map<Long, MesMdItemDO> itemMap = itemService.getItemMap(
                convertSet(list, MesWmProductReceiptDO::getItemId));
        Map<Long, MesMdUnitMeasureDO> unitMeasureMap = unitMeasureService.getUnitMeasureMap(
                convertSet(itemMap.values(), MesMdItemDO::getUnitMeasureId));
        // 2. 构建结果
        return BeanUtils.toBean(list, MesWmProductReceiptRespVO.class, vo -> {
            MapUtils.findAndThen(workOrderMap, vo.getWorkOrderId(),
                    workOrder -> vo.setWorkOrderCode(workOrder.getCode()));
            MapUtils.findAndThen(itemMap, vo.getItemId(), item -> {
                vo.setItemCode(item.getCode()).setItemName(item.getName()).setSpecification(item.getSpecification());
                MapUtils.findAndThen(unitMeasureMap, item.getUnitMeasureId(),
                        unitMeasure -> vo.setUnitMeasureName(unitMeasure.getName()));
            });
        });
    }

}
