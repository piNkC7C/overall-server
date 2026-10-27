package cn.iocoder.yudao.module.iot.controller.admin.device.vo.message;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - IoT devicemessage response.")
@Data
public class IotDeviceMessageRespVO {

    @Schema(description = "Message code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private String id;

    @Schema(description = "Report time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime reportTime;

    @Schema(description = "RecordTimestamp.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime ts;

    @Schema(description = "Device code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "123")
    private Long deviceId;

    @Schema(description = "Service code.", example = "server_123")
    private String serverId;

    @Schema(description = "Is not line message.", example = "true", examples = "false")
    private Boolean upstream;

    @Schema(description = "Is not reply message.", example = "false", examples = "true")
    private Boolean reply;

    @Schema(description = "Identifier.", example = "temperature")
    private String identifier;

    // ========== codec（编解码）字段 ==========

    @Schema(description = "Request ID.", example = "req_123")
    private String requestId;

    @Schema(description = "Request Method", requiredMode = Schema.RequiredMode.REQUIRED, example = "thing.property.post")
    private String method;

    @Schema(description = "Request params.")
    private Object params;

    @Schema(description = "Response body.")
    private Object data;

    @Schema(description = "ResponseError code.", example = "200")
    private Integer code;

    @Schema(description = "ResponseTip.", example = "Action succeeded.")
    private String msg;

}