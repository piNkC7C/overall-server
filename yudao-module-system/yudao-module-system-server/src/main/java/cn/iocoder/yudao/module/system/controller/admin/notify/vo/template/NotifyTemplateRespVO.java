package cn.iocoder.yudao.module.system.controller.admin.notify.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - inbox message template response.")
@Data
public class NotifyTemplateRespVO {

    @Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Test template")
    private String name;

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "SEND_TEST")
    private String code;

    @Schema(description = "Template type, matching system_notify_template_type dictionary.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Send person name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Potato.")
    private String nickname;

    @Schema(description = "Template content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Me is template content.")
    private String content;

    @Schema(description = "Template params", example = "name,code")
    private List<String> params;

    @Schema(description = "Status, see CommonStatusEnum enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Notes.", example = "Sample notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
