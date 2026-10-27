package cn.iocoder.yudao.module.system.controller.admin.auth.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 电脑轮询领取扫码登录结果 Request VO
 *
 * @author 芋道源码
 */
@Schema(description = "Poll QR sign-in from desktop request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class AuthQrcodePollReqVO extends AuthQrcodeConfirmReqVO {

    @Schema(description = "Claim token from QR generation.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Claim token cannot be empty.")
    @Pattern(regexp = "[a-f0-9]{32}", message = "Claim token format is invalid.")
    @ToString.Exclude
    private String secret;

}
