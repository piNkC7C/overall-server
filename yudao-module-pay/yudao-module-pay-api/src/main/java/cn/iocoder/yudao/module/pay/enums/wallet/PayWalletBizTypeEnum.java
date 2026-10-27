package cn.iocoder.yudao.module.pay.enums.wallet;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 钱包交易业务分类
 *
 * @author jason
 */
@AllArgsConstructor
@Getter
public enum PayWalletBizTypeEnum implements ArrayValuable<Integer> {

    RECHARGE(1, "Top-up."),
    RECHARGE_REFUND(2, "Top-up refund."),
    PAYMENT(3, "Payment."),
    PAYMENT_REFUND(4, "Payment refund."),
    UPDATE_BALANCE(5, "Update balance."),
    TRANSFER(6, "Transfer.");

    /**
     * 业务分类
     */
    private final Integer type;
    /**
     * 说明
     */
    private final String description;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(PayWalletBizTypeEnum::getType).toArray(Integer[]::new);

    @Override
    public Integer[] array() {
         return ARRAYS;
    }

    public static PayWalletBizTypeEnum valueOf(Integer type) {
        return Arrays.stream(values()).filter(item -> item.getType().equals(type)).findFirst().orElse(null);
    }

}
