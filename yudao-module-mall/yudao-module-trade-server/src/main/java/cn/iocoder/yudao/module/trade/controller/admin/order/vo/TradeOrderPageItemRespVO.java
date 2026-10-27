package cn.iocoder.yudao.module.trade.controller.admin.order.vo;

import cn.iocoder.yudao.module.trade.controller.admin.base.member.user.MemberUserRespVO;
import cn.iocoder.yudao.module.trade.controller.admin.base.product.property.ProductPropertyValueDetailRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - trade order page item response.")
@Data
public class TradeOrderPageItemRespVO extends TradeOrderBaseVO {

    @Schema(description = "Recipient region name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Putuo, Shanghai")
    private String receiverAreaName;

    @Schema(description = "Order item list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Item> items;

    @Schema(description = "User info.", requiredMode = Schema.RequiredMode.REQUIRED)
    private MemberUserRespVO user;

    @Schema(description = "Referrer info.")
    private MemberUserRespVO brokerageUser;

    @Schema(description = "Admin - trade order page item order item.")
    @Data
    public static class Item extends TradeOrderItemBaseVO {

        @Schema(description = "Attribute list.", requiredMode = Schema.RequiredMode.REQUIRED)
        private List<ProductPropertyValueDetailRespVO> properties;

    }

}
