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

@Schema(description = "User APP - edit Mobile request.")
@Data
public class AppMemberUserUpdateMobileReqVO {

    @Schema(description = "SMS code", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotEmpty(message = "SMS code is required.")
    @Length(min = 4, max = 6, message = "SMS code length is 4-6 characters.")
    @Pattern(regexp = "^[0-9]+$", message = "SMS code must all is digits.")
    private String code;

    @Schema(description = "Phone number.",requiredMode = Schema.RequiredMode.REQUIRED, example = "15823654487")
    @NotBlank(message = "Phone number is required.")
    @Length(min = 8, max = 11, message = "Mobile Number length is 8-11 characters.")
    @Mobile
    private String mobile;

    @Schema(description = "Original phone verification code.", example = "1024")
    @Length(min = 4, max = 6, message = "SMS code length is 4-6 characters.")
    @Pattern(regexp = "^[0-9]+$", message = "SMS code must all is digits.")
    private String oldCode;

}
