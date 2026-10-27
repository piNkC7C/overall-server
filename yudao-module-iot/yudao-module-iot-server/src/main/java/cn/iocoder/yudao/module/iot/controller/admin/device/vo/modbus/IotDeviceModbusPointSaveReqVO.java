package cn.iocoder.yudao.module.iot.controller.admin.device.vo.modbus;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - IoT device Modbus point setting create / edit request.")
@Data
public class IotDeviceModbusPointSaveReqVO {

    @Schema(description = "Primary key.", example = "1")
    private Long id;

    @Schema(description = "Device code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Device code is required.")
    private Long deviceId;

    @Schema(description = "Thing model attribute code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "Thing model attribute code is required.")
    private Long thingModelId;

    @Schema(description = "Modbus function code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    @NotNull(message = "Modbus function code cannot be empty.")
    private Integer functionCode;

    @Schema(description = "Register start address.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Register start address cannot be empty.")
    private Integer registerAddress;

    @Schema(description = "Register count.", example = "1")
    private Integer registerCount;

    @Schema(description = "Byte order.", requiredMode = Schema.RequiredMode.REQUIRED, example = "AB")
    @NotEmpty(message = "Byte order cannot be empty.")
    private String byteOrder;

    @Schema(description = "Raw data type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "INT16")
    @NotEmpty(message = "Raw data type cannot be empty.")
    private String rawDataType;

    @Schema(description = "Scale factor.", example = "1.0")
    private BigDecimal scale;

    @Schema(description = "Poll interval (ms).", example = "5000")
    private Integer pollInterval;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    private Integer status;

}
