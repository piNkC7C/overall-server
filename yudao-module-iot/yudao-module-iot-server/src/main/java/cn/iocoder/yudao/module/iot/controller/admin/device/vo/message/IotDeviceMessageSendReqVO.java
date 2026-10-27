package cn.iocoder.yudao.module.iot.controller.admin.device.vo.message;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.iot.core.enums.IotDeviceMessageMethodEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - IoT devicemessage send request.") // 属性上报、事件上报、状态变更等
@Data
public class IotDeviceMessageSendReqVO {

    @Schema(description = "Request Method", requiredMode = Schema.RequiredMode.REQUIRED, example = "report")
    @NotEmpty(message = "Request Method is required.")
    @InEnum(IotDeviceMessageMethodEnum.class)
    private String method;

    @Schema(description = "Request params.")
    private Object params; // 例如说：属性上报的 properties、事件上报的 params

    @Schema(description = "Device code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "177")
    @NotNull(message = "Device code is required.")
    private Long deviceId;

}
