package cn.iocoder.yudao.module.iot.controller.admin.device.vo.modbus;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - IoT 设备 Modbus 点位配置新增/修改 Request VO")
@Data
public class IotDeviceModbusPointSaveReqVO {

    @Schema(description = "主键", example = "1")
    private Long id;

    @Schema(description = "设备编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Device code is required.")
    private Long deviceId;

    @Schema(description = "物模型属性编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "Thing model attribute code is required.")
    private Long thingModelId;

    @Schema(description = "Modbus 功能码", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    @NotNull(message = "Modbus function code cannot be empty.")
    private Integer functionCode;

    @Schema(description = "寄存器起始地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Register start address cannot be empty.")
    private Integer registerAddress;

    @Schema(description = "寄存器数量", example = "1")
    private Integer registerCount;

    @Schema(description = "字节序", requiredMode = Schema.RequiredMode.REQUIRED, example = "AB")
    @NotEmpty(message = "Byte order cannot be empty.")
    private String byteOrder;

    @Schema(description = "原始数据类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "INT16")
    @NotEmpty(message = "Raw data type cannot be empty.")
    private String rawDataType;

    @Schema(description = "缩放因子", example = "1.0")
    private BigDecimal scale;

    @Schema(description = "轮询间隔（毫秒）", example = "5000")
    private Integer pollInterval;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    private Integer status;

}
