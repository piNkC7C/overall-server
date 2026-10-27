package cn.iocoder.yudao.module.iot.gateway.protocol.coap;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * IoT CoAP 协议配置
 *
 * @author 芋道源码
 */
@Data
public class IotCoapConfig {

    /**
     * 最大消息大小（字节）
     */
    @NotNull(message = "Maximum message size cannot be empty.")
    @Min(value = 64, message = "Maximum message size must be greater than 64 bytes.")
    private Integer maxMessageSize = 1024;

    /**
     * ACK 超时时间（毫秒）
     */
    @NotNull(message = "ACK timeout cannot be empty.")
    @Min(value = 100, message = "ACK timeout must be greater than 100 ms.")
    private Integer ackTimeoutMs = 2000;

    /**
     * 最大重传次数
     */
    @NotNull(message = "Maximum retries cannot be empty.")
    @Min(value = 0, message = "Maximum retries must be greater than or equal to 0.")
    private Integer maxRetransmit = 4;

}
