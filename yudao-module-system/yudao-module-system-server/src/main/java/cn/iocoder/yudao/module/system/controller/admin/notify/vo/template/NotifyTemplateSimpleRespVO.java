package cn.iocoder.yudao.module.system.controller.admin.notify.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - inbox message template simple response.")
@Data
public class NotifyTemplateSimpleRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Systemnotification.")
    private String name;

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "notify_001")
    private String code;

}
