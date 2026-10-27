package cn.iocoder.yudao.module.iot.controller.admin.device.vo.modbus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - IoT device Modbus point setting response.")
@Data
public class IotDeviceModbusPointRespVO {

    @Schema(description = "Primary key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Device code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long deviceId;

    @Schema(description = "Thing model attribute code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long thingModelId;

    @Schema(description = "Attribute identifier.", requiredMode = Schema.RequiredMode.REQUIRED, example = "temperature")
    private String identifier;

    @Schema(description = "Attribute name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Temperature")
    private String name;

    @Schema(description = "Modbus function code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Integer functionCode;

    @Schema(description = "Register start address.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer registerAddress;

    @Schema(description = "Register count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer registerCount;

    @Schema(description = "Byte order.", requiredMode = Schema.RequiredMode.REQUIRED, example = "AB")
    private String byteOrder;

    @Schema(description = "Raw data type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "INT16")
    private String rawDataType;

    @Schema(description = "Scale factor.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1.0")
    private BigDecimal scale;

    @Schema(description = "Poll interval (ms).", requiredMode = Schema.RequiredMode.REQUIRED, example = "5000")
    private Integer pollInterval;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
