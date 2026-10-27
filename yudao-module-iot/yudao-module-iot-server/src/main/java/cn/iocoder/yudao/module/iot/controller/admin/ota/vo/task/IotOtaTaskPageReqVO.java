package cn.iocoder.yudao.module.iot.controller.admin.ota.vo.task;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - IoT OTA upgrade job page request.")
@Data
public class IotOtaTaskPageReqVO extends PageParam {

    @Schema(description = "Task name.", example = "Upgrade job.")
    private String name;

    @Schema(description = "Firmware code.", example = "1024")
    private Long firmwareId;

}
