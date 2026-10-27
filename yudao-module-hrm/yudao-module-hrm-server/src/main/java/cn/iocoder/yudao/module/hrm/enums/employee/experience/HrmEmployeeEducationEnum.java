package cn.iocoder.yudao.module.hrm.enums.employee.experience;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * HRM 员工学历枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmEmployeeEducationEnum implements ArrayValuable<Integer> {

    PRIMARY_SCHOOL(1, "Elementary"),
    JUNIOR_HIGH_SCHOOL(2, "Middle school"),
    SECONDARY_TECHNICAL_SCHOOL(3, "Technical secondary"),
    SECONDARY_VOCATIONAL_SCHOOL(4, "Vocational secondary"),
    TECHNICAL_SCHOOL(5, "Technical school"),
    HIGH_SCHOOL(6, "High school"),
    COLLEGE(7, "Associate"),
    BACHELOR(8, "Bachelor"),
    MASTER(9, "Master"),
    DOCTOR(10, "Doctorate"),
    POSTDOCTORAL(11, "Doctorate after"),
    OTHER(12, "Other");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(HrmEmployeeEducationEnum::getEducation).toArray(Integer[]::new);

    /**
     * 学历
     */
    private final Integer education;
    /**
     * 名字
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static HrmEmployeeEducationEnum valueOf(Integer education) {
        return ArrayUtil.firstMatch(item -> item.getEducation().equals(education), values());
    }

}
