package cn.iocoder.yudao.module.iot.controller.admin.device.vo.group;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - IoT device group create / edit request.")
@Data
public class IotDeviceGroupSaveReqVO {

    @Schema(description = "Group ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3583")
    private Long id;

    @Schema(description = "Group name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @NotEmpty(message = "Group name is required.")
    private String name;

    @Schema(description = "Group status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Group status is required.")
    private Integer status;

    @Schema(description = "Group Description.", example = "Looks good.")
    private String description;

}