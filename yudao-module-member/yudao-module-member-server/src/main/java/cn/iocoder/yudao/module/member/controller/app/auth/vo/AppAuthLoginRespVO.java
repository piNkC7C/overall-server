package cn.iocoder.yudao.module.member.controller.app.auth.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Schema(description = "User APP - sign-in response.")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppAuthLoginRespVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long userId;

    @Schema(description = "Access token.", requiredMode = Schema.RequiredMode.REQUIRED, example = "happy")
    private String accessToken;

    @Schema(description = "Refresh token.", requiredMode = Schema.RequiredMode.REQUIRED, example = "nice")
    private String refreshToken;

    @Schema(description = "Expires at", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime expiresTime;

    /**
     * 仅社交登录、社交绑定时会返回
     *
     * 为什么需要返回？微信公众号、微信小程序支付需要传递 openid 给支付接口
     */
    @Schema(description = "Social user openid.", example = "qq768")
    private String openid;

}
