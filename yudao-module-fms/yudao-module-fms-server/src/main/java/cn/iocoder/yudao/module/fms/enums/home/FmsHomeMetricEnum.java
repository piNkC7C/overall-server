package cn.iocoder.yudao.module.fms.enums.home;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * FMS 首页财务指标枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum FmsHomeMetricEnum {

    INCOME("income", "Revenue", new Integer[]{1}, "L1"),
    OPERATING_COST("operatingCost", "Cost", new Integer[]{2, 3}, "L2+L3"),
    PROFIT("profit", "Profit", new Integer[]{30}, "L30"),
    EXPENSE("expense", "Expense", new Integer[]{11, 14, 18}, "L11+L14+L18"),
    OTHER("other", "Other", new Integer[]{}, "L30+L11+L14+L18+L2+L3-L1");

    /**
     * 指标标识
     */
    private final String key;
    /**
     * 指标名称
     */
    private final String name;
    /**
     * 利润表行次数组
     */
    private final Integer[] rowNumbers;
    /**
     * 科目构成行次公式
     */
    private final String structureFormula;

    public static FmsHomeMetricEnum valueOfKey(String key) {
        return Arrays.stream(values()).filter(item -> item.getKey().equals(key))
                .findFirst().orElse(null);
    }

}
