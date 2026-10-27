package cn.iocoder.yudao.module.iot.gateway.protocol.udp;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * IoT UDP 协议配置
 *
 * @author 芋道源码
 */
@Data
public class IotUdpConfig {

    /**
     * 最大会话数
     */
    @NotNull(message = "Maximum sessions cannot be empty.")
    @Min(value = 1, message = "Maximum sessions must be greater than 0.")
    private Integer maxSessions = 1000;
    /**
     * 会话超时时间（毫秒）
     * <p>
     * 基于 Guava Cache 的 expireAfterAccess 实现自动过期清理
     */
    @NotNull(message = "Session timeout cannot be empty.")
    @Min(value = 1000, message = "Session timeout must be greater than 1000 ms.")
    private Long sessionTimeoutMs = 60000L;

    /**
     * 接收缓冲区大小（字节）
     */
    @NotNull(message = "Receive buffer size cannot be empty.")
    @Min(value = 1024, message = "Receive buffer size must be greater than 1024 bytes.")
    private Integer receiveBufferSize = 65536;
    /**
     * 发送缓冲区大小（字节）
     */
    @NotNull(message = "Send buffer size cannot be empty.")
    @Min(value = 1024, message = "Send buffer size must be greater than 1024 bytes.")
    private Integer sendBufferSize = 65536;

}
