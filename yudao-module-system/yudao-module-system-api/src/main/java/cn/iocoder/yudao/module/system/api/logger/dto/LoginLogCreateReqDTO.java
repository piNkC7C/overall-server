package cn.iocoder.yudao.module.system.api.logger.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Sign-in log create request VO.")
@Data
public class LoginLogCreateReqDTO {

    @Schema(description = "Log type, see LoginLogTypeEnum enum class.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1" )
    @NotNull(message = "Log type is required.")
    private Integer logType;

    @Schema(description = "Trace ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "89aca178-a370-411c-ae02-3f0d672be4ab")
    private String traceId;

    @Schema(description = "User ID.", example = "666")
    private Long userId;
    @Schema(description = "User type. See UserTypeEnum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2" )
    @NotNull(message = "User type is required.")
    private Integer userType;
    @Schema(description = "Username.", example = "yudao")
    @Size(max = 30, message = "Username length cannot exceed 30 characters.")
    private String username; // 不再强制校验 username 非空，因为 Member 社交登录时，此时暂时没有 username(mobile）！

    @Schema(description = "Sign-in result, see LoginResultEnum enum class.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Sign-in result is required.")
    private Integer result;

    @Schema(description = "User IP.", requiredMode = Schema.RequiredMode.REQUIRED, example = "127.0.0.1")
    @NotEmpty(message = "User IP is required.")
    private String userIp;

    @Schema(description = "Browser user agent.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Mozilla/5.0")
    private String userAgent;

}
