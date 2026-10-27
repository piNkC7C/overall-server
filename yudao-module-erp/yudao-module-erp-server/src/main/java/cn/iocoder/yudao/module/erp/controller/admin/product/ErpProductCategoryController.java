package cn.iocoder.yudao.module.erp.controller.admin.product;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.erp.controller.admin.product.vo.category.ErpProductCategoryListReqVO;
import cn.iocoder.yudao.module.erp.controller.admin.product.vo.category.ErpProductCategoryRespVO;
import cn.iocoder.yudao.module.erp.controller.admin.product.vo.category.ErpProductCategorySaveReqVO;
import cn.iocoder.yudao.module.erp.dal.dataobject.product.ErpProductCategoryDO;
import cn.iocoder.yudao.module.erp.service.product.ErpProductCategoryService;
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

@Tag(name = "Admin - ERP product category.")
@RestController
@RequestMapping("/erp/product-category")
@Validated
public class ErpProductCategoryController {

    @Resource
    private ErpProductCategoryService productCategoryService;

    @PostMapping("/create")
    @Operation(summary = "Createproduct category.")
    @PreAuthorize("@ss.hasPermission('erp:product-category:create')")
    public CommonResult<Long> createProductCategory(@Valid @RequestBody ErpProductCategorySaveReqVO createReqVO) {
        return success(productCategoryService.createProductCategory(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updateproduct category.")
    @PreAuthorize("@ss.hasPermission('erp:product-category:update')")
    public CommonResult<Boolean> updateProductCategory(@Valid @RequestBody ErpProductCategorySaveReqVO updateReqVO) {
        productCategoryService.updateProductCategory(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deleteproduct category.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('erp:product-category:delete')")
    public CommonResult<Boolean> deleteProductCategory(@RequestParam("id") Long id) {
        productCategoryService.deleteProductCategory(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get product category.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('erp:product-category:query')")
    public CommonResult<ErpProductCategoryRespVO> getProductCategory(@RequestParam("id") Long id) {
        ErpProductCategoryDO category = productCategoryService.getProductCategory(id);
        return success(BeanUtils.toBean(category, ErpProductCategoryRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "Get product category list.")
    @PreAuthorize("@ss.hasPermission('erp:product-category:query')")
    public CommonResult<List<ErpProductCategoryRespVO>> getProductCategoryList(@Valid ErpProductCategoryListReqVO listReqVO) {
        List<ErpProductCategoryDO> list = productCategoryService.getProductCategoryList(listReqVO);
        return success(BeanUtils.toBean(list, ErpProductCategoryRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get product category simple list.", description = "Enabled categories only. Used by frontend dropdowns.")
    public CommonResult<List<ErpProductCategoryRespVO>> getProductCategorySimpleList() {
        List<ErpProductCategoryDO> list = productCategoryService.getProductCategoryList(
                new ErpProductCategoryListReqVO().setStatus(CommonStatusEnum.ENABLE.getStatus()));
        return success(convertList(list, category -> new ErpProductCategoryRespVO()
                .setId(category.getId()).setName(category.getName()).setParentId(category.getParentId())));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Exportproduct category Excel.")
    @PreAuthorize("@ss.hasPermission('erp:product-category:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportProductCategoryExcel(@Valid ErpProductCategoryListReqVO listReqVO,
              HttpServletResponse response) throws IOException {
        List<ErpProductCategoryDO> list = productCategoryService.getProductCategoryList(listReqVO);
        // Export Excel
        ExcelUtils.write(response, "Product Categories.xls", "Data", ErpProductCategoryRespVO.class,
                        BeanUtils.toBean(list, ErpProductCategoryRespVO.class));
    }

}