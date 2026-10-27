package cn.iocoder.yudao.module.iot.controller.admin.device.vo.device;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Schema(description = "Admin - IoT device auth info response.")
@Data
public class IotDeviceAuthInfoRespVO {

    @Schema(description = "Client ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "product123.device001")
    @NotBlank(message = "Client ID is required.")
    private String clientId;

    @Schema(description = "Username.", requiredMode = Schema.RequiredMode.REQUIRED, example = "device001&product123")
    @NotBlank(message = "Username is required.")
    private String username;

    @Schema(description = "Password.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1a2b3c4d5e6f7890abcdef1234567890")
    @NotBlank(message = "Password is required.")
    private String password;

}