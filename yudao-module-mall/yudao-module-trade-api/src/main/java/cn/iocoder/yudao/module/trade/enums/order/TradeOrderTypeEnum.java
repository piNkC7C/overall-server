package cn.iocoder.yudao.module.trade.enums.order;

import cn.hutool.core.util.ObjectUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * 交易订单 - 类型
 *
 * @author Sin
 */
@RequiredArgsConstructor
@Getter
public enum TradeOrderTypeEnum implements ArrayValuable<Integer> {

    NORMAL(0, "Regular order"),
    SECKILL(1, "Flash sale order"),
    BARGAIN(2, "Bargain order"),
    COMBINATION(3, "Group buy order"),
    POINT(4, "Points shop"),
    ;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(TradeOrderTypeEnum::getType).toArray(Integer[]::new);

    /**
     * 类型
     */
    private final Integer type;
    /**
     * 类型名
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static boolean isNormal(Integer type) {
        return ObjectUtil.equal(type, NORMAL.getType());
    }

    public static boolean isSeckill(Integer type) {
        return ObjectUtil.equal(type, SECKILL.getType());
    }

    public static boolean isBargain(Integer type) {
        return ObjectUtil.equal(type, BARGAIN.getType());
    }

    public static boolean isCombination(Integer type) {
        return ObjectUtil.equal(type, COMBINATION.getType());
    }

    public static boolean isPoint(Integer type) {
        return ObjectUtil.equal(type, POINT.getType());
    }

}
