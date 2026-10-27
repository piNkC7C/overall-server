package cn.iocoder.yudao.module.erp.controller.admin.sale;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.erp.controller.admin.product.vo.product.ErpProductRespVO;
import cn.iocoder.yudao.module.erp.controller.admin.sale.vo.out.ErpSaleOutPageReqVO;
import cn.iocoder.yudao.module.erp.controller.admin.sale.vo.out.ErpSaleOutRespVO;
import cn.iocoder.yudao.module.erp.controller.admin.sale.vo.out.ErpSaleOutSaveReqVO;
import cn.iocoder.yudao.module.erp.dal.dataobject.sale.ErpCustomerDO;
import cn.iocoder.yudao.module.erp.dal.dataobject.sale.ErpSaleOutDO;
import cn.iocoder.yudao.module.erp.dal.dataobject.sale.ErpSaleOutItemDO;
import cn.iocoder.yudao.module.erp.dal.dataobject.stock.ErpStockDO;
import cn.iocoder.yudao.module.erp.service.product.ErpProductService;
import cn.iocoder.yudao.module.erp.service.sale.ErpCustomerService;
import cn.iocoder.yudao.module.erp.service.sale.ErpSaleOutService;
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

@Tag(name = "Admin - ERP sales outbound.")
@RestController
@RequestMapping("/erp/sale-out")
@Validated
public class ErpSaleOutController {

    @Resource
    private ErpSaleOutService saleOutService;
    @Resource
    private ErpStockService stockService;
    @Resource
    private ErpProductService productService;
    @Resource
    private ErpCustomerService customerService;

    @Resource
    private AdminUserApi adminUserApi;

    @PostMapping("/create")
    @Operation(summary = "Create sales outbound.")
    @PreAuthorize("@ss.hasPermission('erp:sale-out:create')")
    public CommonResult<Long> createSaleOut(@Valid @RequestBody ErpSaleOutSaveReqVO createReqVO) {
        return success(saleOutService.createSaleOut(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update sales outbound.")
    @PreAuthorize("@ss.hasPermission('erp:sale-out:update')")
    public CommonResult<Boolean> updateSaleOut(@Valid @RequestBody ErpSaleOutSaveReqVO updateReqVO) {
        saleOutService.updateSaleOut(updateReqVO);
        return success(true);
    }

    @PutMapping("/update-status")
    @Operation(summary = "Update sales outbound status.")
    @PreAuthorize("@ss.hasPermission('erp:sale-out:update-status')")
    public CommonResult<Boolean> updateSaleOutStatus(@RequestParam("id") Long id,
                                                      @RequestParam("status") Integer status) {
        saleOutService.updateSaleOutStatus(id, status);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete sales outbound.")
    @Parameter(name = "ids", description = "ID list.", required = true)
    @PreAuthorize("@ss.hasPermission('erp:sale-out:delete')")
    public CommonResult<Boolean> deleteSaleOut(@RequestParam("ids") List<Long> ids) {
        saleOutService.deleteSaleOut(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get sales outbound.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('erp:sale-out:query')")
    public CommonResult<ErpSaleOutRespVO> getSaleOut(@RequestParam("id") Long id) {
        ErpSaleOutDO saleOut = saleOutService.getSaleOut(id);
        if (saleOut == null) {
            return success(null);
        }
        List<ErpSaleOutItemDO> saleOutItemList = saleOutService.getSaleOutItemListByOutId(id);
        Map<Long, ErpProductRespVO> productMap = productService.getProductVOMap(
                convertSet(saleOutItemList, ErpSaleOutItemDO::getProductId));
        return success(BeanUtils.toBean(saleOut, ErpSaleOutRespVO.class, saleOutVO ->
                saleOutVO.setItems(BeanUtils.toBean(saleOutItemList, ErpSaleOutRespVO.Item.class, item -> {
                    ErpStockDO stock = stockService.getStock(item.getProductId(), item.getWarehouseId());
                    item.setStockCount(stock != null ? stock.getCount() : BigDecimal.ZERO);
                    MapUtils.findAndThen(productMap, item.getProductId(), product -> item.setProductName(product.getName())
                            .setProductBarCode(product.getBarCode()).setProductUnitName(product.getUnitName()));
                }))));
    }

    @GetMapping("/page")
    @Operation(summary = "Get sales outbound page.")
    @PreAuthorize("@ss.hasPermission('erp:sale-out:query')")
    public CommonResult<PageResult<ErpSaleOutRespVO>> getSaleOutPage(@Valid ErpSaleOutPageReqVO pageReqVO) {
        PageResult<ErpSaleOutDO> pageResult = saleOutService.getSaleOutPage(pageReqVO);
        return success(buildSaleOutVOPageResult(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Export sales outbound Excel.")
    @PreAuthorize("@ss.hasPermission('erp:sale-out:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportSaleOutExcel(@Valid ErpSaleOutPageReqVO pageReqVO,
                                    HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ErpSaleOutRespVO> list = buildSaleOutVOPageResult(saleOutService.getSaleOutPage(pageReqVO)).getList();
        // Export Excel
        ExcelUtils.write(response, "Sales Outbound.xls", "Data", ErpSaleOutRespVO.class, list);
    }

    private PageResult<ErpSaleOutRespVO> buildSaleOutVOPageResult(PageResult<ErpSaleOutDO> pageResult) {
        if (CollUtil.isEmpty(pageResult.getList())) {
            return PageResult.empty(pageResult.getTotal());
        }
        // 1.1 outbound item
        List<ErpSaleOutItemDO> saleOutItemList = saleOutService.getSaleOutItemListByOutIds(
                convertSet(pageResult.getList(), ErpSaleOutDO::getId));
        Map<Long, List<ErpSaleOutItemDO>> saleOutItemMap = convertMultiMap(saleOutItemList, ErpSaleOutItemDO::getOutId);
        // 1.2 product info
        Map<Long, ErpProductRespVO> productMap = productService.getProductVOMap(
                convertSet(saleOutItemList, ErpSaleOutItemDO::getProductId));
        // 1.3 customer info
        Map<Long, ErpCustomerDO> customerMap = customerService.getCustomerMap(
                convertSet(pageResult.getList(), ErpSaleOutDO::getCustomerId));
        // 1.4 admin info
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(
                convertSet(pageResult.getList(), stockOut -> Long.parseLong(stockOut.getCreator())));
        // 2. 开始拼接
        return BeanUtils.toBean(pageResult, ErpSaleOutRespVO.class, saleOut -> {
            saleOut.setItems(BeanUtils.toBean(saleOutItemMap.get(saleOut.getId()), ErpSaleOutRespVO.Item.class,
                    item -> MapUtils.findAndThen(productMap, item.getProductId(), product -> item.setProductName(product.getName())
                            .setProductBarCode(product.getBarCode()).setProductUnitName(product.getUnitName()))));
            saleOut.setProductNames(CollUtil.join(saleOut.getItems(), "，", ErpSaleOutRespVO.Item::getProductName));
            MapUtils.findAndThen(customerMap, saleOut.getCustomerId(), supplier -> saleOut.setCustomerName(supplier.getName()));
            MapUtils.findAndThen(userMap, Long.parseLong(saleOut.getCreator()), user -> saleOut.setCreatorName(user.getNickname()));
        });
    }

}