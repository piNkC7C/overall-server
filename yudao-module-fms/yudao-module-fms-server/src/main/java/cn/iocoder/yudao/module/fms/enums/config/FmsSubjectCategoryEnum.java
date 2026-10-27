package cn.iocoder.yudao.module.fms.enums.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * FMS 科目类别枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum FmsSubjectCategoryEnum {

    CURRENT_ASSET(1, 1, "Current assets"),
    NON_CURRENT_ASSET(1, 2, "Non-current assets"),
    CURRENT_LIABILITY(2, 1, "Current liabilities"),
    NON_CURRENT_LIABILITY(2, 2, "Non-current liabilities"),
    EQUITY(3, 1, "Equity"),
    COST(4, 1, "Cost"),
    OPERATING_INCOME(5, 1, "Operating revenue"),
    OTHER_INCOME(5, 2, "Other income"),
    PERIOD_EXPENSE(5, 3, "Period expense"),
    OTHER_LOSS(5, 4, "Other loss"),
    OPERATING_COST_AND_TAX(5, 5, "Operating cost and tax"),
    PRIOR_YEAR_ADJUSTMENT(5, 6, "Prior-year P&L adjustment"),
    INCOME_TAX(5, 7, "Income tax"),
    COMMON(6, 1, "Shared");

    /**
     * 科目类型
     */
    private final Integer type;
    /**
     * 类别
     */
    private final Integer category;
    /**
     * 名字
     */
    private final String name;

    public static FmsSubjectCategoryEnum valueOf(Integer type, Integer category) {
        return Arrays.stream(values())
                .filter(item -> item.getType().equals(type) && item.getCategory().equals(category))
                .findFirst().orElse(null);
    }

    public static FmsSubjectCategoryEnum valueOfName(String name) {
        return Arrays.stream(values())
                .filter(item -> item.getName().equals(name))
                .findFirst().orElse(null);
    }

}
