package cn.iocoder.yudao.module.iot.controller.admin.ota.vo.firmware;

import org.dromara.core.trans.vo.VO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - IoT OTA firmware response.")
@Data
public class IotOtaFirmwareRespVO implements VO {

    @Schema(description = "Firmware code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Firmware name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "OTA firmware.")
    private String name;

    @Schema(description = "Firmware Description.")
    private String description;

    @Schema(description = "Version.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1.0.0")
    private String version;

    @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long productId;

    @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Smart device")
    private String productName;

    @Schema(description = "Firmware file URL.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/firmware.bin")
    private String fileUrl;

    @Schema(description = "Firmware File size.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long fileSize;

    @Schema(description = "Firmware file signature algorithm.", example = "MD5")
    private String fileDigestAlgorithm;

    @Schema(description = "Firmware filesignature result.", example = "d41d8cd98f00b204e9800998ecf8427e")
    private String fileDigestValue;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Update time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime updateTime;

}
