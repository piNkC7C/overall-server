package cn.iocoder.yudao.module.hrm.enums.salary.employee;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * HRM 定薪调薪原因枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmSalaryChangeReasonEnum implements ArrayValuable<Integer> {

    ENTRY_SALARY(0, "OnboardingSet Salary"),
    ENTRY_CONFIRM(1, "Hire setup"),
    REGULAR(2, "Confirmation"),
    PROMOTION(3, "Promotion"),
    TRANSFER(4, "Transfer"),
    MID_YEAR_ADJUSTMENT(5, "Year Salary Change"),
    ANNUAL_ADJUSTMENT(6, "Annual raise"),
    SPECIAL_ADJUSTMENT(7, "Special raise"),
    OTHER(8, "Other");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(HrmSalaryChangeReasonEnum::getReason).toArray(Integer[]::new);

    /**
     * 原因
     */
    private final Integer reason;
    /**
     * 名称
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static HrmSalaryChangeReasonEnum valueOf(Integer reason) {
        return ArrayUtil.firstMatch(item -> item.getReason().equals(reason), values());
    }

    public static HrmSalaryChangeReasonEnum valueOfName(String name) {
        return ArrayUtil.firstMatch(item -> item.getName().equals(name), values());
    }

}
