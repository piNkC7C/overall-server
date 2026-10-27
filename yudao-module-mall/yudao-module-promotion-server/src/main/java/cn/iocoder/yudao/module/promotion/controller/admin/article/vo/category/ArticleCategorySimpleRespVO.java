package cn.iocoder.yudao.module.promotion.controller.admin.article.vo.category;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - articlecategory simple info response.")
@Data
public class ArticleCategorySimpleRespVO {

    @Schema(description = "Articlecategory code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "19490")
    private Long id;

    @Schema(description = "Articlecategory name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Flash sale.")
    private String name;

}
