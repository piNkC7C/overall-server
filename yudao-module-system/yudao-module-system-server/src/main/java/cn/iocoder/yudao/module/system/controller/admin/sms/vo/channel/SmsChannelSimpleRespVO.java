package cn.iocoder.yudao.module.system.controller.admin.sms.vo.channel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - SMS channel simple response.")
@Data
public class SmsChannelSimpleRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "SMS signature.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String signature;

    @Schema(description = "Channel code, see SmsChannelEnum enum class.", requiredMode = Schema.RequiredMode.REQUIRED, example = "YUN_PIAN")
    private String code;

}
