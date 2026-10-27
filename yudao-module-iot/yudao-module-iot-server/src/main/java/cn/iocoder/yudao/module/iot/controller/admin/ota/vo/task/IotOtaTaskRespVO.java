package cn.iocoder.yudao.module.iot.controller.admin.ota.vo.task;

import org.dromara.core.trans.vo.VO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - IoT OTA upgrade job response.")
@Data
public class IotOtaTaskRespVO implements VO {

    @Schema(description = "Task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Task name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Upgrade job.")
    private String name;

    @Schema(description = "TaskDescription.", example = "Upgrade job.")
    private String description;

    @Schema(description = "Firmware code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long firmwareId;

    @Schema(description = "Task status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer status;

    @Schema(description = "Upgrade Range.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer deviceScope;

    @Schema(description = "Total device count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer deviceTotalCount;

    @Schema(description = "Device succeeded quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "66")
    private Integer deviceSuccessCount;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2022-07-08 07:30:00")
    private LocalDateTime createTime;

}
