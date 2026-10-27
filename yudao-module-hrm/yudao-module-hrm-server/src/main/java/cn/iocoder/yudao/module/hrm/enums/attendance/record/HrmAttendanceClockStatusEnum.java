package cn.iocoder.yudao.module.hrm.enums.attendance.record;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * HRM 考勤打卡状态
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmAttendanceClockStatusEnum implements ArrayValuable<Integer> {

    NORMAL(0, "Normal"),
    LATE(1, "Late."),
    EARLY(2, "Left early."),
    MISS_CARD(3, "Missed punch.");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(HrmAttendanceClockStatusEnum::getStatus).toArray(Integer[]::new);

    private final Integer status;
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static HrmAttendanceClockStatusEnum valueOf(Integer status) {
        return ArrayUtil.firstMatch(item -> item.getStatus().equals(status), values());
    }

}
