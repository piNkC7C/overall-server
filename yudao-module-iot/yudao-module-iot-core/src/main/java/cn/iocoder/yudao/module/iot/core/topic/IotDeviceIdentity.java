package cn.iocoder.yudao.module.iot.core.topic;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * IoT 设备标识
 *
 * 用于标识一个设备的基本信息（productKey + deviceName）
 *
 * @author 芋道源码
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IotDeviceIdentity {

    /**
     * 产品标识
     */
    @NotEmpty(message = "Product key is required.")
    private String productKey;

    /**
     * 设备名称
     */
    @NotEmpty(message = "Device name is required.")
    private String deviceName;

}
