package cn.iocoder.yudao.module.mp.controller.admin.open.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;

@Schema(description = "Official account Validate the signature request VO.")
@Data
public class MpOpenCheckSignatureReqVO {

    @Schema(description = "WeChat signature.", requiredMode = Schema.RequiredMode.REQUIRED, example = "490eb57f448b87bd5f20ccef58aa4de46aa1908e")
    @NotEmpty(message = "WeChat signature cannot be empty.")
    private String signature;

    @Schema(description = "Timestamp.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1672587863")
    @NotEmpty(message = "Timestamp cannot be empty.")
    private String timestamp;

    @Schema(description = "Nonce.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1827365808")
    @NotEmpty(message = "Nonce cannot be empty.")
    private String nonce;

    @Schema(description = "Nonce.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2721154047828672511")
    @NotEmpty(message = "Nonce cannot be empty.")
    @SuppressWarnings("SpellCheckingInspection")
    private String echostr;

}
