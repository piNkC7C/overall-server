package cn.iocoder.yudao.module.trade.enums.brokerage;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 佣金记录状态枚举
 *
 * @author owen
 */
@AllArgsConstructor
@Getter
public enum BrokerageRecordStatusEnum implements ArrayValuable<Integer> {

    WAIT_SETTLEMENT(0, "Pending settlement"),
    SETTLEMENT(1, "Settled"),
    CANCEL(2, "Canceled"),
    ;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(BrokerageRecordStatusEnum::getStatus).toArray(Integer[]::new);

    /**
     * 状态
     */
    private final Integer status;
    /**
     * 名字
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
