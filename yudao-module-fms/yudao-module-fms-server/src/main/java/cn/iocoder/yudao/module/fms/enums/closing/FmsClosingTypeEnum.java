package cn.iocoder.yudao.module.fms.enums.closing;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * FMS 结账业务类型枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum FmsClosingTypeEnum implements ArrayValuable<Integer> {

    REGULAR(1, "Regular close", null),
    PROFIT_LOSS(2, "Close P&L", "Close current P&L"),
    UNPAID_VAT(3, "Output unpaid VAT", "Output unpaid VAT"),
    LOCAL_TAX(4, "Accrue local tax", "Accrue local tax"),
    INCOME_TAX(5, "Accrue income tax", "Accrue income tax");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(FmsClosingTypeEnum::getType).toArray(Integer[]::new);

    /**
     * 类型
     */
    private final Integer type;
    /**
     * 名字
     */
    private final String name;
    /**
     * 默认凭证摘要
     */
    private final String digest;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static FmsClosingTypeEnum valueOf(Integer type) {
        return ArrayUtil.firstMatch(item -> item.getType().equals(type), values());
    }

}
