package cn.iocoder.yudao.module.system.api.notify.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Map;

@Schema(description = "Send an inbox message to an admin or member request VO.")
@Data
public class NotifySendSingleToUserReqDTO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "User ID is required.")
    private Long userId;

    @Schema(description = "Inbox template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "USER_SEND")
    @NotEmpty(message = "Inbox template code is required.")
    private String templateCode;
    @Schema(description = "Email template parameter.")
    private Map<String, Object> templateParams;
}
