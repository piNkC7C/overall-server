package cn.iocoder.yudao.framework.ip.core.enums;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 区域类型枚举
 *
 * @author 芋道源码
 */
@AllArgsConstructor
@Getter
public enum AreaTypeEnum implements ArrayValuable<Integer> {

    COUNTRY(1, "Country"),
    PROVINCE(2, "province"),
    CITY(3, "City"),
    DISTRICT(4, "region"), // 县、镇、区等
    ;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(AreaTypeEnum::getType).toArray(Integer[]::new);

    /**
     * 类型
     */
    private final Integer type;
    /**
     * 名字
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }
}
