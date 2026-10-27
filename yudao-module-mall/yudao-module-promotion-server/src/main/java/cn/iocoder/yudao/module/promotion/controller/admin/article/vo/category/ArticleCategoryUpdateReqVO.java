package cn.iocoder.yudao.module.promotion.controller.admin.article.vo.category;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - articlecategoryupdate request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ArticleCategoryUpdateReqVO extends ArticleCategoryBaseVO {

    @Schema(description = "Articlecategory code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "19490")
    @NotNull(message = "Articlecategory code is required.")
    private Long id;

}
