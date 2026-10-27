package cn.iocoder.yudao.module.crm.controller.admin.product;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.framework.translate.core.TranslateUtils;
import cn.iocoder.yudao.module.crm.controller.admin.product.vo.product.CrmProductPageReqVO;
import cn.iocoder.yudao.module.crm.controller.admin.product.vo.product.CrmProductRespVO;
import cn.iocoder.yudao.module.crm.controller.admin.product.vo.product.CrmProductSaveReqVO;
import cn.iocoder.yudao.module.crm.dal.dataobject.product.CrmProductDO;
import cn.iocoder.yudao.module.crm.enums.product.CrmProductStatusEnum;
import cn.iocoder.yudao.module.crm.service.product.CrmProductService;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import org.dromara.core.trans.anno.TransMethodResult;
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

@Tag(name = "Admin - CRM product.")
@RestController
@RequestMapping("/crm/product")
@Validated
public class CrmProductController {

    @Resource
    private CrmProductService productService;
    @Resource
    private AdminUserApi adminUserApi;

    @PostMapping("/create")
    @Operation(summary = "Createproduct.")
    @PreAuthorize("@ss.hasPermission('crm:product:create')")
    public CommonResult<Long> createProduct(@Valid @RequestBody CrmProductSaveReqVO createReqVO) {
        return success(productService.createProduct(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updateproduct.")
    @PreAuthorize("@ss.hasPermission('crm:product:update')")
    public CommonResult<Boolean> updateProduct(@Valid @RequestBody CrmProductSaveReqVO updateReqVO) {
        productService.updateProduct(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deleteproduct.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('crm:product:delete')")
    public CommonResult<Boolean> deleteProduct(@RequestParam("id") Long id) {
        productService.deleteProduct(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get product.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('crm:product:query')")
    @TransMethodResult
    public CommonResult<CrmProductRespVO> getProduct(@RequestParam("id") Long id) {
        CrmProductDO product = productService.getProduct(id);
        return success(BeanUtils.toBean(product, CrmProductRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get product simple list.", description = "Enabled products only. Used by frontend dropdowns.")
    public CommonResult<List<CrmProductRespVO>> getProductSimpleList() {
        List<CrmProductDO> list = productService.getProductListByStatus(CrmProductStatusEnum.ENABLE.getStatus());
        return success(convertList(list, product -> new CrmProductRespVO().setId(product.getId()).setName(product.getName())
                .setUnit(product.getUnit()).setNo(product.getNo()).setPrice(product.getPrice())));
    }

    @GetMapping("/page")
    @Operation(summary = "Get product page.")
    @PreAuthorize("@ss.hasPermission('crm:product:query')")
    @TransMethodResult
    public CommonResult<PageResult<CrmProductRespVO>> getProductPage(@Valid CrmProductPageReqVO pageVO) {
        PageResult<CrmProductDO> pageResult = productService.getProductPage(pageVO);
        return success(BeanUtils.toBean(pageResult, CrmProductRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Exportproduct Excel.")
    @PreAuthorize("@ss.hasPermission('crm:product:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportProductExcel(@Valid CrmProductPageReqVO exportReqVO,
                                   HttpServletResponse response) throws IOException {
        exportReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<CrmProductDO> list = productService.getProductPage(exportReqVO).getList();
        // Export Excel
        ExcelUtils.write(response, "Products.xls", "Data", CrmProductRespVO.class,
                TranslateUtils.translate(BeanUtils.toBean(list, CrmProductRespVO.class)));
    }

}
