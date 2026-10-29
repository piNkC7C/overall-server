package cn.iocoder.yudao.module.pay.enums.notify;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 支付通知状态枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum PayNotifyStatusEnum {

    WAITING(0, "Waiting for notification"),
    SUCCESS(10, "Notification succeeded"),
    FAILURE(20, "Notification failed"), // 多次尝试，彻底失败
    REQUEST_SUCCESS(21, "Request succeeded but the result failed"),
    REQUEST_FAILURE(22, "Request failed"),

    ;

    /**
     * 状态
     */
    private final Integer status;
    /**
     * 名字
     */
    private final String name;

}
