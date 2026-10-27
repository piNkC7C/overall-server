package cn.iocoder.yudao.module.system.api.social.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "WeChat mini program mobile info response VO.")
@Data
public class SocialWxPhoneNumberInfoRespDTO {

    @Schema(description = "Bound phone number. International numbers include a country code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "021-13579246810")
    private String phoneNumber;

    @Schema(description = "Phone without country code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "13579246810")
    private String purePhoneNumber;
    @Schema(description = "Country code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "021")
    private String countryCode;

}
