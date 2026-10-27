package cn.iocoder.yudao.module.oa.controller.admin.mail.vo.account;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Enterprise email account response VO.")
public class OaMailAccountRespVO {

    @Schema(description = "Account code.", example = "1024")
    private Long id;

    @Schema(description = "Service setting code.", example = "1024")
    private Long providerId;

    @Schema(description = "EmailAddress.", requiredMode = Schema.RequiredMode.REQUIRED, example = "user@example.com")
    private String mail;

    @Schema(description = "Owner person Name.", example = "John.")
    private String userName;

    @Schema(description = "Sign-in username.", example = "user@example.com")
    private String username;

    @Schema(description = "Default sender account.", example = "false")
    private Boolean defaultStatus;

    @Schema(description = "Status.", example = "0")
    private Integer status;

}
