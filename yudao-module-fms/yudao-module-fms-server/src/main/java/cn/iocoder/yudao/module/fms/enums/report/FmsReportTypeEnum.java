package cn.iocoder.yudao.module.fms.enums.report;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * FMS 财务报表类型枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum FmsReportTypeEnum implements ArrayValuable<Integer> {

    BALANCE_SHEET(1, "Balance sheet"),
    INCOME_STATEMENT(2, "Income statement"),
    CASH_FLOW_STATEMENT(3, "Cash Flow Statement"),
    CASH_FLOW_ADJUSTMENT(4, "Cash-flow auxiliary data");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(FmsReportTypeEnum::getType).toArray(Integer[]::new);

    /**
     * 类型
     */
    private final Integer type;
    /**
     * 名字
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static FmsReportTypeEnum valueOf(Integer type) {
        return ArrayUtil.firstMatch(item -> item.getType().equals(type), values());
    }

}
