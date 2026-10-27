package cn.iocoder.yudao.module.system.api.sms.dto.send;

import cn.iocoder.yudao.framework.common.validation.Mobile;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import java.util.Map;

@Schema(description = "Send SMS to an admin or member request VO.")
@Data
public class SmsSendSingleToUserReqDTO {

    @Schema(description = "User ID.", example = "1024")
    private Long userId;
    @Schema(description = "Phone number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15601691300")
    @Mobile
    private String mobile;

    @Schema(description = "SMS template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "USER_SEND")
    @NotEmpty(message = "SMS template code is required.")
    private String templateCode;
    @Schema(description = "SMS template parameter.")
    private Map<String, Object> templateParams;

}
