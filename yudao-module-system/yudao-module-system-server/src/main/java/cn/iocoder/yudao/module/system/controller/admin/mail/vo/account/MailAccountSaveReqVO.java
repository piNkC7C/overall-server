package cn.iocoder.yudao.module.system.controller.admin.mail.vo.account;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - 邮箱账号创建/修改 Request VO")
@Data
public class MailAccountSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "邮箱", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudaoyuanma@123.com")
    @NotNull(message = "Email is required.")
    @Email(message = "Must be Email format.")
    private String mail;

    @Schema(description = "用户名", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao")
    @NotNull(message = "Username is required.")
    private String username;

    @Schema(description = "密码", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456")
    @NotNull(message = "Password Required.")
    private String password;

    @Schema(description = "SMTP 服务器域名", requiredMode = Schema.RequiredMode.REQUIRED, example = "www.iocoder.cn")
    @NotNull(message = "SMTP host is required.")
    private String host;

    @Schema(description = "SMTP 服务器端口", requiredMode = Schema.RequiredMode.REQUIRED, example = "80")
    @NotNull(message = "SMTP port is required.")
    private Integer port;

    @Schema(description = "是否开启 ssl", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not enable ssl Required.")
    private Boolean sslEnable;

    @Schema(description = "是否开启 starttls", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not enable starttls Required.")
    private Boolean starttlsEnable;

}
