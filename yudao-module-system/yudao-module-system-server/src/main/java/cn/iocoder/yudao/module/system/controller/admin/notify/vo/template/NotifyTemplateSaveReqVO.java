package cn.iocoder.yudao.module.system.controller.admin.notify.vo.template;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Schema(description = "管理后台 - 站内信模版创建/修改 Request VO")
@Data
public class NotifyTemplateSaveReqVO {

    @Schema(description = "ID", example = "1024")
    private Long id;

    @Schema(description = "模版名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Test template")
    @NotEmpty(message = "Template name is required.")
    private String name;

    @Schema(description = "模版编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "SEND_TEST")
    @NotNull(message = "Template code is required.")
    private String code;

    @Schema(description = "模版类型，对应 system_notify_template_type 字典", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Template type is required.")
    private Integer type;

    @Schema(description = "发送人名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Potato.")
    @NotEmpty(message = "Send person name is required.")
    private String nickname;

    @Schema(description = "模版内容", requiredMode = Schema.RequiredMode.REQUIRED, example = "Me is template content.")
    @NotEmpty(message = "Template content is required.")
    private String content;

    @Schema(description = "状态，参见 CommonStatusEnum 枚举", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    @InEnum(value = CommonStatusEnum.class, message = "Status must be {value}.")
    private Integer status;

    @Schema(description = "备注", example = "Sample notes")
    private String remark;

}
