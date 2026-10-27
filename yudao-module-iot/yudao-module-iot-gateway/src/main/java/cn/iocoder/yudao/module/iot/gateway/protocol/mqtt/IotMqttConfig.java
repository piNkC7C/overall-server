package cn.iocoder.yudao.module.iot.gateway.protocol.mqtt;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * IoT 网关 MQTT 协议配置
 *
 * @author 芋道源码
 */
@Data
public class IotMqttConfig {

    /**
     * 最大消息大小（字节）
     */
    @NotNull(message = "Maximum message size cannot be empty.")
    @Min(value = 1024, message = "Maximum message size cannot be less than 1024 bytes.")
    private Integer maxMessageSize = 8192;

    /**
     * 连接超时时间（秒）
     */
    @NotNull(message = "Connection timeout cannot be empty.")
    @Min(value = 1, message = "Connection timeout cannot be less than 1 second.")
    private Integer connectTimeoutSeconds = 60;

}
