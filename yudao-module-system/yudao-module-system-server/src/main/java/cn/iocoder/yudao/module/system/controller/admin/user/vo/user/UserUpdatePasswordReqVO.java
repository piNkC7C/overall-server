package cn.iocoder.yudao.module.system.controller.admin.user.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - userupdate password request.")
@Data
public class UserUpdatePasswordReqVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "User ID is required.")
    private Long id;

    @Schema(description = "Password.", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456")
    @NotEmpty(message = "Password is required.")
    @Length(min = 4, max = 16, message = "Password must be 4-16 characters.")
    private String password;

}
