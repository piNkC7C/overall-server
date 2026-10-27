package cn.iocoder.yudao.module.hrm.enums.employee.experience;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * HRM 员工教育经历教学方式枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmEmployeeTeachingMethodEnum implements ArrayValuable<Integer> {

    FULL_TIME(1, "Full-time study"),
    ADULT_EDUCATION(2, "Adult education"),
    DISTANCE_EDUCATION(3, "Distance education"),
    SELF_STUDY_EXAMINATION(4, "Self-study exam"),
    OTHER(5, "Other");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(HrmEmployeeTeachingMethodEnum::getMethod).toArray(Integer[]::new);

    /**
     * 教学方式
     */
    private final Integer method;
    /**
     * 名字
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static HrmEmployeeTeachingMethodEnum valueOf(Integer method) {
        return ArrayUtil.firstMatch(item -> item.getMethod().equals(method), values());
    }

}
