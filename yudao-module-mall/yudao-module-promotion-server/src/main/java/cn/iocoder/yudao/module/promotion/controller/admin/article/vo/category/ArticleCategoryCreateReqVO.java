package cn.iocoder.yudao.module.promotion.controller.admin.article.vo.category;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - articlecategorycreate request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ArticleCategoryCreateReqVO extends ArticleCategoryBaseVO {

}
