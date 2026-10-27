package cn.iocoder.yudao.module.promotion.controller.admin.article.vo.article;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - article admin update request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ArticleUpdateReqVO extends ArticleBaseVO {

    @Schema(description = "Article code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8606")
    @NotNull(message = "Article code is required.")
    private Long id;

}
