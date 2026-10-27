package cn.iocoder.yudao.module.promotion.enums.banner;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * Banner Position 枚举
 *
 * @author HUIHUI
 */
@AllArgsConstructor
@Getter
public enum BannerPositionEnum implements ArrayValuable<Integer> {

    HOME_POSITION(1, "Home"),
    SECKILL_POSITION(2, "Flash-sale page"),
    COMBINATION_POSITION(3, "Bargain page"),
    DISCOUNT_POSITION(4, "Limited-discount page"),
    REWARD_POSITION(5, "Spend-and-save page");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(BannerPositionEnum::getPosition).toArray(Integer[]::new);

    /**
     * 值
     */
    private final Integer position;
    /**
     * 名字
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
