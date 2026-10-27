package cn.iocoder.yudao.module.wms.enums.order;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * WMS 单据类型枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum WmsOrderTypeEnum implements ArrayValuable<Integer> {

    RECEIPT(1, "Inbound order."),
    SHIPMENT(2, "Outbound order."),
    MOVEMENT(3, "Warehouse transfer order."),
    CHECK(4, "Inventory count order.");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(WmsOrderTypeEnum::getType).toArray(Integer[]::new);

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
