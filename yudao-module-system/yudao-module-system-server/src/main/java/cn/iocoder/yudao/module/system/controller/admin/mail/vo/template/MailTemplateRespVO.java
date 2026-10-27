package cn.iocoder.yudao.module.system.controller.admin.mail.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Email template response VO.")
@Data
public class MailTemplateRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Test name")
    private String name;

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "test")
    private String code;

    @Schema(description = "Send email account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long accountId;

    @Schema(description = "Send person name.", example = "Taro")
    private String nickname;

    @Schema(description = "Title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Register succeeded.")
    private String title;

    @Schema(description = "Content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Hi, you signed up successfully")
    private String content;

    @Schema(description = "Template params", example = "name,code")
    private List<String> params;

    @Schema(description = "Status, see CommonStatusEnum enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Notes.", example = "Ultraman")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
