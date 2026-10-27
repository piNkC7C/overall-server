package cn.iocoder.yudao.module.promotion.controller.admin.article.vo.article;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "Admin - article admin response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ArticleRespVO extends ArticleBaseVO {

    @Schema(description = "Article code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8606")
    private Long id;

    @Schema(description = "Views.", requiredMode = Schema.RequiredMode.REQUIRED, example = "99999")
    private Integer browseCount;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
