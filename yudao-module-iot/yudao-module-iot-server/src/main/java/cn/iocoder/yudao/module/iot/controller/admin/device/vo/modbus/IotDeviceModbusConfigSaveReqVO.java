package cn.iocoder.yudao.module.iot.controller.admin.device.vo.modbus;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.iot.core.enums.modbus.IotModbusFrameFormatEnum;
import cn.iocoder.yudao.module.iot.core.enums.modbus.IotModbusModeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - IoT device Modbus connect setting create / edit request.")
@Data
public class IotDeviceModbusConfigSaveReqVO {

    @Schema(description = "Device code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Device code is required.")
    private Long deviceId;

    @Schema(description = "Modbus server IP.", example = "192.168.1.100")
    private String ip;

    @Schema(description = "Modbus port.", example = "502")
    private Integer port;

    @Schema(description = "Slave address.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Slave address cannot be empty.")
    private Integer slaveId;

    @Schema(description = "Connection timeout (ms).", example = "3000")
    private Integer timeout;

    @Schema(description = "Retry interval (ms).", example = "1000")
    private Integer retryInterval;

    @Schema(description = "Work mode.", example = "1")
    @InEnum(IotModbusModeEnum.class)
    private Integer mode;

    @Schema(description = "Frame format.", example = "1")
    @InEnum(IotModbusFrameFormatEnum.class)
    private Integer frameFormat;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    private Integer status;

}
