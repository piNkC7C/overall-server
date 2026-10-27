package cn.iocoder.yudao.module.member.controller.app.auth.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "User APP - WeChatOfficial Account JSAPI signature response.")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthWeixinJsapiSignatureRespVO {

    @Schema(description = "WeChatOfficial Account appId.", requiredMode = Schema.RequiredMode.REQUIRED, example = "hello")
    private String appId;

    @Schema(description = "Anonymous token.", requiredMode = Schema.RequiredMode.REQUIRED, example = "world")
    private String nonceStr;

    @Schema(description = "Timestamp.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long timestamp;

    @Schema(description = "URL", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    private String url;

    @Schema(description = "Signature.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Blah blah")
    private String signature;

}
