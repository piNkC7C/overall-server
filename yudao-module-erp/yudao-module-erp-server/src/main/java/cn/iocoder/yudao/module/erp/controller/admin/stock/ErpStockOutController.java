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
import cn.iocoder.yudao.module.erp.controller.admin.stock.vo.out.ErpStockOutPageReqVO;
import cn.iocoder.yudao.module.erp.controller.admin.stock.vo.out.ErpStockOutRespVO;
import cn.iocoder.yudao.module.erp.controller.admin.stock.vo.out.ErpStockOutSaveReqVO;
import cn.iocoder.yudao.module.erp.dal.dataobject.sale.ErpCustomerDO;
import cn.iocoder.yudao.module.erp.dal.dataobject.stock.ErpStockDO;
import cn.iocoder.yudao.module.erp.dal.dataobject.stock.ErpStockOutDO;
import cn.iocoder.yudao.module.erp.dal.dataobject.stock.ErpStockOutItemDO;
import cn.iocoder.yudao.module.erp.service.product.ErpProductService;
import cn.iocoder.yudao.module.erp.service.sale.ErpCustomerService;
import cn.iocoder.yudao.module.erp.service.stock.ErpStockOutService;
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

@Tag(name = "Admin - ERP other outbound order.")
@RestController
@RequestMapping("/erp/stock-out")
@Validated
public class ErpStockOutController {

    @Resource
    private ErpStockOutService stockOutService;
    @Resource
    private ErpStockService stockService;
    @Resource
    private ErpProductService productService;
    @Resource
    private ErpCustomerService customerService;

    @Resource
    private AdminUserApi adminUserApi;

    @PostMapping("/create")
    @Operation(summary = "Create other outbound order.")
    @PreAuthorize("@ss.hasPermission('erp:stock-out:create')")
    public CommonResult<Long> createStockOut(@Valid @RequestBody ErpStockOutSaveReqVO createReqVO) {
        return success(stockOutService.createStockOut(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update other outbound order.")
    @PreAuthorize("@ss.hasPermission('erp:stock-out:update')")
    public CommonResult<Boolean> updateStockOut(@Valid @RequestBody ErpStockOutSaveReqVO updateReqVO) {
        stockOutService.updateStockOut(updateReqVO);
        return success(true);
    }

    @PutMapping("/update-status")
    @Operation(summary = "Update other outbound order status.")
    @PreAuthorize("@ss.hasPermission('erp:stock-out:update-status')")
    public CommonResult<Boolean> updateStockOutStatus(@RequestParam("id") Long id,
                                                     @RequestParam("status") Integer status) {
        stockOutService.updateStockOutStatus(id, status);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete other outbound order.")
    @Parameter(name = "ids", description = "ID list.", required = true)
    @PreAuthorize("@ss.hasPermission('erp:stock-out:delete')")
    public CommonResult<Boolean> deleteStockOut(@RequestParam("ids") List<Long> ids) {
        stockOutService.deleteStockOut(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get other outbound order.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('erp:stock-out:query')")
    public CommonResult<ErpStockOutRespVO> getStockOut(@RequestParam("id") Long id) {
        ErpStockOutDO stockOut = stockOutService.getStockOut(id);
        if (stockOut == null) {
            return success(null);
        }
        List<ErpStockOutItemDO> stockOutItemList = stockOutService.getStockOutItemListByOutId(id);
        Map<Long, ErpProductRespVO> productMap = productService.getProductVOMap(
                convertSet(stockOutItemList, ErpStockOutItemDO::getProductId));
        return success(BeanUtils.toBean(stockOut, ErpStockOutRespVO.class, stockOutVO ->
                stockOutVO.setItems(BeanUtils.toBean(stockOutItemList, ErpStockOutRespVO.Item.class, item -> {
                    ErpStockDO stock = stockService.getStock(item.getProductId(), item.getWarehouseId());
                    item.setStockCount(stock != null ? stock.getCount() : BigDecimal.ZERO);
                    MapUtils.findAndThen(productMap, item.getProductId(), product -> item.setProductName(product.getName())
                            .setProductBarCode(product.getBarCode()).setProductUnitName(product.getUnitName()));
                }))));
    }

    @GetMapping("/page")
    @Operation(summary = "Get other outbound order page.")
    @PreAuthorize("@ss.hasPermission('erp:stock-out:query')")
    public CommonResult<PageResult<ErpStockOutRespVO>> getStockOutPage(@Valid ErpStockOutPageReqVO pageReqVO) {
        PageResult<ErpStockOutDO> pageResult = stockOutService.getStockOutPage(pageReqVO);
        return success(buildStockOutVOPageResult(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Export other outbound order Excel.")
    @PreAuthorize("@ss.hasPermission('erp:stock-out:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportStockOutExcel(@Valid ErpStockOutPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ErpStockOutRespVO> list = buildStockOutVOPageResult(stockOutService.getStockOutPage(pageReqVO)).getList();
        // Export Excel
        ExcelUtils.write(response, "Other Outbound Orders.xls", "Data", ErpStockOutRespVO.class, list);
    }

    private PageResult<ErpStockOutRespVO> buildStockOutVOPageResult(PageResult<ErpStockOutDO> pageResult) {
        if (CollUtil.isEmpty(pageResult.getList())) {
            return PageResult.empty(pageResult.getTotal());
        }
        // 1.1 outbound item
        List<ErpStockOutItemDO> stockOutItemList = stockOutService.getStockOutItemListByOutIds(
                convertSet(pageResult.getList(), ErpStockOutDO::getId));
        Map<Long, List<ErpStockOutItemDO>> stockOutItemMap = convertMultiMap(stockOutItemList, ErpStockOutItemDO::getOutId);
        // 1.2 product info
        Map<Long, ErpProductRespVO> productMap = productService.getProductVOMap(
                convertSet(stockOutItemList, ErpStockOutItemDO::getProductId));
        // 1.3 customer info
        Map<Long, ErpCustomerDO> customerMap = customerService.getCustomerMap(
                convertSet(pageResult.getList(), ErpStockOutDO::getCustomerId));
        // 1.4 admin info
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(
                convertSet(pageResult.getList(), stockOut -> Long.parseLong(stockOut.getCreator())));
        // 2. 开始拼接
        return BeanUtils.toBean(pageResult, ErpStockOutRespVO.class, stockOut -> {
            stockOut.setItems(BeanUtils.toBean(stockOutItemMap.get(stockOut.getId()), ErpStockOutRespVO.Item.class,
                    item -> MapUtils.findAndThen(productMap, item.getProductId(), product -> item.setProductName(product.getName())
                            .setProductBarCode(product.getBarCode()).setProductUnitName(product.getUnitName()))));
            stockOut.setProductNames(CollUtil.join(stockOut.getItems(), "，", ErpStockOutRespVO.Item::getProductName));
            MapUtils.findAndThen(customerMap, stockOut.getCustomerId(), supplier -> stockOut.setCustomerName(supplier.getName()));
            MapUtils.findAndThen(userMap, Long.parseLong(stockOut.getCreator()), user -> stockOut.setCreatorName(user.getNickname()));
        });
    }

}