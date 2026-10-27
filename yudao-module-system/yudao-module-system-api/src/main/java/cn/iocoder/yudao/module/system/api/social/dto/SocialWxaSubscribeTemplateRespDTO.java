package cn.iocoder.yudao.module.system.api.social.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Mini program subscribe message template response VO.")
@Data
public class SocialWxaSubscribeTemplateRespDTO {

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private String id;

    @Schema(description = "Template title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Template title.")
    private String title;

    @Schema(description = "Template content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Template content.")
    private String content;

    @Schema(description = "Template content sample.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Template content sample.")
    private String example;

    @Schema(description = "Template type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer type; // 2：为一次性订阅；3：为长期订阅

}
