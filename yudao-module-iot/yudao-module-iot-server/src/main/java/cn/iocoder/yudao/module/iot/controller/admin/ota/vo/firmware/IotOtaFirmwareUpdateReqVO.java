package cn.iocoder.yudao.module.iot.controller.admin.ota.vo.firmware;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - IoT OTA firmware update request.")
@Data
public class IotOtaFirmwareUpdateReqVO {

    @Schema(description = "Firmware code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Firmware code is required.")
    private Long id;

    @Schema(description = "Firmware name.", example = "Smart-switch firmware")
    private String name;

    @Schema(description = "Firmware Description.", example = "Sample brand firmware, for test")
    private String description;

}
