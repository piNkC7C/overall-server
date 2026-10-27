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
import cn.iocoder.yudao.module.erp.controller.admin.stock.vo.check.ErpStockCheckPageReqVO;
import cn.iocoder.yudao.module.erp.controller.admin.stock.vo.check.ErpStockCheckRespVO;
import cn.iocoder.yudao.module.erp.controller.admin.stock.vo.check.ErpStockCheckSaveReqVO;
import cn.iocoder.yudao.module.erp.dal.dataobject.stock.ErpStockCheckDO;
import cn.iocoder.yudao.module.erp.dal.dataobject.stock.ErpStockCheckItemDO;
import cn.iocoder.yudao.module.erp.service.product.ErpProductService;
import cn.iocoder.yudao.module.erp.service.stock.ErpStockCheckService;
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
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertMultiMap;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;

@Tag(name = "Admin - ERP inventory transfer order.")
@RestController
@RequestMapping("/erp/stock-check")
@Validated
public class ErpStockCheckController {

    @Resource
    private ErpStockCheckService stockCheckService;
    @Resource
    private ErpProductService productService;

    @Resource
    private AdminUserApi adminUserApi;

    @PostMapping("/create")
    @Operation(summary = "Createinventory transfer order.")
    @PreAuthorize("@ss.hasPermission('erp:stock-check:create')")
    public CommonResult<Long> createStockCheck(@Valid @RequestBody ErpStockCheckSaveReqVO createReqVO) {
        return success(stockCheckService.createStockCheck(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updateinventory transfer order.")
    @PreAuthorize("@ss.hasPermission('erp:stock-check:update')")
    public CommonResult<Boolean> updateStockCheck(@Valid @RequestBody ErpStockCheckSaveReqVO updateReqVO) {
        stockCheckService.updateStockCheck(updateReqVO);
        return success(true);
    }

    @PutMapping("/update-status")
    @Operation(summary = "Updateinventory transfer order status.")
    @PreAuthorize("@ss.hasPermission('erp:stock-check:update-status')")
    public CommonResult<Boolean> updateStockCheckStatus(@RequestParam("id") Long id,
                                                     @RequestParam("status") Integer status) {
        stockCheckService.updateStockCheckStatus(id, status);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deleteinventory transfer order.")
    @Parameter(name = "ids", description = "ID list.", required = true)
    @PreAuthorize("@ss.hasPermission('erp:stock-check:delete')")
    public CommonResult<Boolean> deleteStockCheck(@RequestParam("ids") List<Long> ids) {
        stockCheckService.deleteStockCheck(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get inventory transfer order.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('erp:stock-check:query')")
    public CommonResult<ErpStockCheckRespVO> getStockCheck(@RequestParam("id") Long id) {
        ErpStockCheckDO stockCheck = stockCheckService.getStockCheck(id);
        if (stockCheck == null) {
            return success(null);
        }
        List<ErpStockCheckItemDO> stockCheckItemList = stockCheckService.getStockCheckItemListByCheckId(id);
        Map<Long, ErpProductRespVO> productMap = productService.getProductVOMap(
                convertSet(stockCheckItemList, ErpStockCheckItemDO::getProductId));
        return success(BeanUtils.toBean(stockCheck, ErpStockCheckRespVO.class, stockCheckVO ->
                stockCheckVO.setItems(BeanUtils.toBean(stockCheckItemList, ErpStockCheckRespVO.Item.class, item ->
                        MapUtils.findAndThen(productMap, item.getProductId(), product -> item.setProductName(product.getName())
                                .setProductBarCode(product.getBarCode()).setProductUnitName(product.getUnitName()))))));
    }

    @GetMapping("/page")
    @Operation(summary = "Get inventory transfer order page.")
    @PreAuthorize("@ss.hasPermission('erp:stock-check:query')")
    public CommonResult<PageResult<ErpStockCheckRespVO>> getStockCheckPage(@Valid ErpStockCheckPageReqVO pageReqVO) {
        PageResult<ErpStockCheckDO> pageResult = stockCheckService.getStockCheckPage(pageReqVO);
        return success(buildStockCheckVOPageResult(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Exportinventory transfer order Excel.")
    @PreAuthorize("@ss.hasPermission('erp:stock-check:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportStockCheckExcel(@Valid ErpStockCheckPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ErpStockCheckRespVO> list = buildStockCheckVOPageResult(stockCheckService.getStockCheckPage(pageReqVO)).getList();
        // Export Excel
        ExcelUtils.write(response, "Stock Transfer Orders.xls", "Data", ErpStockCheckRespVO.class, list);
    }

    private PageResult<ErpStockCheckRespVO> buildStockCheckVOPageResult(PageResult<ErpStockCheckDO> pageResult) {
        if (CollUtil.isEmpty(pageResult.getList())) {
            return PageResult.empty(pageResult.getTotal());
        }
        // 1.1 stocktake item
        List<ErpStockCheckItemDO> stockCheckItemList = stockCheckService.getStockCheckItemListByCheckIds(
                convertSet(pageResult.getList(), ErpStockCheckDO::getId));
        Map<Long, List<ErpStockCheckItemDO>> stockCheckItemMap = convertMultiMap(stockCheckItemList, ErpStockCheckItemDO::getCheckId);
        // 1.2 product info
        Map<Long, ErpProductRespVO> productMap = productService.getProductVOMap(
                convertSet(stockCheckItemList, ErpStockCheckItemDO::getProductId));
        // 1.3 admin info
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(
                convertSet(pageResult.getList(), stockCheck -> Long.parseLong(stockCheck.getCreator())));
        // 2. 开始拼接
        return BeanUtils.toBean(pageResult, ErpStockCheckRespVO.class, stockCheck -> {
            stockCheck.setItems(BeanUtils.toBean(stockCheckItemMap.get(stockCheck.getId()), ErpStockCheckRespVO.Item.class,
                    item -> MapUtils.findAndThen(productMap, item.getProductId(), product -> item.setProductName(product.getName())
                            .setProductBarCode(product.getBarCode()).setProductUnitName(product.getUnitName()))));
            stockCheck.setProductNames(CollUtil.join(stockCheck.getItems(), "，", ErpStockCheckRespVO.Item::getProductName));
            MapUtils.findAndThen(userMap, Long.parseLong(stockCheck.getCreator()), user -> stockCheck.setCreatorName(user.getNickname()));
        });
    }

}