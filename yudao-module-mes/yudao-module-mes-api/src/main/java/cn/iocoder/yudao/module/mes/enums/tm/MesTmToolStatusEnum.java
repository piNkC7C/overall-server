package cn.iocoder.yudao.module.mes.enums.tm;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * MES 工具状态枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum MesTmToolStatusEnum implements ArrayValuable<Integer> {

    STORE(1, "In stock"),
    ISSUE(2, "In use"),
    REPAIR(3, "Maintenance"),
    SCRAP(4, "Scrapped");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(MesTmToolStatusEnum::getStatus).toArray(Integer[]::new);

    /**
     * 状态值
     */
    private final Integer status;
    /**
     * 状态名
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
