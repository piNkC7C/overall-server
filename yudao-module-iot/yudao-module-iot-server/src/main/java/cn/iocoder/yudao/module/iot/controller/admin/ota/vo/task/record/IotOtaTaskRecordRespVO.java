package cn.iocoder.yudao.module.iot.controller.admin.ota.vo.task.record;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - IoT OTA upgrade job record response.")
@Data
public class IotOtaTaskRecordRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Firmware code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long firmwareId;

    @Schema(description = "Task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long taskId;

    @Schema(description = "Device code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long deviceId;

    @Schema(description = "Device name.", example = "Smart switch")
    private String deviceName;

    @Schema(description = "Source firmware code.", example = "1023")
    private Long fromFirmwareId;

    @Schema(description = "Source firmware version.", example = "1.0.0")
    private String fromFirmwareVersion;

    @Schema(description = "Upgrade status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Upgrade progress, percent.", requiredMode = Schema.RequiredMode.REQUIRED, example = "50")
    private Integer progress;

    @Schema(description = "Upgrade progress Description.", example = "Downloading firmware...")
    private String description;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Update time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime updateTime;

}
