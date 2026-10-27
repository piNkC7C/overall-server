package cn.iocoder.yudao.module.ai.controller.admin.model.vo.apikey;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "Admin - AI API secret response.")
@Data
public class AiApiKeyRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23538")
    private Long id;

    @Schema(description = "Name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Ernie")
    private String name;

    @Schema(description = "Secret.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ABC")
    private String apiKey;

    @Schema(description = "Platform", requiredMode = Schema.RequiredMode.REQUIRED, example = "OpenAI")
    private String platform;

    @Schema(description = "Custom API Address.", example = "https://aip.baidubce.com")
    private String url;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

}