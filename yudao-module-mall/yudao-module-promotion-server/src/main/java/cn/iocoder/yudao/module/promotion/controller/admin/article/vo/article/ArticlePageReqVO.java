package cn.iocoder.yudao.module.promotion.controller.admin.article.vo.article;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - article admin page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ArticlePageReqVO extends PageParam {

    @Schema(description = "Articlecategory code.", example = "15458")
    private Long categoryId;

    @Schema(description = "Relation product code.", example = "22378")
    private Long spuId;

    @Schema(description = "Article title.")
    private String title;

    @Schema(description = "ArticleAuthor.")
    private String author;

    @Schema(description = "Status.", example = "2")
    private Integer status;

    @Schema(description = "Featured in the mini program.")
    private Boolean recommendHot;

    @Schema(description = "Carousel in the mini program.")
    private Boolean recommendBanner;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
