package cn.iocoder.yudao.module.system.controller.admin.auth.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Schema(description = "Admin - Register request.")
@Data
public class AuthRegisterReqVO extends CaptchaVerificationReqVO {

    @Schema(description = "Username.", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao")
    @NotBlank(message = "Username is required.")
    @Pattern(regexp = "^[a-zA-Z0-9]{4,30}$", message = "Username by digits 、 letters consist of.")
    @Size(min = 4, max = 30, message = "Username must be 4-30 characters.")
    private String username;

    @Schema(description = "Nickname", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotBlank(message = "Nickname is required.")
    @Size(max = 30, message = "Nickname length cannot exceed 30 characters.")
    private String nickname;

    @Schema(description = "Password.", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456")
    @NotEmpty(message = "Password is required.")
    @Length(min = 4, max = 16, message = "Password must be 4-16 characters.")
    private String password;
}