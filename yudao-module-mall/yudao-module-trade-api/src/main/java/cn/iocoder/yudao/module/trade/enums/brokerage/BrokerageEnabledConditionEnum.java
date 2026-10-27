package cn.iocoder.yudao.module.trade.enums.brokerage;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 分佣模式枚举
 *
 * @author owen
 */
@AllArgsConstructor
@Getter
public enum BrokerageEnabledConditionEnum implements ArrayValuable<Integer> {

    /**
     * 所有用户都可以分销
     */
    ALL(1, "Open distribution"),
    /**
     * 仅可后台手动设置推广员
     */
    ADMIN(2, "Assigned distribution"),
    ;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(BrokerageEnabledConditionEnum::getCondition).toArray(Integer[]::new);

    /**
     * 模式
     */
    private final Integer condition;
    /**
     * 名字
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
