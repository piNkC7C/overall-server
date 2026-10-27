package cn.iocoder.yudao.module.system.controller.admin.auth.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(description = "Admin - Verification code request.")
@Data
public class CaptchaVerificationReqVO {

    // ========== 图片验证码相关 ==========
    @Schema(description = "Captcha. Required when captcha is enabled.", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "PfcH6mgr8tpXuMWFjvW6YVaqrswIuwmWI5dsVZSg7sGpWtDCUbHuDEXl3cFB1+VvCC/rAkSwK8Fad52FSuncVg==")
    @NotEmpty(message = "Verification code is required.", groups = CodeEnableGroup.class)
    private String captchaVerification;

    /**
     * 开启验证码的 Group
     */
    public interface CodeEnableGroup {
    }
}
