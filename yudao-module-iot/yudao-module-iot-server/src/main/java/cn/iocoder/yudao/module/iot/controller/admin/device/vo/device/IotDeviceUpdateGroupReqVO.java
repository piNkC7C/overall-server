package cn.iocoder.yudao.module.iot.controller.admin.device.vo.device;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Set;

@Schema(description = "Admin - IoT deviceupdate group request.")
@Data
public class IotDeviceUpdateGroupReqVO {

    @Schema(description = "Device code list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1,2,3")
    @NotEmpty(message = "Device code list is required.")
    private Set<Long> ids;

    @Schema(description = "Group code list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1,2,3")
    @NotEmpty(message = "Group code list is required.")
    private Set<Long> groupIds;

}