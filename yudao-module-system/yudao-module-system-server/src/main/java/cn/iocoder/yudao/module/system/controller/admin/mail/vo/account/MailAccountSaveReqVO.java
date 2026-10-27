package cn.iocoder.yudao.module.system.controller.admin.mail.vo.account;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - email account create or update request.")
@Data
public class MailAccountSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Email", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudaoyuanma@123.com")
    @NotNull(message = "Email is required.")
    @Email(message = "Must be Email format.")
    private String mail;

    @Schema(description = "Username.", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao")
    @NotNull(message = "Username is required.")
    private String username;

    @Schema(description = "Password.", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456")
    @NotNull(message = "Password Required.")
    private String password;

    @Schema(description = "SMTP host", requiredMode = Schema.RequiredMode.REQUIRED, example = "www.iocoder.cn")
    @NotNull(message = "SMTP host is required.")
    private String host;

    @Schema(description = "SMTP port", requiredMode = Schema.RequiredMode.REQUIRED, example = "80")
    @NotNull(message = "SMTP port is required.")
    private Integer port;

    @Schema(description = "Is not enable ssl.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not enable ssl Required.")
    private Boolean sslEnable;

    @Schema(description = "Is not enable starttls.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not enable starttls Required.")
    private Boolean starttlsEnable;

}
