package cn.iocoder.yudao.module.iot.controller.admin.device.vo.device;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Schema(description = "Admin - IoT deviceimport response.")
@Data
@Builder
public class IotDeviceImportRespVO {

    @Schema(description = "Create succeeded device nameArray.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> createDeviceNames;

    @Schema(description = "Update succeeded device nameArray.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> updateDeviceNames;

    @Schema(description = "Failed device import map. Key is Device name. Value is the failure reason.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Map<String, String> failureDeviceNames;
} 