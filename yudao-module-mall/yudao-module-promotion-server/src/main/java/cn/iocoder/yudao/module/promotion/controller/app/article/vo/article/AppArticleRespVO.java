package cn.iocoder.yudao.module.promotion.controller.app.article.vo.article;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "App App - article response.")
@Data
public class AppArticleRespVO {

    @Schema(description = "Article code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Article title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Yudao - Promotion module")
    private String title;

    @Schema(description = "ArticleAuthor.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String author;

    @Schema(description = "Category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long categoryId;

    @Schema(description = "Article cover.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/1.png")
    private String picUrl;

    @Schema(description = "Article bio.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Me is bio.")
    private String introduction;

    @Schema(description = "Article content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "I am the details")
    private String content;

    @Schema(description = "Published", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Views.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer browseCount;

    @Schema(description = "Relation product SPU code.", example = "1024")
    private Long spuId;

}
