package cn.iocoder.yudao.module.iot.controller.admin.ota.vo.firmware;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - IoT OTA 固件更新 Request VO")
@Data
public class IotOtaFirmwareUpdateReqVO {

    @Schema(description = "固件编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Firmware code is required.")
    private Long id;

    @Schema(description = "固件名称", example = "Smart-switch firmware")
    private String name;

    @Schema(description = "固件描述", example = "Sample brand firmware, for test")
    private String description;

}
