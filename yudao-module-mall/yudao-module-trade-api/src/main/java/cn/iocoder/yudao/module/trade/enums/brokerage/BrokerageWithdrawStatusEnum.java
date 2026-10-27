package cn.iocoder.yudao.module.trade.enums.brokerage;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 佣金提现状态枚举
 *
 * @author owen
 */
@AllArgsConstructor
@Getter
public enum BrokerageWithdrawStatusEnum implements ArrayValuable<Integer> {

    AUDITING(0, "Approval."),
    AUDIT_SUCCESS(10, "Approval via."),
    WITHDRAW_SUCCESS(11, "Withdrawal succeeded."),
    AUDIT_FAIL(20, "Approval not via."),
    WITHDRAW_FAIL(21, "Withdrawal failed."),
    ;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(BrokerageWithdrawStatusEnum::getStatus).toArray(Integer[]::new);

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
