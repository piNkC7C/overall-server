package cn.iocoder.yudao.module.trade.enums.brokerage;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 佣金记录业务类型枚举
 *
 * @author owen
 */
@AllArgsConstructor
@Getter
public enum BrokerageRecordBizTypeEnum implements ArrayValuable<Integer> {

    ORDER(1, "Earned referral commission", "Earned referral commission {}", true),
    WITHDRAW(2, "Withdrawal apply please", "Withdrawal deducted commission {}", false),
    WITHDRAW_REJECT(3, "Withdrawal rejected", "Withdrawal rejected. Restored commission {}", true),
    ;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(BrokerageRecordBizTypeEnum::getType).toArray(Integer[]::new);

    /**
     * 类型
     */
    private final Integer type;
    /**
     * 标题
     */
    private final String title;
    /**
     * 描述
     */
    private final String description;
    /**
     * 是否为增加佣金
     */
    private final boolean add;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
