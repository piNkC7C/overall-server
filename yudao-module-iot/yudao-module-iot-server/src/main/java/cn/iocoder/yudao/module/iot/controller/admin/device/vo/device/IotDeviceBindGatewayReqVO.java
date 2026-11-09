package cn.iocoder.yudao.module.iot.controller.admin.device.vo.device;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Schema(description = "管理后台 - IoT 设备绑定网关 Request VO")
@Data
public class IotDeviceBindGatewayReqVO {

    @Schema(description = "子设备编号列表", requiredMode = Schema.RequiredMode.REQUIRED, example = "1,2,3")
    @NotEmpty(message = "Child device code list is required.")
    private Set<Long> subIds;

    @Schema(description = "网关设备编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Gateway device code is required.")
    private Long gatewayId;

}
