package cn.iocoder.yudao.module.trade.controller.app.order.vo.item;

import cn.iocoder.yudao.module.trade.controller.app.base.property.AppProductPropertyValueDetailRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "User App - order trade item response.")
@Data
public class AppTradeOrderItemRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long orderId;

    @Schema(description = "Product SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long spuId;
    @Schema(description = "Product SPU name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String spuName;

    @Schema(description = "Product SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long skuId;

    /**
     * 属性数组
     */
    private List<AppProductPropertyValueDetailRespVO> properties;

    @Schema(description = "Product Image", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/1.png")
    private String picUrl;

    @Schema(description = "Purchase quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer count;

    @Schema(description = "Is not review.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean commentStatus;

    // ========== Price + payment Basic Info ==========

    @Schema(description = "ProductOriginal Price ( order ).", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer price;

    @Schema(description = "Amount due (total) in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "50")
    private Integer payPrice;

    // ========== 营销基本信息 ==========

    // TODO 芋艿：在捉摸一下

    // ========== after-sales Basic Info ==========

    @Schema(description = "After-sales code.", example = "1024")
    private Long afterSaleId;

    @Schema(description = "After-sales status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer afterSaleStatus;

}
