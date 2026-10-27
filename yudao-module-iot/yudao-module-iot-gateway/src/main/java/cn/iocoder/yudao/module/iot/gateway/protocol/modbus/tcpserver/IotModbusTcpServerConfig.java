package cn.iocoder.yudao.module.iot.gateway.protocol.modbus.tcpserver;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * IoT Modbus TCP Server 协议配置
 *
 * @author 芋道源码
 */
@Data
public class IotModbusTcpServerConfig {

    /**
     * 配置刷新间隔（秒）
     */
    @NotNull(message = "Config refresh interval cannot be empty.")
    @Min(value = 1, message = "Config refresh interval cannot be less than 1 second.")
    private Integer configRefreshInterval = 30;

    /**
     * 自定义功能码（用于认证等扩展交互）
     * Modbus 协议保留 65-72 给用户自定义，默认 65
     */
    @NotNull(message = "Custom function code cannot be empty.")
    @Min(value = 65, message = "Custom function code cannot be less than 65.")
    @Max(value = 72, message = "Custom function code cannot be greater than 72.")
    private Integer customFunctionCode = 65;

    /**
     * Pending Request 超时时间（毫秒）
     */
    @NotNull(message = "Request timeout cannot be empty.")
    private Integer requestTimeout = 5000;

    /**
     * Pending Request 清理间隔（毫秒）
     */
    @NotNull(message = "Request cleanup interval cannot be empty.")
    private Integer requestCleanupInterval = 10000;

}
