package cn.iocoder.yudao.module.system.controller.admin.auth.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Schema(description = "Admin - sign-in response.")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthLoginRespVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long userId;

    @Schema(description = "Access token.", requiredMode = Schema.RequiredMode.REQUIRED, example = "happy")
    private String accessToken;

    @Schema(description = "Refresh token.", requiredMode = Schema.RequiredMode.REQUIRED, example = "nice")
    private String refreshToken;

    @Schema(description = "Expires at", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime expiresTime;

}
