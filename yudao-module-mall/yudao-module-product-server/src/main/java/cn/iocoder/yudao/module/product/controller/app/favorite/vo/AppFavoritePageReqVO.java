package cn.iocoder.yudao.module.product.controller.app.favorite.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "User App - productFavorite page search request.")
@Data
public class AppFavoritePageReqVO extends PageParam {
}
