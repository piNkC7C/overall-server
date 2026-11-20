package cn.iocoder.yudao.module.bpm.enums.schedule;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum BpmSchedulePriorityEnum implements ArrayValuable<Integer> {

    NORMAL(1, "Normal"),
    IMPORTANT(2, "Important"),
    URGENT(3, "Urgent"),
    IMPORTANT_AND_URGENT(4, "Important and urgent");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(BpmSchedulePriorityEnum::getPriority).toArray(Integer[]::new);

    private final Integer priority;
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
