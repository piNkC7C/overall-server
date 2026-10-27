package cn.iocoder.yudao.module.promotion.controller.admin.article;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.promotion.controller.admin.article.vo.category.*;
import cn.iocoder.yudao.module.promotion.convert.article.ArticleCategoryConvert;
import cn.iocoder.yudao.module.promotion.dal.dataobject.article.ArticleCategoryDO;
import cn.iocoder.yudao.module.promotion.service.article.ArticleCategoryService;
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

@Tag(name = "Admin - articlecategory.")
@RestController
@RequestMapping("/promotion/article-category")
@Validated
public class ArticleCategoryController {

    @Resource
    private ArticleCategoryService articleCategoryService;

    @PostMapping("/create")
    @Operation(summary = "Createarticlecategory.")
    @PreAuthorize("@ss.hasPermission('promotion:article-category:create')")
    public CommonResult<Long> createArticleCategory(@Valid @RequestBody ArticleCategoryCreateReqVO createReqVO) {
        return success(articleCategoryService.createArticleCategory(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updatearticlecategory.")
    @PreAuthorize("@ss.hasPermission('promotion:article-category:update')")
    public CommonResult<Boolean> updateArticleCategory(@Valid @RequestBody ArticleCategoryUpdateReqVO updateReqVO) {
        articleCategoryService.updateArticleCategory(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletearticlecategory.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('promotion:article-category:delete')")
    public CommonResult<Boolean> deleteArticleCategory(@RequestParam("id") Long id) {
        articleCategoryService.deleteArticleCategory(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get articlecategory.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('promotion:article-category:query')")
    public CommonResult<ArticleCategoryRespVO> getArticleCategory(@RequestParam("id") Long id) {
        ArticleCategoryDO category = articleCategoryService.getArticleCategory(id);
        return success(ArticleCategoryConvert.INSTANCE.convert(category));
    }

    @GetMapping("/list-all-simple")
    @Operation(summary = "Get articlecategory simple info list.", description = "Only enabled article category. Used for dropdowns.")
    public CommonResult<List<ArticleCategorySimpleRespVO>> getSimpleDeptList() {
        // 获得分类列表，只要开启状态的
        List<ArticleCategoryDO> list = articleCategoryService.getArticleCategoryListByStatus(CommonStatusEnum.ENABLE.getStatus());
        // 降序排序后，返回给前端
        list.sort(Comparator.comparing(ArticleCategoryDO::getSort).reversed());
        return success(ArticleCategoryConvert.INSTANCE.convertList03(list));
    }

    @GetMapping("/page")
    @Operation(summary = "Get articlecategory page.")
    @PreAuthorize("@ss.hasPermission('promotion:article-category:query')")
    public CommonResult<PageResult<ArticleCategoryRespVO>> getArticleCategoryPage(@Valid ArticleCategoryPageReqVO pageVO) {
        PageResult<ArticleCategoryDO> pageResult = articleCategoryService.getArticleCategoryPage(pageVO);
        return success(ArticleCategoryConvert.INSTANCE.convertPage(pageResult));
    }

}
