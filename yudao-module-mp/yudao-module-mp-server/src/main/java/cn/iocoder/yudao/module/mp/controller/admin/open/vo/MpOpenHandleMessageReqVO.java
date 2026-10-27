package cn.iocoder.yudao.module.mp.controller.admin.open.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;

@Schema(description = "Admin - Official Account process message request.")
@Data
public class MpOpenHandleMessageReqVO {

    public static final String ENCRYPT_TYPE_AES = "aes";

    @Schema(description = "WeChat signature.", requiredMode = Schema.RequiredMode.REQUIRED, example = "490eb57f448b87bd5f20ccef58aa4de46aa1908e")
    @NotEmpty(message = "WeChat signature cannot be empty.")
    private String signature;

    @Schema(description = "Timestamp.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1672587863")
    @NotEmpty(message = "Timestamp cannot be empty.")
    private String timestamp;

    @Schema(description = "Nonce.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1827365808")
    @NotEmpty(message = "Nonce cannot be empty.")
    private String nonce;

    @Schema(description = "Follower openid.", requiredMode = Schema.RequiredMode.REQUIRED, example = "oz-Jdtyn-WGm4C4I5Z-nvBMO_ZfY")
    @NotEmpty(message = "Follower openid is required.")
    private String openid;

    @Schema(description = "Message encryption type.", example = "aes")
    private String encrypt_type;

    @Schema(description = "WeChatsignature.", example = "QW5kcm9pZCBUaGUgQmFzZTY0IGlzIGEgZ2VuZXJhdGVkIHN0cmluZw==")
    private String msg_signature;

}
