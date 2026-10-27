package cn.iocoder.yudao.module.iot.gateway.protocol.websocket;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * IoT WebSocket 协议配置
 *
 * @author 芋道源码
 */
@Data
public class IotWebSocketConfig {

    /**
     * WebSocket 路径（默认：/ws）
     */
    @NotEmpty(message = "WebSocket path cannot be empty.")
    private String path = "/ws";

    /**
     * 最大消息大小（字节，默认 64KB）
     */
    @NotNull(message = "Maximum message size cannot be empty.")
    private Integer maxMessageSize = 65536;
    /**
     * 最大帧大小（字节，默认 64KB）
     */
    @NotNull(message = "Maximum frame size cannot be empty.")
    private Integer maxFrameSize = 65536;

    /**
     * 空闲超时时间（秒，默认 60）
     */
    @NotNull(message = "Idle timeout cannot be empty.")
    private Integer idleTimeoutSeconds = 60;

}
