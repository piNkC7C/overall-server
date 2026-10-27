package cn.iocoder.yudao.module.iot.core.enums.modbus;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * IoT Modbus 字节序枚举
 *
 * @author 芋道源码
 */
@Getter
@RequiredArgsConstructor
public enum IotModbusByteOrderEnum implements ArrayValuable<String> {

    AB("AB", "Big-endian (16-bit)", 2),
    BA("BA", "Little-endian (16-bit)", 2),
    ABCD("ABCD", "Big-endian (32-bit)", 4),
    CDAB("CDAB", "Big-endian word swap (32-bit)", 4),
    DCBA("DCBA", "Little-endian (32-bit)", 4),
    BADC("BADC", "Little-endian word swap (32-bit)", 4);

    public static final String[] ARRAYS = Arrays.stream(values())
            .map(IotModbusByteOrderEnum::getOrder)
            .toArray(String[]::new);

    /**
     * 字节序
     */
    private final String order;
    /**
     * 名称
     */
    private final String name;
    /**
     * 字节数
     */
    private final Integer byteCount;

    @Override
    public String[] array() {
        return ARRAYS;
    }

    public static IotModbusByteOrderEnum getByOrder(String order) {
        return Arrays.stream(values())
                .filter(e -> e.getOrder().equals(order))
                .findFirst()
                .orElse(null);
    }

}
