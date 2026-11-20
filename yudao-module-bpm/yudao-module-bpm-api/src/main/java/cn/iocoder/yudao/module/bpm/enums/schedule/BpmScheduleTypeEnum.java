package cn.iocoder.yudao.module.bpm.enums.schedule;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum BpmScheduleTypeEnum implements ArrayValuable<Integer> {

    REMINDER(1, "Event Reminder"),
    HOLIDAY(2, "Holiday schedule");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(BpmScheduleTypeEnum::getType).toArray(Integer[]::new);

    private final Integer type;
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
