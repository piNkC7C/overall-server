package cn.iocoder.yudao.module.iot.core.biz.dto;

import cn.iocoder.yudao.module.iot.core.topic.auth.IotSubDeviceRegisterReqDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * IoT 子设备动态注册 Request DTO
 * <p>
 * 额外包含了网关设备的标识信息
 *
 * @author 芋道源码
 */
@Data
public class IotSubDeviceRegisterFullReqDTO {

    /**
     * 网关设备 ProductKey
     */
    @NotEmpty(message = "Gateway product key is required.")
    private String gatewayProductKey;

    /**
     * 网关设备 DeviceName
     */
    @NotEmpty(message = "Gateway device name is required.")
    private String gatewayDeviceName;

    /**
     * 子设备注册列表
     */
    @NotNull(message = "Child device register list is required.")
    private List<IotSubDeviceRegisterReqDTO> subDevices;

}
