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

    ENTRY_SALARY(0, "Starting pay"),
    ENTRY_CONFIRM(1, "Pay confirmation"),
    REGULAR(2, "Confirmation"),
    PROMOTION(3, "Job promotion"),
    TRANSFER(4, "Transfer"),
    MID_YEAR_ADJUSTMENT(5, "Mid-year adjustment"),
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
        HrmSalaryChangeReasonEnum found = ArrayUtil.firstMatch(item -> item.getName().equals(name), values());
        if (found != null) {
            return found;
        }
        return switch (name) {
            case "OnboardingSet Salary", "Onboarding Set Pay", "入职定薪" -> ENTRY_SALARY;
            case "Hire setup", "Onboarding Review Set", "入职核定" -> ENTRY_CONFIRM;
            case "Year Salary Change", "年中调薪" -> MID_YEAR_ADJUSTMENT;
            case "转正" -> REGULAR;
            case "Promotion", "晋升" -> PROMOTION;
            case "调动" -> TRANSFER;
            case "年度调薪" -> ANNUAL_ADJUSTMENT;
            case "特别调薪" -> SPECIAL_ADJUSTMENT;
            case "其他" -> OTHER;
            default -> null;
        };
    }

}
