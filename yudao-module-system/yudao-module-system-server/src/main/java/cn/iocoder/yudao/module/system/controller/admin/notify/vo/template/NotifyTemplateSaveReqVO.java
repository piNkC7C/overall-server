package cn.iocoder.yudao.module.system.controller.admin.notify.vo.template;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - inbox message template create or update request.")
@Data
public class NotifyTemplateSaveReqVO {

    @Schema(description = "ID", example = "1024")
    private Long id;

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Test template")
    @NotEmpty(message = "Template name is required.")
    private String name;

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "SEND_TEST")
    @NotNull(message = "Template code is required.")
    private String code;

    @Schema(description = "Template type, matching system_notify_template_type dictionary.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Template type is required.")
    private Integer type;

    @Schema(description = "Send person name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Potato.")
    @NotEmpty(message = "Send person name is required.")
    private String nickname;

    @Schema(description = "Template content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Me is template content.")
    @NotEmpty(message = "Template content is required.")
    private String content;

    @Schema(description = "Status, see CommonStatusEnum enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    @InEnum(value = CommonStatusEnum.class, message = "Status must be {value}.")
    private Integer status;

    @Schema(description = "Notes.", example = "Sample notes")
    private String remark;

}
