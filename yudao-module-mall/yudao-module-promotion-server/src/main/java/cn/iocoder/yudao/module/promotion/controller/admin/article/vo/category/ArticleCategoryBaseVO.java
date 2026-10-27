package cn.iocoder.yudao.module.promotion.controller.admin.article.vo.category;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 文章分类 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class ArticleCategoryBaseVO {

    @Schema(description = "Articlecategory name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Flash sale.")
    @NotNull(message = "Articlecategory name is required.")
    private String name;

    @Schema(description = "IconAddress.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    private String picUrl;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "Sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Sort is required.")
    private Integer sort;

}
