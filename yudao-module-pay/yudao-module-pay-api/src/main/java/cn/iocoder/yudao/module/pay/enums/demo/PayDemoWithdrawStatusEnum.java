package cn.iocoder.yudao.module.pay.enums.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * 示例提现单的状态枚举
 *
 * @author jason
 */
@Getter
@AllArgsConstructor
public enum PayDemoWithdrawStatusEnum {

    WAITING(0, "Waiting for withdrawal"),
    SUCCESS(10, "Withdrawal succeeded"),
    CLOSED(20, "Withdrawal disable");

    /**
     * 状态
     */
    private final Integer status;
    /**
     * 状态名
     */
    private final String name;

    public static boolean isSuccess(Integer status) {
        return Objects.equals(status, SUCCESS.getStatus());
    }

    public static boolean isClosed(Integer status) {
        return Objects.equals(status, CLOSED.getStatus());
    }

    public static boolean isWaiting(Integer status) {
        return Objects.equals(status, WAITING.getStatus());
    }

}
