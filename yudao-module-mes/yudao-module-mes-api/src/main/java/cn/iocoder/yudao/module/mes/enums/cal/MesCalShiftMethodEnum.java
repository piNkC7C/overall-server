package cn.iocoder.yudao.module.mes.enums.cal;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * MES 倒班方式枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum MesCalShiftMethodEnum implements ArrayValuable<Integer> {

    QUARTER(1, "By quarter"),
    MONTH(2, "By month"),
    WEEK(3, "By week"),
    DAY(4, "By day");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(MesCalShiftMethodEnum::getMethod).toArray(Integer[]::new);

    /**
     * 方式值
     */
    private final Integer method;
    /**
     * 方式名
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
