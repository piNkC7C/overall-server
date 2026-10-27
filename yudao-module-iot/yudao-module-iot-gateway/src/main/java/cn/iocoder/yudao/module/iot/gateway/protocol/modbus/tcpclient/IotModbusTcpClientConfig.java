package cn.iocoder.yudao.module.iot.gateway.protocol.modbus.tcpclient;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * IoT Modbus TCP Client 协议配置
 *
 * @author 芋道源码
 */
@Data
public class IotModbusTcpClientConfig {

    /**
     * 配置刷新间隔（秒）
     */
    @NotNull(message = "Config refresh interval cannot be empty.")
    @Min(value = 1, message = "Config refresh interval cannot be less than 1 second.")
    private Integer configRefreshInterval = 30;

}
