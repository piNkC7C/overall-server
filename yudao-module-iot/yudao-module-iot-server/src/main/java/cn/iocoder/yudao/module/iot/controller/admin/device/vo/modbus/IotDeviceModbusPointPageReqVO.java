package cn.iocoder.yudao.module.iot.controller.admin.device.vo.modbus;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - IoT device Modbus point setting page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IotDeviceModbusPointPageReqVO extends PageParam {

    @Schema(description = "Device code.", example = "1024")
    private Long deviceId;

    @Schema(description = "Attribute identifier.", example = "temperature")
    private String identifier;

    @Schema(description = "Attribute name.", example = "Temperature")
    private String name;

    @Schema(description = "Modbus function code.", example = "3")
    private Integer functionCode;

    @Schema(description = "Status.", example = "0")
    private Integer status;

}
