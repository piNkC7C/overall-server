package cn.iocoder.yudao.module.promotion.controller.app.article;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.promotion.controller.app.article.vo.article.AppArticlePageReqVO;
import cn.iocoder.yudao.module.promotion.controller.app.article.vo.article.AppArticleRespVO;
import cn.iocoder.yudao.module.promotion.convert.article.ArticleConvert;
import cn.iocoder.yudao.module.promotion.dal.dataobject.article.ArticleDO;
import cn.iocoder.yudao.module.promotion.service.article.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.PermitAll;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "User APP - article.")
@RestController
@RequestMapping("/promotion/article")
@Validated
public class AppArticleController {

    @Resource
    private ArticleService articleService;

    @RequestMapping("/list")
    @Operation(summary = "Get article details list.")
    @Parameters({
            @Parameter(name = "recommendHot", description = "Hot.", example = "false"), // 场景一：查看指定的文章
            @Parameter(name = "recommendBanner", description = "Carousel.", example = "false") // 场景二：查看指定的文章
    })
    @PermitAll
    public CommonResult<List<AppArticleRespVO>> getArticleList(
            @RequestParam(value = "recommendHot", required = false) Boolean recommendHot,
            @RequestParam(value = "recommendBanner", required = false) Boolean recommendBanner) {
        return success(ArticleConvert.INSTANCE.convertList03(
                articleService.getArticleCategoryListByRecommend(recommendHot, recommendBanner)));
    }

    @RequestMapping("/page")
    @Operation(summary = "Get article details page.")
    @PermitAll
    public CommonResult<PageResult<AppArticleRespVO>> getArticlePage(AppArticlePageReqVO pageReqVO) {
        return success(ArticleConvert.INSTANCE.convertPage02(articleService.getArticlePage(pageReqVO)));
    }

    @RequestMapping("/get")
    @Operation(summary = "Get article details.")
    @Parameters({
            @Parameter(name = "id", description = "Article code.", example = "1024"),
            @Parameter(name = "title", description = "Article title.", example = "1024"),
    })
    @PermitAll
    public CommonResult<AppArticleRespVO> getArticle(@RequestParam(value = "id", required = false) Long id,
                                                     @RequestParam(value = "title", required = false) String title) {
        ArticleDO article = id != null ? articleService.getArticle(id)
                : articleService.getLastArticleByTitle(title);
        return success(BeanUtils.toBean(article, AppArticleRespVO.class));
    }

    @PutMapping("/add-browse-count")
    @Operation(summary = "Add article views.")
    @Parameter(name = "id", description = "Article code.", example = "1024")
    @PermitAll
    public CommonResult<Boolean> addBrowseCount(@RequestParam("id") Long id) {
        articleService.addArticleBrowseCount(id);
        return success(true);
    }

}