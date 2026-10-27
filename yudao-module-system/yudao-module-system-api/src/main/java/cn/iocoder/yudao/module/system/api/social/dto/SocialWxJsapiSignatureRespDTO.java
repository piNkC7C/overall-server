package cn.iocoder.yudao.module.system.api.social.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "RPC service - WeChatOfficial Account JSAPI signature Response DTO.")
@Data
public class SocialWxJsapiSignatureRespDTO {

    @Schema(description = "WeChatOfficial Account appId.", requiredMode = Schema.RequiredMode.REQUIRED, example = "wx123456")
    private String appId;

    @Schema(description = "Anonymous token.", requiredMode = Schema.RequiredMode.REQUIRED, example = "zsw")
    private String nonceStr;

    @Schema(description = "Timestamp.", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456789")
    private Long timestamp;

    @Schema(description = "URL", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    private String url;

    @Schema(description = "Signature.", requiredMode = Schema.RequiredMode.REQUIRED, example = "zsw")
    private String signature;

}
