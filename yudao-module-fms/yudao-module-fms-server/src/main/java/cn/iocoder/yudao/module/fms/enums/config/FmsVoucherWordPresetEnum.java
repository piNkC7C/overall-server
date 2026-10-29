package cn.iocoder.yudao.module.fms.enums.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * FMS 预置凭证字枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum FmsVoucherWordPresetEnum {

    RECORD("General", "Journal Voucher", true, 1),
    RECEIPT("Receipt", "Receipt journal entry", false, 2),
    TRANSFER("Transfer", "Transfer journal entry", false, 3),
    PAYMENT("Payment", "Payment journal entry", false, 4);

    /**
     * 凭证字
     */
    private final String name;
    /**
     * 打印标题
     */
    private final String printTitle;
    /**
     * 是否默认凭证字
     */
    private final Boolean defaultStatus;
    /**
     * 显示顺序
     */
    private final Integer sort;

}
