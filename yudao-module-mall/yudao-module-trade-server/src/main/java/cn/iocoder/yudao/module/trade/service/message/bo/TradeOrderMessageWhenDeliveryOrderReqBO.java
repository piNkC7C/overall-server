package cn.iocoder.yudao.module.trade.service.message.bo;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * 订单发货时通知创建 Req BO
 *
 * @author HUIHUI
 */
@Data
public class TradeOrderMessageWhenDeliveryOrderReqBO {

    /**
     * 订单编号
     */
    @NotNull(message = "Order code is required.")
    private Long orderId;
    /**
     * 用户编号
     */
    @NotNull(message = "User ID is required.")
    private Long userId;
    /**
     * 消息
     */
    @NotEmpty(message = "Send message is required.")
    private String message;

}
