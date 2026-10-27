package cn.iocoder.yudao.module.iot.controller.admin.ota.vo.task;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.iot.enums.ota.IotOtaTaskDeviceScopeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - IoT OTA upgrade job create request.")
@Data
public class IotOtaTaskCreateReqVO {

    @NotEmpty(message = "Task name is required.")
    @Schema(description = "Task name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Upgrade job.")
    private String name;

    @Schema(description = "TaskDescription.", example = "Upgrade job.")
    private String description;

    @Schema(description = "Firmware code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Firmware code is required.")
    private Long firmwareId;

    @Schema(description = "Upgrade Range.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Upgrade Range is required.")
    @InEnum(value = IotOtaTaskDeviceScopeEnum.class)
    private Integer deviceScope;

    @Schema(description = "Selected device IDs.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1,2,3")
    private List<Long> deviceIds;

    // TODO @li：如果 deviceScope 等于 2 时，deviceIds 校验非空；

}
