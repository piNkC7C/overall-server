package cn.iocoder.yudao.module.pay.enums.refund;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * 渠道的退款状态枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum PayRefundStatusEnum {

    WAITING(0, "Not refunded"),
    SUCCESS(10, "Refund succeeded"),
    FAILURE(20, "Refund failed");

    private final Integer status;
    private final String name;

    public static boolean isSuccess(Integer status) {
        return Objects.equals(status, SUCCESS.getStatus());
    }

    public static boolean isFailure(Integer status) {
        return Objects.equals(status, FAILURE.getStatus());
    }

}
