package cn.iocoder.yudao.module.iot.controller.admin.alert.vo.recrod;

import cn.iocoder.yudao.module.iot.core.mq.message.IotDeviceMessage;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - IoT alert record response.")
@Data
public class IotAlertRecordRespVO {

    @Schema(description = "Record code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "19904")
    private Long id;

    @Schema(description = "Alert setting code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "29320")
    private Long configId;

    @Schema(description = "Alert name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    private String configName;

    @Schema(description = "Alert level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer configLevel;

    @Schema(description = "Product code.", example = "2050")
    private Long productId;

    @Schema(description = "Device code.", example = "21727")
    private Long deviceId;

    @Schema(description = "Triggered device message.")
    private IotDeviceMessage deviceMessage;

    @Schema(description = "Is not process.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Boolean processStatus;

    @Schema(description = "Process result ( notes ).", example = "Looks good.")
    private String processRemark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}