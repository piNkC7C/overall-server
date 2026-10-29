package cn.iocoder.yudao.module.trade.enums.aftersale;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 售后操作类型的枚举
 *
 * @author 陈賝
 * @since 2023/6/13 13:53
 */
@RequiredArgsConstructor
@Getter
public enum AfterSaleOperateTypeEnum {

    MEMBER_CREATE(10, "Member apply please refund"),
    ADMIN_AGREE_APPLY(11, "Merchant approved refund"),
    ADMIN_DISAGREE_APPLY(12, "Merchant rejected refund"),
    MEMBER_DELIVERY(20, "Member submitted return shipping. Carrier: {deliveryName}. Tracking: {logisticsNo}"),
    ADMIN_AGREE_RECEIVE(21, "Merchant received"),
    ADMIN_DISAGREE_RECEIVE(22, "Merchant rejected receive. Reason: {reason}"),
    ADMIN_REFUND(30, "Merchant started a refund"),
    SYSTEM_REFUND_SUCCESS(31, "Refund succeeded"),
    SYSTEM_REFUND_FAIL(32, "Refund failed"),
    MEMBER_CANCEL(40, "Membercancel refund"),
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
