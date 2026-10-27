package cn.iocoder.yudao.module.iot.controller.admin.device.vo.group;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - IoT device group response.")
@Data
public class IotDeviceGroupRespVO {

    @Schema(description = "Group ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3583")
    private Long id;

    @Schema(description = "Group name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    private String name;

    @Schema(description = "Group status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Group Description.", example = "Looks good.")
    private String description;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Device quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Long deviceCount;

}