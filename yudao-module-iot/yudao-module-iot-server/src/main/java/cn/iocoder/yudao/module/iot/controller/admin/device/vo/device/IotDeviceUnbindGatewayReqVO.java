package cn.iocoder.yudao.module.iot.controller.admin.device.vo.device;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Schema(description = "Admin - IoT device unbind gateway request.")
@Data
public class IotDeviceUnbindGatewayReqVO {

    @Schema(description = "Child device code list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1,2,3")
    @NotEmpty(message = "Child device code list is required.")
    private Set<Long> subIds;

    @Schema(description = "Gateway device code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Gateway device code is required.")
    private Long gatewayId;

}
