package cn.iocoder.yudao.framework.common.enums;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 时间间隔的枚举
 *
 * @author dhb52
 */
@Getter
@AllArgsConstructor
public enum DateIntervalEnum implements ArrayValuable<Integer> {

    HOUR(0, "Hour"), // 特殊：字典里，暂时不会有这个枚举！！！因为大多数情况下，用不到这个间隔
    DAY(1, "Days"),
    WEEK(2, "Week."),
    MONTH(3, "Month"),
    QUARTER(4, "Quarter"),
    YEAR(5, "Year")
    ;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(DateIntervalEnum::getInterval).toArray(Integer[]::new);

    /**
     * 类型
     */
    private final Integer interval;
    /**
     * 名称
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static DateIntervalEnum valueOf(Integer interval) {
        return ArrayUtil.firstMatch(item -> item.getInterval().equals(interval), DateIntervalEnum.values());
    }

}