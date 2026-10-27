package cn.iocoder.yudao.module.system.controller.admin.sms.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - SMS template simple response.")
@Data
public class SmsTemplateSimpleRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Verification code")
    private String name;

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "sms_001")
    private String code;

}
