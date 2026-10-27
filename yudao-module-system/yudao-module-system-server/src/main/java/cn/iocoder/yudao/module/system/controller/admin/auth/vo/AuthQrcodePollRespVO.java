package cn.iocoder.yudao.module.system.controller.admin.auth.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

/**
 * 电脑领取扫码登录结果 Response VO
 *
 * @author 芋道源码
 */
@Schema(description = "QR sign-in result response VO.")
@Data
public class AuthQrcodePollRespVO {

    @Schema(description = "QR status. See AuthQrcodeStatusEnum.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer status;

    @Schema(description = "Desktop independent sign-in result. Returned only on success.")
    @ToString.Exclude
    private AuthLoginRespVO login;

}
