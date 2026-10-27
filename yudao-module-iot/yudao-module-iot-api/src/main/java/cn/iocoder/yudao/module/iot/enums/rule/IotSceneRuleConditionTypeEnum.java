package cn.iocoder.yudao.module.iot.enums.rule;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * IoT 条件类型枚举
 *
 * @author 芋道源码
 */
@RequiredArgsConstructor
@Getter
public enum IotSceneRuleConditionTypeEnum implements ArrayValuable<Integer> {

    DEVICE_STATE(1, "Device status."),
    DEVICE_PROPERTY(2, "Device attribute."),

    CURRENT_TIME(100, "Current time."),

    ;

    private final Integer type;
    private final String name;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(IotSceneRuleConditionTypeEnum::getType).toArray(Integer[]::new);

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static IotSceneRuleConditionTypeEnum typeOf(Integer type) {
        return ArrayUtil.firstMatch(item -> item.getType().equals(type), values());
    }

}
