package cn.iocoder.yudao.module.wms.enums.order;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * WMS 单据状态枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum WmsOrderStatusEnum implements ArrayValuable<Integer> {

    PREPARE(0, "Draft."),
    FINISHED(4, "Completed."),
    CANCELED(5, "Voided");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(WmsOrderStatusEnum::getStatus)
            .toArray(Integer[]::new);

    /**
     * 状态
     */
    private final Integer status;
    /**
     * 名称
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
