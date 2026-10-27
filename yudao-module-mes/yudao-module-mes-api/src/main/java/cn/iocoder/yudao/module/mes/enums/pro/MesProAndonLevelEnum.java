package cn.iocoder.yudao.module.mes.enums.pro;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * MES 安灯级别枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum MesProAndonLevelEnum implements ArrayValuable<Integer> {

    LEVEL1(1, "Level 1"),
    LEVEL2(2, "Level 2"),
    LEVEL3(3, "Level 3");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(MesProAndonLevelEnum::getLevel).toArray(Integer[]::new);

    /**
     * 级别值
     */
    private final Integer level;
    /**
     * 级别名
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
