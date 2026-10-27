package cn.iocoder.yudao.module.bpm.enums.definition;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * BPM 模型的表单类型的枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum BpmModelFormTypeEnum implements ArrayValuable<Integer> {

    NORMAL(10, "Workflow form"),
    CUSTOM(20, "Business form"),
    ;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(BpmModelFormTypeEnum::getType).toArray(Integer[]::new);

    private final Integer type;
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
