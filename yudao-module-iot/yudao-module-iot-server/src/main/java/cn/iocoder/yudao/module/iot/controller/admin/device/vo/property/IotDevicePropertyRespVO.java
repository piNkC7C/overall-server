package cn.iocoder.yudao.module.iot.controller.admin.device.vo.property;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - IoT device attribute response.")
@Data
public class IotDevicePropertyRespVO {

    @Schema(description = "Attribute identifier.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String identifier;

    @Schema(description = "PropertyValue.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Object value;

    @Schema(description = "Update time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long updateTime; // 由于从 TDengine 查询出来的是 Long 类型，所以这里也使用 Long 类型

}