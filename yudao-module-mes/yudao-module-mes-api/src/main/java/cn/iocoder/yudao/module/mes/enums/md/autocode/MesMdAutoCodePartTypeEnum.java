package cn.iocoder.yudao.module.mes.enums.md.autocode;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * MES 编码规则分段类型枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum MesMdAutoCodePartTypeEnum implements ArrayValuable<Integer> {

    INPUT_CHAR(1, "Input text"),
    DATE(2, "Current Date"),
    FIXED_CHAR(3, "Fixed text"),
    SERIAL_NUMBER(4, "Sequence number");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(MesMdAutoCodePartTypeEnum::getType).toArray(Integer[]::new);

    /**
     * 类型
     */
    private final Integer type;
    /**
     * 名称
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
