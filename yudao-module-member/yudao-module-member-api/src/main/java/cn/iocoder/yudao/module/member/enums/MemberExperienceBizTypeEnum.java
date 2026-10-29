package cn.iocoder.yudao.module.member.enums;

import cn.hutool.core.util.EnumUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * 会员经验 - 业务类型
 *
 * @author owen
 */
@Getter
@AllArgsConstructor
public enum MemberExperienceBizTypeEnum {

    /**
     * 管理员调整、邀请新用户、下单、退单、签到、抽奖
     */
    ADMIN(0, "Admin adjust", "Admin adjust get {} experience.", true),
    INVITE_REGISTER(1, "Invite reward", "Invited a friend and earned {} XP", true),
    SIGN_IN(4, "Check-in reward", "Checked in and earned {} XP", true),
    LOTTERY(5, "Lottery reward", "Lottery earned {} XP", true),
    ORDER_GIVE(11, "Order reward", "Order get {} experience.", true),
    ORDER_GIVE_CANCEL(12, "Order reward (order canceled)", "Order canceled. Deducted {} XP", false),
    ORDER_GIVE_CANCEL_ITEM(13, "Order reward (item refunded)", "Item refunded. Deducted {} XP", false),
    ;

    /**
     * 业务类型
     */
    private final int type;
    /**
     * 标题
     */
    private final String title;
    /**
     * 描述
     */
    private final String description;
    /**
     * 是否为扣减积分
     */
    private final boolean add;

    public static MemberExperienceBizTypeEnum getByType(Integer type) {
        return EnumUtil.getBy(MemberExperienceBizTypeEnum.class,
                e -> Objects.equals(type, e.getType()));
    }
}
