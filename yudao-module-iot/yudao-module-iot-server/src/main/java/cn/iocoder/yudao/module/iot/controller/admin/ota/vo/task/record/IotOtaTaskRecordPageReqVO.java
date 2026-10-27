package cn.iocoder.yudao.module.iot.controller.admin.ota.vo.task.record;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.iot.enums.ota.IotOtaTaskRecordStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - IoT OTA upgrade record page request.")
@Data
public class IotOtaTaskRecordPageReqVO extends PageParam {

    @Schema(description = "Upgrade job code.", example = "1024")
    private Long taskId;

    @Schema(description = "Upgrade record status.", example = "5")
    @InEnum(IotOtaTaskRecordStatusEnum.class)
    private Integer status;

}
