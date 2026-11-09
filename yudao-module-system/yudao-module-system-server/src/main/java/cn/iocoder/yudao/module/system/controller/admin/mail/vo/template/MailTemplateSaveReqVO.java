package cn.iocoder.yudao.module.system.controller.admin.mail.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Schema(description = "管理后台 - 邮件模版创建/修改 Request VO")
@Data
public class MailTemplateSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "模版名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Test name")
    @NotNull(message = "Name is required.")
    private String name;

    @Schema(description = "模版编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "test")
    @NotNull(message = "Template code is required.")
    private String code;

    @Schema(description = "发送的邮箱账号编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Send email account code is required.")
    private Long accountId;

    @Schema(description = "发送人名称", example = "Taro")
    private String nickname;

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "Register succeeded.")
    @NotEmpty(message = "Title is required.")
    private String title;

    @Schema(description = "内容", requiredMode = Schema.RequiredMode.REQUIRED, example = "Hi, you signed up successfully")
    @NotEmpty(message = "Content is required.")
    private String content;

    @Schema(description = "状态，参见 CommonStatusEnum 枚举", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "备注", example = "Ultraman")
    private String remark;

}
