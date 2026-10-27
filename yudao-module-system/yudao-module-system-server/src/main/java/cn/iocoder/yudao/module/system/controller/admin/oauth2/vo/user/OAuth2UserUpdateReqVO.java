package cn.iocoder.yudao.module.system.controller.admin.oauth2.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Schema(description = "Admin - OAuth2 updateuserBasic Info request.")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OAuth2UserUpdateReqVO {

    @Schema(description = "Nickname", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @Size(max = 30, message = "Nickname length cannot exceed 30 characters.")
    private String nickname;

    @Schema(description = "Useremail.", example = "yudao@iocoder.cn")
    @Email(message = "Email format is invalid.")
    @Size(max = 50, message = "Email length cannot exceed 50 characters.")
    private String email;

    @Schema(description = "Mobile Number", example = "15601691300")
    @Length(min = 11, max = 11, message = "Phone number length must 11 characters.")
    private String mobile;

    @Schema(description = "UserGender, see SexEnum enum class.", example = "1")
    private Integer sex;

}
