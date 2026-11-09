package cn.iocoder.yudao.module.promotion.controller.admin.article.vo.article;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 文章管理 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class ArticleBaseVO {

    @Schema(description = "文章分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "15458")
    @NotNull(message = "Articlecategory code is required.")
    private Long categoryId;

    @Schema(description = "关联商品编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "22378")
    @NotNull(message = "Relation product is required.")
    private Long spuId;

    @Schema(description = "文章标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "This is a title")
    @NotNull(message = "Article title is required.")
    private String title;

    @Schema(description = "文章作者", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    private String author;

    @Schema(description = "文章封面图片地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    @NotNull(message = "Article cover ImageAddress is required.")
    private String picUrl;

    @Schema(description = "文章简介", requiredMode = Schema.RequiredMode.REQUIRED, example = "This is a summary")
    private String introduction;

    @Schema(description = "排序", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "是否热门(小程序)", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Featured in the mini program cannot be empty.")
    private Boolean recommendHot;

    @Schema(description = "是否轮播图(小程序)", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Carousel in the mini program cannot be empty.")
    private Boolean recommendBanner;

    @Schema(description = "文章内容", requiredMode = Schema.RequiredMode.REQUIRED, example = "This is the article content")
    @NotNull(message = "Article content is required.")
    private String content;

}
