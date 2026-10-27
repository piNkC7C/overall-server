package cn.iocoder.yudao.module.member.controller.app.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Schema(description = "User App - memberuserupdate request.")
@Data
public class AppMemberUserUpdateReqVO {

    @Schema(description = "Nickname", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    private String nickname;

    @Schema(description = "Avatar", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/x.png")
    @URL(message = "Avatar must be URL format.")
    private String avatar;

    @Schema(description = "Email", example = "member@iocoder.cn")
    @Email(message = "Email format is invalid.")
    @Size(max = 50, message = "Email length cannot exceed 50 characters.")
    private String email;

    @Schema(description = "Gender", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer sex;

}
