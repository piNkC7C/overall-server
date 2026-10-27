package cn.iocoder.yudao.module.bpm.controller.admin.definition;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.category.BpmCategoryPageReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.category.BpmCategoryRespVO;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.category.BpmCategorySaveReqVO;
import cn.iocoder.yudao.module.bpm.dal.dataobject.definition.BpmCategoryDO;
import cn.iocoder.yudao.module.bpm.service.definition.BpmCategoryService;
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
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;

@Tag(name = "Admin - BPM workflowcategory.")
@RestController
@RequestMapping("/bpm/category")
@Validated
public class BpmCategoryController {

    @Resource
    private BpmCategoryService categoryService;

    @PostMapping("/create")
    @Operation(summary = "Createworkflowcategory.")
    @PreAuthorize("@ss.hasPermission('bpm:category:create')")
    public CommonResult<Long> createCategory(@Valid @RequestBody BpmCategorySaveReqVO createReqVO) {
        return success(categoryService.createCategory(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updateworkflowcategory.")
    @PreAuthorize("@ss.hasPermission('bpm:category:update')")
    public CommonResult<Boolean> updateCategory(@Valid @RequestBody BpmCategorySaveReqVO updateReqVO) {
        categoryService.updateCategory(updateReqVO);
        return success(true);
    }

    @PutMapping("/update-sort-batch")
    @Operation(summary = "Batch updateworkflowcategory sort.")
    @Parameter(name = "ids", description = "Category code list.", required = true, example = "1,2,3")
    @PreAuthorize("@ss.hasPermission('bpm:category:update')")
    public CommonResult<Boolean> updateCategorySortBatch(@RequestParam("ids") List<Long> ids) {
        categoryService.updateCategorySortBatch(ids);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deleteworkflowcategory.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('bpm:category:delete')")
    public CommonResult<Boolean> deleteCategory(@RequestParam("id") Long id) {
        categoryService.deleteCategory(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get workflowcategory.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bpm:category:query')")
    public CommonResult<BpmCategoryRespVO> getCategory(@RequestParam("id") Long id) {
        BpmCategoryDO category = categoryService.getCategory(id);
        return success(BeanUtils.toBean(category, BpmCategoryRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get workflowcategory page.")
    @PreAuthorize("@ss.hasPermission('bpm:category:query')")
    public CommonResult<PageResult<BpmCategoryRespVO>> getCategoryPage(@Valid BpmCategoryPageReqVO pageReqVO) {
        PageResult<BpmCategoryDO> pageResult = categoryService.getCategoryPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, BpmCategoryRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get workflowcategory simple info list.", description = "Enabled categories only. Used by frontend dropdowns.")
    public CommonResult<List<BpmCategoryRespVO>> getCategorySimpleList() {
        List<BpmCategoryDO> list = categoryService.getCategoryListByStatus(CommonStatusEnum.ENABLE.getStatus());
        list.sort(Comparator.comparingInt(BpmCategoryDO::getSort));
        return success(convertList(list, category -> new BpmCategoryRespVO().setId(category.getId())
                .setName(category.getName()).setCode(category.getCode())));
    }

}