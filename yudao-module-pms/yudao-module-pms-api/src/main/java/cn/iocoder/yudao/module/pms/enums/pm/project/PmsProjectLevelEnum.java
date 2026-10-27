package cn.iocoder.yudao.module.pms.enums.pm.project;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * PMS 项目优先级枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum PmsProjectLevelEnum implements ArrayValuable<Integer> {

    HIGHEST(1, "Highest"),
    HIGH(2, "High"),
    NORMAL(3, "Normal"),
    LOW(4, "Low"),
    LOWEST(5, "Lowest");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(PmsProjectLevelEnum::getLevel)
            .toArray(Integer[]::new);

    /**
     * 优先级
     */
    private final Integer level;
    /**
     * 名称
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static PmsProjectLevelEnum valueOf(Integer level) {
        return ArrayUtil.firstMatch(item -> item.getLevel().equals(level), values());
    }

}
