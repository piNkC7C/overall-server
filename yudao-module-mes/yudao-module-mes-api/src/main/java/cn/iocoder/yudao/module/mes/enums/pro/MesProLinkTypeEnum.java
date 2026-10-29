package cn.iocoder.yudao.module.mes.enums.pro;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * MES 工序关系类型枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum MesProLinkTypeEnum implements ArrayValuable<Integer> {

    START_START(0, "Start - start"),
    FINISH_FINISH(1, "End - end"),
    START_FINISH(2, "Start - end"),
    FINISH_START(3, "End - start");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(MesProLinkTypeEnum::getType).toArray(Integer[]::new);

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
