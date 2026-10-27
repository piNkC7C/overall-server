package cn.iocoder.yudao.module.mes.enums.dv;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * MES 维修结果枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum MesDvRepairResultEnum implements ArrayValuable<Integer> {

    PASS(1, "Via."),
    FAIL(2, "Not via.");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(MesDvRepairResultEnum::getResult).toArray(Integer[]::new);

    /**
     * 结果值
     */
    private final Integer result;
    /**
     * 结果名
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
