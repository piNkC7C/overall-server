package cn.iocoder.yudao.module.system.controller.admin.mail.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - email template create or update request.")
@Data
public class MailTemplateSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Test name")
    @NotNull(message = "Name is required.")
    private String name;

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "test")
    @NotNull(message = "Template code is required.")
    private String code;

    @Schema(description = "Send email account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Send email account code is required.")
    private Long accountId;

    @Schema(description = "Send person name.", example = "Taro")
    private String nickname;

    @Schema(description = "Title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Register succeeded.")
    @NotEmpty(message = "Title is required.")
    private String title;

    @Schema(description = "Content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Hi, you signed up successfully")
    @NotEmpty(message = "Content is required.")
    private String content;

    @Schema(description = "Status, see CommonStatusEnum enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "Notes.", example = "Ultraman")
    private String remark;

}
