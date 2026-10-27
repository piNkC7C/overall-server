package cn.iocoder.yudao.module.member.enums.point;

import cn.hutool.core.util.EnumUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * 会员积分的业务类型枚举
 *
 * @author 芋道源码
 */
@AllArgsConstructor
@Getter
public enum MemberPointBizTypeEnum implements ArrayValuable<Integer> {

    SIGN(1, "Check-in", "Checked in and earned {} points", true),
    ADMIN(2, "Admin edit.", "Admin edit {} points.", true),

    ORDER_USE(11, "Order points offset", "Order used {} points.", false), // 下单时，扣减积分
    ORDER_USE_CANCEL(12, "Order points offset (order canceled)", "Order canceled. Refunded {} points", true), // ORDER_USE cancel
    ORDER_USE_CANCEL_ITEM(13, "Order points offset (item refunded)", "Order refunded. Restored {} points", true), // ORDER_USE cancel

    ORDER_GIVE(21, "Order points reward", "Order get {} points.", true), // 支付订单时，赠送积分
    ORDER_GIVE_CANCEL(22, "Order points reward (order canceled)", "Order canceled. Refunded {} points", false), // ORDER_GIVE cancel
    ORDER_GIVE_CANCEL_ITEM(23, "Order points reward (item refunded)", "Order refunded. Deducted {} bonus points", false) // ORDER_GIVE cancel
    ;

    /**
     * 类型
     */
    private final Integer type;
    /**
     * 名字
     */
    private final String name;
    /**
     * 描述
     */
    private final String description;
    /**
     * 是否为扣减积分
     */
    private final boolean add;

    @Override
    public Integer[] array() {
        return new Integer[0];
    }

    public static MemberPointBizTypeEnum getByType(Integer type) {
        return EnumUtil.getBy(MemberPointBizTypeEnum.class,
                e -> Objects.equals(type, e.getType()));
    }

}
