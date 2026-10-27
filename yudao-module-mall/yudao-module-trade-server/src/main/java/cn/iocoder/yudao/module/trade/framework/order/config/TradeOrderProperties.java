package cn.iocoder.yudao.module.trade.framework.order.config;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotNull;

import java.time.Duration;

/**
 * 交易订单的配置项
 *
 * @author LeeYan9
 * @since 2022-09-15
 */
@ConfigurationProperties(prefix = "yudao.trade.order")
@Data
@Validated
public class TradeOrderProperties {

    private static final String PAY_APP_KEY_DEFAULT = "mall";

    /**
     * 支付应用标识
     *
     * 在 pay 模块的 [支付管理 -> 应用信息] 里添加
     */
    @NotEmpty(message = "Pay app key is required.")
    private String payAppKey = PAY_APP_KEY_DEFAULT;

    /**
     * 支付超时时间
     */
    @NotNull(message = "Payment timeout cannot be empty.")
    private Duration payExpireTime;

    /**
     * 收货超时时间
     */
    @NotNull(message = "Receive timeout cannot be empty.")
    private Duration receiveExpireTime;

    /**
     * 评论超时时间
     */
    @NotNull(message = "Review timeout cannot be empty.")
    private Duration commentExpireTime;

    /**
     * 是否同步订单状态到微信小程序
     */
    @NotNull(message = "Sync order status to the WeChat mini program cannot be empty.")
    private Boolean statusSyncToWxaEnable;

}
