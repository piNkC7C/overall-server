package cn.iocoder.yudao.module.hrm.enums.attendance.config;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * HRM 考勤迟到早退扣款方式
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmAttendanceLateEarlyDeductMethodEnum implements ArrayValuable<Integer> {

    FIXED_MONTH(1, "Fixed monthly deduction"),
    BY_MINUTE(2, "Deduct by minute"),
    BY_COUNT(3, "Deduct by count");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(HrmAttendanceLateEarlyDeductMethodEnum::getMethod).toArray(Integer[]::new);

    private final Integer method;
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static HrmAttendanceLateEarlyDeductMethodEnum valueOf(Integer method) {
        return ArrayUtil.firstMatch(item -> item.getMethod().equals(method), values());
    }

}
