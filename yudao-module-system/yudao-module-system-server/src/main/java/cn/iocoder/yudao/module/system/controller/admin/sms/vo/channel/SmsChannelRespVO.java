package cn.iocoder.yudao.module.system.controller.admin.sms.vo.channel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Schema(description = "Admin - SMS channel response.")
@Data
public class SmsChannelRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "SMS signature.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotNull(message = "SMS signature is required.")
    private String signature;

    @Schema(description = "Channel code, see SmsChannelEnum enum class.", requiredMode = Schema.RequiredMode.REQUIRED, example = "YUN_PIAN")
    private String code;

    @Schema(description = "Enabled status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Enabled status is required.")
    private Integer status;

    @Schema(description = "Notes.", example = "Tasty!")
    private String remark;

    @Schema(description = "SMS API account.", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao")
    @NotNull(message = "SMS API account is required.")
    private String apiKey;

    @Schema(description = "SMS API secret.", example = "yuanma")
    private String apiSecret;

    @Schema(description = "SMS callback URL", example = "https://www.iocoder.cn")
    @URL(message = "Callback URL format is invalid.")
    private String callbackUrl;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
