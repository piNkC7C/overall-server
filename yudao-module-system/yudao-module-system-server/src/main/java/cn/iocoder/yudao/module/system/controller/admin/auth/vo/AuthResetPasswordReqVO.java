package cn.iocoder.yudao.module.system.controller.admin.auth.vo;

import cn.iocoder.yudao.framework.common.validation.Mobile;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Schema(description = "Reset account password by SMS request VO.")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResetPasswordReqVO {

    @Schema(description = "Password.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1234")
    @NotEmpty(message = "Password is required.")
    @Length(min = 4, max = 16, message = "Password must be 4-16 characters.")
    private String password;

    @Schema(description = "Phone number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "13312341234")
    @NotEmpty(message = "Phone number is required.")
    @Mobile
    private String mobile;

    @Schema(description = "Mobile SMS Verification code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456")
    @NotEmpty(message = "MobileMobile SMS Verification code is required.")
    private String code;
}