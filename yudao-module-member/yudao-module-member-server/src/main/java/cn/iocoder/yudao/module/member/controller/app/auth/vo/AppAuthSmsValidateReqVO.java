package cn.iocoder.yudao.module.member.controller.app.auth.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.framework.common.validation.Mobile;
import cn.iocoder.yudao.module.system.enums.sms.SmsSceneEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Schema(description = "Validate mobile verification code request VO.")
@Data
public class AppAuthSmsValidateReqVO {

    @Schema(description = "Phone number.", example = "15601691234")
    @Mobile
    private String mobile;

    @Schema(description = "Send scene, matching SmsSceneEnum enum.", example = "1")
    @NotNull(message = "Send scene is required")
    @InEnum(SmsSceneEnum.class)
    private Integer scene;

    @Schema(description = "SMS code", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotEmpty(message = "SMS code is required.")
    @Length(min = 4, max = 6, message = "SMS code length is 4-6 characters.")
    @Pattern(regexp = "^[0-9]+$", message = "SMS code must all is digits.")
    private String code;

}
