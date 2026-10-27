package cn.iocoder.yudao.module.trade.controller.admin.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 交易订单项 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class TradeOrderItemBaseVO {

    // ========== order item Basic Info ==========

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long userId;

    @Schema(description = "Order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long orderId;

    // ========== productBasic Info ==========

    @Schema(description = "Product SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long spuId;

    @Schema(description = "Product SPU name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String spuName;

    @Schema(description = "Product SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long skuId;

    @Schema(description = "Product Image", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/1.png")
    private String picUrl;

    @Schema(description = "Purchase quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer count;

    // ========== Price + payment Basic Info ==========

    @Schema(description = "ProductOriginal Price ( order ).", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer price;

    @Schema(description = "Product discount (total).", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer discountPrice;

    @Schema(description = "Product paid amount (total).", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer payPrice;

    @Schema(description = "Child-order allocated amount (total).", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer orderPartPrice;

    @Schema(description = "Child-order paid amount after allocation (total).", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer orderDividePrice;

    // ========== 营销基本信息 ==========

    // TODO 芋艿：在捉摸一下

    // ========== after-sales Basic Info ==========

    @Schema(description = "After-sales status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer afterSaleStatus;

}
