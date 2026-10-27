package cn.iocoder.yudao.module.mes.enums.md.autocode;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * MES 编码规则循环方式枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum MesMdAutoCodeCycleMethodEnum implements ArrayValuable<Integer> {

    YEAR(1, "By year"),
    MONTH(2, "By month"),
    DAY(3, "By day"),
    HOUR(4, "By hour"),
    MINUTE(5, "By minute"),
    INPUT_CHAR(10, "By input text");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(MesMdAutoCodeCycleMethodEnum::getMethod).toArray(Integer[]::new);

    /**
     * 方式
     */
    private final Integer method;
    /**
     * 名称
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
