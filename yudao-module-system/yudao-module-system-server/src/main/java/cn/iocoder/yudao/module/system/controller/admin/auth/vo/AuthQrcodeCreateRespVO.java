package cn.iocoder.yudao.module.system.controller.admin.auth.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

/**
 * 扫码登录二维码 Response VO
 *
 * @author 芋道源码
 */
@Schema(description = "QR sign-in code response VO.")
@Data
public class AuthQrcodeCreateRespVO {

    @Schema(description = "QR Code code.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String qrcodeId;

    @Schema(description = "Desktop claim token. Stored only on the QR page.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ToString.Exclude
    private String secret;

    @Schema(description = "QR content, without the claim token.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String qrContent;

    @Schema(description = "Expiration date, order characters ：Seconds.", requiredMode = Schema.RequiredMode.REQUIRED, example = "180")
    private Integer expiresIn;

}
