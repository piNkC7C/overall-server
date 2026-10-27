package cn.iocoder.yudao.module.promotion.controller.app.article.vo.category;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "App App - articlecategory response.")
@Data
public class AppArticleCategoryRespVO {

    @Schema(description = "Category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Category name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Engineering")
    private String name;

    @Schema(description = "CategoryIcon.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/1.png")
    private String picUrl;

}
