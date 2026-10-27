package cn.iocoder.yudao.module.erp.controller.admin.product;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.erp.controller.admin.product.vo.product.ErpProductPageReqVO;
import cn.iocoder.yudao.module.erp.controller.admin.product.vo.product.ErpProductRespVO;
import cn.iocoder.yudao.module.erp.controller.admin.product.vo.product.ProductSaveReqVO;
import cn.iocoder.yudao.module.erp.dal.dataobject.product.ErpProductDO;
import cn.iocoder.yudao.module.erp.service.product.ErpProductService;
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
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;

@Tag(name = "Admin - ERP product.")
@RestController
@RequestMapping("/erp/product")
@Validated
public class ErpProductController {

    @Resource
    private ErpProductService productService;

    @PostMapping("/create")
    @Operation(summary = "Createproduct.")
    @PreAuthorize("@ss.hasPermission('erp:product:create')")
    public CommonResult<Long> createProduct(@Valid @RequestBody ProductSaveReqVO createReqVO) {
        return success(productService.createProduct(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updateproduct.")
    @PreAuthorize("@ss.hasPermission('erp:product:update')")
    public CommonResult<Boolean> updateProduct(@Valid @RequestBody ProductSaveReqVO updateReqVO) {
        productService.updateProduct(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deleteproduct.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('erp:product:delete')")
    public CommonResult<Boolean> deleteProduct(@RequestParam("id") Long id) {
        productService.deleteProduct(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get product.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('erp:product:query')")
    public CommonResult<ErpProductRespVO> getProduct(@RequestParam("id") Long id) {
        ErpProductDO product = productService.getProduct(id);
        return success(BeanUtils.toBean(product, ErpProductRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get product page.")
    @PreAuthorize("@ss.hasPermission('erp:product:query')")
    public CommonResult<PageResult<ErpProductRespVO>> getProductPage(@Valid ErpProductPageReqVO pageReqVO) {
        return success(productService.getProductVOPage(pageReqVO));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get product simple list.", description = "Enabled products only. Used by frontend dropdowns.")
    public CommonResult<List<ErpProductRespVO>> getProductSimpleList() {
        List<ErpProductRespVO> list = productService.getProductVOListByStatus(CommonStatusEnum.ENABLE.getStatus());
        return success(convertList(list, product -> new ErpProductRespVO().setId(product.getId())
                .setName(product.getName()).setBarCode(product.getBarCode())
                .setCategoryId(product.getCategoryId()).setCategoryName(product.getCategoryName())
                .setUnitId(product.getUnitId()).setUnitName(product.getUnitName())
                .setPurchasePrice(product.getPurchasePrice()).setSalePrice(product.getSalePrice()).setMinPrice(product.getMinPrice())));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Exportproduct Excel.")
    @PreAuthorize("@ss.hasPermission('erp:product:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportProductExcel(@Valid ErpProductPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        PageResult<ErpProductRespVO> pageResult = productService.getProductVOPage(pageReqVO);
        // Export Excel
        ExcelUtils.write(response, "Products.xls", "Data", ErpProductRespVO.class,
                pageResult.getList());
    }

}