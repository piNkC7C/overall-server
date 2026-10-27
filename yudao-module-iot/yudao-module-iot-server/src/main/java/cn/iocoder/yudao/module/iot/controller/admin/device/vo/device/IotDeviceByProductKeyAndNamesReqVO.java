package cn.iocoder.yudao.module.iot.controller.admin.device.vo.device;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - via product key and device name list get device request.")
@Data
public class IotDeviceByProductKeyAndNamesReqVO {

    @Schema(description = "Product key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1de24640dfe")
    @NotBlank(message = "Product key is required.")
    private String productKey;

    @Schema(description = "Device name list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "device001,device002")
    @NotEmpty(message = "Device name list is required.")
    private List<String> deviceNames;

} 
