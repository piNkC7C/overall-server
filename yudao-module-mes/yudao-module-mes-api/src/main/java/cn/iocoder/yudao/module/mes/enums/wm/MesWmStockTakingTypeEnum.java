package cn.iocoder.yudao.module.mes.enums.wm;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * MES 盘点类型枚举
 */
@Getter
@AllArgsConstructor
public enum MesWmStockTakingTypeEnum implements ArrayValuable<Integer> {

    STATIC(1, "Static count"),
    DYNAMIC(2, "Dynamic count");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(MesWmStockTakingTypeEnum::getType).toArray(Integer[]::new);

    /**
     * 盘点类型
     */
    private final Integer type;
    /**
     * 类型名称
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
