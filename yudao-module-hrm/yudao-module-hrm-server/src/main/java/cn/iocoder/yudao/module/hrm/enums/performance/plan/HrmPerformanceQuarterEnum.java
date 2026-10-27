package cn.iocoder.yudao.module.hrm.enums.performance.plan;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * HRM 绩效考核季度枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmPerformanceQuarterEnum implements ArrayValuable<Integer> {

    FIRST_QUARTER(1, "Q1"),
    SECOND_QUARTER(2, "Q2"),
    THIRD_QUARTER(3, "Q3"),
    FOURTH_QUARTER(4, "Q4");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(HrmPerformanceQuarterEnum::getQuarter).toArray(Integer[]::new);

    /**
     * 季度
     */
    private final Integer quarter;
    /**
     * 名称
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static HrmPerformanceQuarterEnum valueOf(Integer quarter) {
        return ArrayUtil.firstMatch(item -> item.getQuarter().equals(quarter), values());
    }

}
