package cn.iocoder.yudao.module.promotion.controller.admin.article.vo.article;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - article admin create request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ArticleCreateReqVO extends ArticleBaseVO {

}
