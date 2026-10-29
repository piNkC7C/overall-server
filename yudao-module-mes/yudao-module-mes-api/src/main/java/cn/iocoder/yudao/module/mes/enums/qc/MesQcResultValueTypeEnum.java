package cn.iocoder.yudao.module.mes.enums.qc;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * MES 质检值类型枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum MesQcResultValueTypeEnum implements ArrayValuable<Integer> {

    FLOAT(1, "Float"),
    INTEGER(2, "Integer"),
    TEXT(3, "Text"),
    DICT(4, "Dictionary"),
    FILE(5, "File");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(MesQcResultValueTypeEnum::getType).toArray(Integer[]::new);

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
