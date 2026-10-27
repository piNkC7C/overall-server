package cn.iocoder.yudao.module.trade.controller.admin.order.vo;

import cn.iocoder.yudao.module.trade.controller.admin.base.member.user.MemberUserRespVO;
import cn.iocoder.yudao.module.trade.controller.admin.base.product.property.ProductPropertyValueDetailRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - trade order details response.")
@Data
public class TradeOrderDetailRespVO extends TradeOrderBaseVO {

    /**
     * 订单项列表
     */
    private List<Item> items;

    /**
     * 下单用户信息
     */
    private MemberUserRespVO user;
    /**
     * 推广用户信息
     */
    private MemberUserRespVO brokerageUser;

    /**
     * 操作日志列表
     */
    private List<OrderLog> logs;

    @Schema(description = "Recipient region name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Putuo, Shanghai")
    private String receiverAreaName;

    @Schema(description = "Admin - trade order Activity Log.")
    @Data
    public static class OrderLog {

        @Schema(description = "Action details.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Order shipping.")
        private String content;

        @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2023-06-01 10:50:20")
        private LocalDateTime createTime;

        @Schema(description = "User type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Integer userType;

    }

    @Schema(description = "Admin - trade order details order item.")
    @Data
    public static class Item extends TradeOrderItemBaseVO {

        /**
         * 属性数组
         */
        private List<ProductPropertyValueDetailRespVO> properties;

    }

}
