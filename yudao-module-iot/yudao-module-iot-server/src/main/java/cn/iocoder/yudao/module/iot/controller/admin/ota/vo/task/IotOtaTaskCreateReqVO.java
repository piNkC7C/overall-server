package cn.iocoder.yudao.module.iot.controller.admin.ota.vo.task;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.iot.enums.ota.IotOtaTaskDeviceScopeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "管理后台 - IoT OTA 升级任务创建 Request VO")
@Data
public class IotOtaTaskCreateReqVO {

    @NotEmpty(message = "Task name is required.")
    @Schema(description = "任务名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Upgrade job.")
    private String name;

    @Schema(description = "任务描述", example = "Upgrade job.")
    private String description;

    @Schema(description = "固件编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Firmware code is required.")
    private Long firmwareId;

    @Schema(description = "升级范围", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Upgrade Range is required.")
    @InEnum(value = IotOtaTaskDeviceScopeEnum.class)
    private Integer deviceScope;

    @Schema(description = "选中的设备编号数组", requiredMode = Schema.RequiredMode.REQUIRED, example = "1,2,3")
    private List<Long> deviceIds;

    // TODO @li：如果 deviceScope 等于 2 时，deviceIds 校验非空；

}
