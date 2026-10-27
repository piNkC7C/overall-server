package cn.iocoder.yudao.module.promotion.controller.admin.article.vo.category;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "Admin - articlecategory response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ArticleCategoryRespVO extends ArticleCategoryBaseVO {

    @Schema(description = "Articlecategory code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "19490")
    private Long id;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
