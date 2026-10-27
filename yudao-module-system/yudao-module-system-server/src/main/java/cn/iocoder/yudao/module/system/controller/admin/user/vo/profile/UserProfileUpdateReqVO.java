package cn.iocoder.yudao.module.system.controller.admin.user.vo.profile;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;


@Schema(description = "Admin - user person info update request.")
@Data
public class UserProfileUpdateReqVO {

    @Schema(description = "Nickname", example = "Overall.")
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

    @Schema(description = "RoleAvatar.", example = "https://www.iocoder.cn/1.png")
    @URL(message = "AvatarAddress format is invalid.")
    private String avatar;

}
