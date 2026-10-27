package cn.iocoder.yudao.module.erp.controller.admin.stock;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.erp.controller.admin.product.vo.product.ErpProductRespVO;
import cn.iocoder.yudao.module.erp.controller.admin.stock.vo.in.ErpStockInPageReqVO;
import cn.iocoder.yudao.module.erp.controller.admin.stock.vo.in.ErpStockInRespVO;
import cn.iocoder.yudao.module.erp.controller.admin.stock.vo.in.ErpStockInSaveReqVO;
import cn.iocoder.yudao.module.erp.dal.dataobject.purchase.ErpSupplierDO;
import cn.iocoder.yudao.module.erp.dal.dataobject.stock.ErpStockDO;
import cn.iocoder.yudao.module.erp.dal.dataobject.stock.ErpStockInDO;
import cn.iocoder.yudao.module.erp.dal.dataobject.stock.ErpStockInItemDO;
import cn.iocoder.yudao.module.erp.service.product.ErpProductService;
import cn.iocoder.yudao.module.erp.service.purchase.ErpSupplierService;
import cn.iocoder.yudao.module.erp.service.stock.ErpStockInService;
import cn.iocoder.yudao.module.erp.service.stock.ErpStockService;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import cn.iocoder.yudao.module.system.api.user.dto.AdminUserRespDTO;
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
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertMultiMap;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;

@Tag(name = "Admin - ERP other inbound order.")
@RestController
@RequestMapping("/erp/stock-in")
@Validated
public class ErpStockInController {

    @Resource
    private ErpStockInService stockInService;
    @Resource
    private ErpStockService stockService;
    @Resource
    private ErpProductService productService;
    @Resource
    private ErpSupplierService supplierService;

    @Resource
    private AdminUserApi adminUserApi;

    @PostMapping("/create")
    @Operation(summary = "Create other inbound order.")
    @PreAuthorize("@ss.hasPermission('erp:stock-in:create')")
    public CommonResult<Long> createStockIn(@Valid @RequestBody ErpStockInSaveReqVO createReqVO) {
        return success(stockInService.createStockIn(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update other inbound order.")
    @PreAuthorize("@ss.hasPermission('erp:stock-in:update')")
    public CommonResult<Boolean> updateStockIn(@Valid @RequestBody ErpStockInSaveReqVO updateReqVO) {
        stockInService.updateStockIn(updateReqVO);
        return success(true);
    }

    @PutMapping("/update-status")
    @Operation(summary = "Update other inbound order status.")
    @PreAuthorize("@ss.hasPermission('erp:stock-in:update-status')")
    public CommonResult<Boolean> updateStockInStatus(@RequestParam("id") Long id,
                                                     @RequestParam("status") Integer status) {
        stockInService.updateStockInStatus(id, status);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete other inbound order.")
    @Parameter(name = "ids", description = "ID list.", required = true)
    @PreAuthorize("@ss.hasPermission('erp:stock-in:delete')")
    public CommonResult<Boolean> deleteStockIn(@RequestParam("ids") List<Long> ids) {
        stockInService.deleteStockIn(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get other inbound order.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('erp:stock-in:query')")
    public CommonResult<ErpStockInRespVO> getStockIn(@RequestParam("id") Long id) {
        ErpStockInDO stockIn = stockInService.getStockIn(id);
        if (stockIn == null) {
            return success(null);
        }
        List<ErpStockInItemDO> stockInItemList = stockInService.getStockInItemListByInId(id);
        Map<Long, ErpProductRespVO> productMap = productService.getProductVOMap(
                convertSet(stockInItemList, ErpStockInItemDO::getProductId));
        return success(BeanUtils.toBean(stockIn, ErpStockInRespVO.class, stockInVO ->
                stockInVO.setItems(BeanUtils.toBean(stockInItemList, ErpStockInRespVO.Item.class, item -> {
                    ErpStockDO stock = stockService.getStock(item.getProductId(), item.getWarehouseId());
                    item.setStockCount(stock != null ? stock.getCount() : BigDecimal.ZERO);
                    MapUtils.findAndThen(productMap, item.getProductId(), product -> item.setProductName(product.getName())
                            .setProductBarCode(product.getBarCode()).setProductUnitName(product.getUnitName()));
                }))));
    }

    @GetMapping("/page")
    @Operation(summary = "Get other inbound order page.")
    @PreAuthorize("@ss.hasPermission('erp:stock-in:query')")
    public CommonResult<PageResult<ErpStockInRespVO>> getStockInPage(@Valid ErpStockInPageReqVO pageReqVO) {
        PageResult<ErpStockInDO> pageResult = stockInService.getStockInPage(pageReqVO);
        return success(buildStockInVOPageResult(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Export other inbound order Excel.")
    @PreAuthorize("@ss.hasPermission('erp:stock-in:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportStockInExcel(@Valid ErpStockInPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ErpStockInRespVO> list = buildStockInVOPageResult(stockInService.getStockInPage(pageReqVO)).getList();
        // Export Excel
        ExcelUtils.write(response, "Other Inbound Orders.xls", "Data", ErpStockInRespVO.class, list);
    }

    private PageResult<ErpStockInRespVO> buildStockInVOPageResult(PageResult<ErpStockInDO> pageResult) {
        if (CollUtil.isEmpty(pageResult.getList())) {
            return PageResult.empty(pageResult.getTotal());
        }
        // 1.1 inbound item
        List<ErpStockInItemDO> stockInItemList = stockInService.getStockInItemListByInIds(
                convertSet(pageResult.getList(), ErpStockInDO::getId));
        Map<Long, List<ErpStockInItemDO>> stockInItemMap = convertMultiMap(stockInItemList, ErpStockInItemDO::getInId);
        // 1.2 product info
        Map<Long, ErpProductRespVO> productMap = productService.getProductVOMap(
                convertSet(stockInItemList, ErpStockInItemDO::getProductId));
        // 1.3 supplier info
        Map<Long, ErpSupplierDO> supplierMap = supplierService.getSupplierMap(
                convertSet(pageResult.getList(), ErpStockInDO::getSupplierId));
        // 1.4 admin info
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(
                convertSet(pageResult.getList(), stockIn -> Long.parseLong(stockIn.getCreator())));
        // 2. 开始拼接
        return BeanUtils.toBean(pageResult, ErpStockInRespVO.class, stockIn -> {
            stockIn.setItems(BeanUtils.toBean(stockInItemMap.get(stockIn.getId()), ErpStockInRespVO.Item.class,
                    item -> MapUtils.findAndThen(productMap, item.getProductId(), product -> item.setProductName(product.getName())
                            .setProductBarCode(product.getBarCode()).setProductUnitName(product.getUnitName()))));
            stockIn.setProductNames(CollUtil.join(stockIn.getItems(), "，", ErpStockInRespVO.Item::getProductName));
            MapUtils.findAndThen(supplierMap, stockIn.getSupplierId(), supplier -> stockIn.setSupplierName(supplier.getName()));
            MapUtils.findAndThen(userMap, Long.parseLong(stockIn.getCreator()), user -> stockIn.setCreatorName(user.getNickname()));
        });
    }

}