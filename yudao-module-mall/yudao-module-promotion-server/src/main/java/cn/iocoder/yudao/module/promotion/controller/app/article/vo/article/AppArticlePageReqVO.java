package cn.iocoder.yudao.module.promotion.controller.app.article.vo.article;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "App App - article page request.")
@Data
public class AppArticlePageReqVO extends PageParam {

    @Schema(description = "Category code.", example = "2048")
    private Long categoryId;

}
