package cn.iocoder.yudao.module.hrm.enums.salary.config;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import cn.iocoder.yudao.framework.common.util.collection.SetUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * HRM 预置薪资项目编码枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmSalaryOptionCodeEnum implements ArrayValuable<Integer> {

    BASIC_SALARY(10101, "Base salary"),
    POST_SALARY(10102, "Job salary"),
    MEAL_ALLOWANCE(20104, "Meal allowance"),

    OVERTIME_PAY(180101, "Overtime pay"),
    LATE_DEDUCTION(190101, "Latededuction"),
    EARLY_DEDUCTION(190102, "Left Earlydeduction"),
    ABSENTEEISM_DEDUCTION(190103, "Absencededuction"),
    LEAVE_DEDUCTION(190104, "Leave deduction"),
    MISSING_CARD_DEDUCTION(190105, "Missed Punchdeduction"),
    COMPREHENSIVE_DEDUCTION(190106, "Combined deduction"),
    ATTENDANCE_DEDUCTION_TOTAL(200101, "Attendance deductions"),

    PERSONAL_INSURANCE(100101, "Person social security"),
    PERSONAL_PROVIDENT_FUND(100102, "Employee Housing Fund"),
    CORPORATE_INSURANCE(110101, "Company social security"),
    CORPORATE_PROVIDENT_FUND(120101, "Company Housing Fund"),

    EXPECTED_PAY(210101, "Gross Pay"),
    TAXABLE(220101, "Taxable wages"),
    PERSONAL_TAX(230101, "Income Tax"),
    REAL_PAY(240101, "Net pay"),

    LAST_MONTH_CUMULATIVE_INCOME(250101, "YTD income (through last month)"),
    LAST_MONTH_CUMULATIVE_DEDUCT_EXPENSE(250102, "YTD standard deduction (through last month)"),
    LAST_MONTH_CUMULATIVE_SPECIAL_DEDUCTION(250103, "YTD special deduction (through last month)"),
    LAST_MONTH_PREPAID_TAX(250105, "YTD prepaid tax"),

    CHILD_EDUCATION_DEDUCTION(260101, "YTD child education"),
    HOUSE_RENT_DEDUCTION(260102, "YTD rent"),
    HOUSE_LOAN_DEDUCTION(260103, "YTD mortgage interest"),
    ELDERLY_SUPPORT_DEDUCTION(260104, "YTD elder care"),
    CONTINUING_EDUCATION_DEDUCTION(260105, "YTD continuing education"),

    CURRENT_CUMULATIVE_INCOME(270101, "YTD income"),
    CURRENT_CUMULATIVE_DEDUCT_EXPENSE(270102, "YTD standard deduction"),
    CURRENT_CUMULATIVE_SPECIAL_DEDUCTION(270103, "YTD special deduction"),
    CURRENT_CUMULATIVE_ADDITIONAL_DEDUCTION(270104, "YTD additional special deduction"),
    CURRENT_CUMULATIVE_TAXABLE(270105, "YTD taxable income"),
    CURRENT_CUMULATIVE_TAX(270106, "YTD tax due");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(HrmSalaryOptionCodeEnum::getCode).toArray(Integer[]::new);

    /**
     * 系统计算的薪资项编码集合
     */
    public static final Set<Integer> COMPUTED_CODES = Collections.unmodifiableSet(SetUtils.asSet(
            EXPECTED_PAY.getCode(), TAXABLE.getCode(), PERSONAL_TAX.getCode(), REAL_PAY.getCode(),
            CURRENT_CUMULATIVE_INCOME.getCode(), CURRENT_CUMULATIVE_DEDUCT_EXPENSE.getCode(),
            CURRENT_CUMULATIVE_SPECIAL_DEDUCTION.getCode(), CURRENT_CUMULATIVE_ADDITIONAL_DEDUCTION.getCode(),
            CURRENT_CUMULATIVE_TAXABLE.getCode(), CURRENT_CUMULATIVE_TAX.getCode()));

    /**
     * 默认工资条模板的薪资项编码
     */
    public static final List<Integer> SALARY_SLIP_DEFAULT_CODES = Collections.unmodifiableList(Arrays.asList(
            BASIC_SALARY.getCode(), POST_SALARY.getCode(), EXPECTED_PAY.getCode(),
            PERSONAL_TAX.getCode(), REAL_PAY.getCode()));

    /**
     * 默认工资条模板基本项编码
     */
    public static final Set<Integer> SALARY_SLIP_BASIC_CODES = Collections.unmodifiableSet(SetUtils.asSet(
            EXPECTED_PAY.getCode(), PERSONAL_TAX.getCode(), REAL_PAY.getCode()));

    /**
     * 上月累计薪资项编码集合
     */
    public static final List<Integer> LAST_MONTH_CUMULATIVE_CODES = Collections.unmodifiableList(Arrays.asList(
            LAST_MONTH_CUMULATIVE_INCOME.getCode(), LAST_MONTH_CUMULATIVE_DEDUCT_EXPENSE.getCode(),
            LAST_MONTH_CUMULATIVE_SPECIAL_DEDUCTION.getCode(), LAST_MONTH_PREPAID_TAX.getCode()));

    /**
     * 员工薪资信息导入排除的父薪资项编码集合
     */
    public static final Set<Integer> EMPLOYEE_INFO_IMPORT_EXCLUDED_PARENT_CODES =
            Collections.unmodifiableSet(SetUtils.asSet(180, 190, 200, 210, 220, 230, 240, 250, 260));

    /**
     * 编码
     */
    private final Integer code;
    /**
     * 名称
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static HrmSalaryOptionCodeEnum valueOf(Integer code) {
        return ArrayUtil.firstMatch(item -> item.getCode().equals(code), values());
    }

}
