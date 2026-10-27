package cn.iocoder.yudao.module.trade.enums.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 订单操作类型的枚举
 *
 * @author 陈賝
 * @since 2023/7/6 15:31
 */
@RequiredArgsConstructor
@Getter
public enum TradeOrderOperateTypeEnum {

    MEMBER_CREATE(1, "User order."),
    ADMIN_UPDATE_PRICE(2, "Order price {oldPayPrice} was adjusted by {adjustPrice}. Amount due is {newPayPrice}"),
    MEMBER_PAY(10, "User payment succeeded."),
    ADMIN_UPDATE_ADDRESS(11, "Receiving Address edit."),
    ADMIN_DELIVERY(20, "Shipped. Carrier: {expressName}. Tracking: {logisticsNo}"),
    MEMBER_RECEIVE(30, "User already receiving."),
    SYSTEM_RECEIVE(31, "Auto-confirmed because receive timed out"),
    ADMIN_PICK_UP_RECEIVE(32, "Admin pickup receiving."),
    MEMBER_COMMENT(33, "User review."),
    SYSTEM_COMMENT(34, "Auto-reviewed because review timed out"),
    MEMBER_CANCEL(40, "Cancelorder."),
    SYSTEM_CANCEL(41, "Auto-canceled because payment timed out"),
    // 42 预留：管理员取消订单
    ADMIN_CANCEL_AFTER_SALE(43, "OrderAll after-sales, adminAutocancelorder."),
    MEMBER_DELETE(49, "Deleteorder."),
    ;

    /**
     * 操作类型
     */
    private final Integer type;
    /**
     * 操作描述
     */
    private final String content;

}
