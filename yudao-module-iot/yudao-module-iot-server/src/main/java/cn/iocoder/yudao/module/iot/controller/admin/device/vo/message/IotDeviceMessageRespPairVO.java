package cn.iocoder.yudao.module.iot.controller.admin.device.vo.message;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - IoT devicemessage for response.")
@Data
public class IotDeviceMessageRespPairVO {

    @Schema(description = "Request message.", requiredMode = Schema.RequiredMode.REQUIRED)
    private IotDeviceMessageRespVO request;

    @Schema(description = "Responsemessage.")
    private IotDeviceMessageRespVO reply; // 通过 requestId 配对

}
