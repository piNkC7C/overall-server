package cn.iocoder.yudao.module.system.controller.admin.user.vo.profile;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;

@Schema(description = "User profile update password request VO.")
@Data
public class UserProfileUpdatePasswordReqVO {

    @Schema(description = "Current password.", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456")
    @NotEmpty(message = "Current password cannot be empty.")
    @Length(min = 4, max = 16, message = "Password must be 4-16 characters.")
    private String oldPassword;

    @Schema(description = "New password.", requiredMode = Schema.RequiredMode.REQUIRED, example = "654321")
    @NotEmpty(message = "New password cannot be empty.")
    @Length(min = 4, max = 16, message = "Password must be 4-16 characters.")
    private String newPassword;

}
