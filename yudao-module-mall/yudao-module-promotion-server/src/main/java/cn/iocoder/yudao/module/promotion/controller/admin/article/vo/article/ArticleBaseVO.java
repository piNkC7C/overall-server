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

    @Schema(description = "Articlecategory code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15458")
    @NotNull(message = "Articlecategory code is required.")
    private Long categoryId;

    @Schema(description = "Relation product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "22378")
    @NotNull(message = "Relation product is required.")
    private Long spuId;

    @Schema(description = "Article title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "This is a title")
    @NotNull(message = "Article title is required.")
    private String title;

    @Schema(description = "ArticleAuthor.", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    private String author;

    @Schema(description = "Article cover ImageAddress.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    @NotNull(message = "Article cover ImageAddress is required.")
    private String picUrl;

    @Schema(description = "Article bio.", requiredMode = Schema.RequiredMode.REQUIRED, example = "This is a summary")
    private String introduction;

    @Schema(description = "Sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "Featured in the mini program.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Featured in the mini program cannot be empty.")
    private Boolean recommendHot;

    @Schema(description = "Carousel in the mini program.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Carousel in the mini program cannot be empty.")
    private Boolean recommendBanner;

    @Schema(description = "Article content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "This is the article content")
    @NotNull(message = "Article content is required.")
    private String content;

}
