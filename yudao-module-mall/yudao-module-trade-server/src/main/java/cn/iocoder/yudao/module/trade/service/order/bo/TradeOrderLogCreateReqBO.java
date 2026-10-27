package cn.iocoder.yudao.module.trade.service.order.bo;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * 订单日志的创建 Request BO
 *
 * @author 陈賝
 * @since 2023/7/6 15:27
 */
@Data
public class TradeOrderLogCreateReqBO {

    /**
     * 用户编号
     */
    @NotNull(message = "User ID is required.")
    private Long userId;
    /**
     * 用户类型
     */
    @NotNull(message = "User type is required.")
    private Integer userType;

    /**
     * 订单编号
     */
    @NotNull(message = "Order code is required.")
    private Long orderId;
    /**
     * 操作前状态
     */
    private Integer beforeStatus;
    /**
     * 操作后状态
     */
    @NotNull(message = "Action after status is required.")
    private Integer afterStatus;

    /**
     * 操作类型
     */
    @NotNull(message = "Action type is required.")
    private Integer operateType;
    /**
     * 操作明细
     */
    @NotEmpty(message = "Actiondetail is required.")
    private String content;

}
