package cn.iocoder.yudao.module.product.controller.admin.favorite.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - productFavorite page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProductFavoritePageReqVO extends PageParam {

    @Schema(description = "User ID.", example = "5036")
    private Long userId;

}
