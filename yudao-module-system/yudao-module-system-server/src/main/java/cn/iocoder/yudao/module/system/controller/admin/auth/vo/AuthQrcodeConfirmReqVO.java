package cn.iocoder.yudao.module.system.controller.admin.auth.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * 手机确认扫码登录 Request VO
 *
 * @author 芋道源码
 */
@Schema(description = "Confirm QR sign-in on mobile request VO.")
@Data
public class AuthQrcodeConfirmReqVO {

    @Schema(description = "QR Code code.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "QR Code code is required.")
    @Pattern(regexp = "[a-f0-9]{32}", message = "QR Code code format is invalid.")
    private String qrcodeId;

}
