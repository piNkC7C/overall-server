package cn.iocoder.yudao.module.member.controller.app.user.vo;

import cn.iocoder.yudao.framework.common.validation.Mobile;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Schema(description = "App - Reset password. request.")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppMemberUserResetPasswordReqVO {

    @Schema(description = "New password.", requiredMode = Schema.RequiredMode.REQUIRED, example = "buzhidao")
    @NotEmpty(message = "New password cannot be empty.")
    @Length(min = 4, max = 16, message = "Password must be 4-16 characters.")
    private String password;

    @Schema(description = "SMS code", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotEmpty(message = "SMS code is required.")
    @Length(min = 4, max = 6, message = "SMS code length is 4-6 characters.")
    @Pattern(regexp = "^[0-9]+$", message = "SMS code must all is digits.")
    private String code;

    @Schema(description = "Phone number.",requiredMode = Schema.RequiredMode.REQUIRED,example = "15878962356")
    @NotBlank(message = "Phone number is required.")
    @Mobile
    private String mobile;

}
