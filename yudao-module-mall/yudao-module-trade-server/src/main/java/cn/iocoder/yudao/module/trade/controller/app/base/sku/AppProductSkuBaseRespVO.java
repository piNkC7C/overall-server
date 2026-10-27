package cn.iocoder.yudao.module.trade.controller.app.base.sku;

import cn.iocoder.yudao.module.trade.controller.app.base.property.AppProductPropertyValueDetailRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * 商品 SKU 基础 Response VO
 *
 * @author 芋道源码
 */
@Data
public class AppProductSkuBaseRespVO {

    @Schema(description = "Primary key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "ImageAddress.", example = "https://www.iocoder.cn/xx.png")
    private String picUrl;

    @Schema(description = "Sales Price, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer price;

    @Schema(description = "Inventory.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer stock;

    /**
     * 属性数组
     */
    private List<AppProductPropertyValueDetailRespVO> properties;

}
