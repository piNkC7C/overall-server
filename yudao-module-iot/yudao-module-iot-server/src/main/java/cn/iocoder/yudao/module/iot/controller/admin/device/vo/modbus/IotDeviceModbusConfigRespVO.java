package cn.iocoder.yudao.module.iot.controller.admin.device.vo.modbus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - IoT device Modbus connect setting response.")
@Data
public class IotDeviceModbusConfigRespVO {

    @Schema(description = "Primary key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Device code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long deviceId;

    @Schema(description = "Device name.", example = "Temperature and humidity sensor")
    private String deviceName;

    @Schema(description = "Modbus server IP.", requiredMode = Schema.RequiredMode.REQUIRED, example = "192.168.1.100")
    private String ip;

    @Schema(description = "Modbus port.", requiredMode = Schema.RequiredMode.REQUIRED, example = "502")
    private Integer port;

    @Schema(description = "Slave address.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer slaveId;

    @Schema(description = "Connection timeout (ms).", example = "3000")
    private Integer timeout;

    @Schema(description = "Retry interval (ms).", example = "1000")
    private Integer retryInterval;

    @Schema(description = "Work mode.", example = "1")
    private Integer mode;

    @Schema(description = "Frame format.", example = "1")
    private Integer frameFormat;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
