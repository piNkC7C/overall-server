package cn.iocoder.yudao.module.iot.controller.admin.ota.vo.firmware;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Schema(description = "管理后台 - IoT OTA 固件创建 Request VO")
@Data
public class IotOtaFirmwareCreateReqVO {

    @Schema(description = "固件名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Smart-switch firmware")
    @NotEmpty(message = "Firmware name is required.")
    private String name;

    @Schema(description = "固件描述", example = "Sample brand firmware, for test")
    private String description;

    @Schema(description = "版本号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1.0.0")
    @NotEmpty(message = "Version is required.")
    private String version;

    @Schema(description = "产品编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Product code is required.")
    private Long productId;

    @Schema(description = "固件文件 URL", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/1.zip")
    @NotEmpty(message = "Firmware file URL is required.")
    @URL(message = "Firmware file URL format Error.")
    private String fileUrl;

}
