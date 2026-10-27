package cn.iocoder.yudao.module.oa.enums.schedule;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 日程类型枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum OaScheduleTypeEnum implements ArrayValuable<Integer> {

    REMINDER(1, "Event Reminder"),
    HOLIDAY(2, "Holiday schedule");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(OaScheduleTypeEnum::getType).toArray(Integer[]::new);

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
