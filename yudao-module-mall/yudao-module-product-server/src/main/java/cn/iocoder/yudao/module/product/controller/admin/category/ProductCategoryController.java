package cn.iocoder.yudao.module.product.controller.admin.category;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.product.controller.admin.category.vo.ProductCategoryListReqVO;
import cn.iocoder.yudao.module.product.controller.admin.category.vo.ProductCategoryRespVO;
import cn.iocoder.yudao.module.product.controller.admin.category.vo.ProductCategorySaveReqVO;
import cn.iocoder.yudao.module.product.dal.dataobject.category.ProductCategoryDO;
import cn.iocoder.yudao.module.product.service.category.ProductCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - product category.")
@RestController
@RequestMapping("/product/category")
@Validated
public class ProductCategoryController {

    @Resource
    private ProductCategoryService categoryService;

    @PostMapping("/create")
    @Operation(summary = "Createproduct category.")
    @PreAuthorize("@ss.hasPermission('product:category:create')")
    public CommonResult<Long> createCategory(@Valid @RequestBody ProductCategorySaveReqVO createReqVO) {
        return success(categoryService.createCategory(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updateproduct category.")
    @PreAuthorize("@ss.hasPermission('product:category:update')")
    public CommonResult<Boolean> updateCategory(@Valid @RequestBody ProductCategorySaveReqVO updateReqVO) {
        categoryService.updateCategory(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deleteproduct category.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('product:category:delete')")
    public CommonResult<Boolean> deleteCategory(@RequestParam("id") Long id) {
        categoryService.deleteCategory(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get product category.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('product:category:query')")
    public CommonResult<ProductCategoryRespVO> getCategory(@RequestParam("id") Long id) {
        ProductCategoryDO category = categoryService.getCategory(id);
        return success(BeanUtils.toBean(category, ProductCategoryRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "Get product category list.")
    @PreAuthorize("@ss.hasPermission('product:category:query')")
    public CommonResult<List<ProductCategoryRespVO>> getCategoryList(@Valid ProductCategoryListReqVO listReqVO) {
        List<ProductCategoryDO> list = categoryService.getCategoryList(listReqVO);
        list.sort(Comparator.comparing(ProductCategoryDO::getSort));
        return success(BeanUtils.toBean(list, ProductCategoryRespVO.class));
    }

}
