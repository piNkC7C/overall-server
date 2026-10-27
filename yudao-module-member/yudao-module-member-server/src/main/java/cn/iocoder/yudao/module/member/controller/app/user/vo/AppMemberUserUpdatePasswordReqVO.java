package cn.iocoder.yudao.module.member.controller.app.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Schema(description = "User APP - edit password request.")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppMemberUserUpdatePasswordReqVO {

    @Schema(description = "New password.", requiredMode = Schema.RequiredMode.REQUIRED, example = "buzhidao")
    @NotEmpty(message = "New password cannot be empty.")
    @Length(min = 4, max = 16, message = "Password must be 4-16 characters.")
    private String password;

    @Schema(description = "SMS code", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotEmpty(message = "SMS code is required.")
    @Length(min = 4, max = 6, message = "SMS code length is 4-6 characters.")
    @Pattern(regexp = "^[0-9]+$", message = "SMS code must all is digits.")
    private String code;

}
