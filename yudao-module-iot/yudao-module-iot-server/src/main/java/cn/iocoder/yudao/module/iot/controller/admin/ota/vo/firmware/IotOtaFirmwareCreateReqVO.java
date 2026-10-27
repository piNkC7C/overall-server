package cn.iocoder.yudao.module.iot.controller.admin.ota.vo.firmware;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Schema(description = "Admin - IoT OTA firmware create request.")
@Data
public class IotOtaFirmwareCreateReqVO {

    @Schema(description = "Firmware name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Smart-switch firmware")
    @NotEmpty(message = "Firmware name is required.")
    private String name;

    @Schema(description = "Firmware Description.", example = "Sample brand firmware, for test")
    private String description;

    @Schema(description = "Version.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1.0.0")
    @NotEmpty(message = "Version is required.")
    private String version;

    @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Product code is required.")
    private Long productId;

    @Schema(description = "Firmware file URL.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/1.zip")
    @NotEmpty(message = "Firmware file URL is required.")
    @URL(message = "Firmware file URL format Error.")
    private String fileUrl;

}
