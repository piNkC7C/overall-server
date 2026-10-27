package cn.iocoder.yudao.module.trade.controller.app.base.spu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 商品 SPU 基础 Response VO
 *
 * @author 芋道源码
 */
@Data
public class AppProductSpuBaseRespVO {

    @Schema(description = "Primary key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Product SPU name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String name;

    @Schema(description = "Product main imageAddress.", example = "https://www.iocoder.cn/xx.png")
    private String picUrl;

    @Schema(description = "Product category code.", example = "1")
    private Long categoryId;

    @Schema(description = "Productinventory.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10000")
    private Integer stock;

    @Schema(description = "Product status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

}
