package cn.iocoder.yudao.module.promotion.enums.common;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 营销类型枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum PromotionTypeEnum implements ArrayValuable<Integer> {

    SECKILL_ACTIVITY(1, "Flash sale campaign."),
    BARGAIN_ACTIVITY(2, "Bargain campaign."),
    COMBINATION_ACTIVITY(3, "Group buy campaign."),

    DISCOUNT_ACTIVITY(4, "Limited-time discount"),
    REWARD_ACTIVITY(5, "Spend-and-save."),

    MEMBER_LEVEL(6, "Member discount."),
    COUPON(7, "Coupon."),
    POINT(8, "Points.")
    ;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(PromotionTypeEnum::getType).toArray(Integer[]::new);

    /**
     * 类型值
     */
    private final Integer type;
    /**
     * 类型名
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
