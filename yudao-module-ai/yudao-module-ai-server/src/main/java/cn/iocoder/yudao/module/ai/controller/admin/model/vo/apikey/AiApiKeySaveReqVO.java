package cn.iocoder.yudao.module.ai.controller.admin.model.vo.apikey;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "Admin - AI API secret create / edit request.")
@Data
public class AiApiKeySaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23538")
    private Long id;

    @Schema(description = "Name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Ernie")
    @NotEmpty(message = "Name is required.")
    private String name;

    @Schema(description = "Secret.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ABC")
    @NotEmpty(message = "Secret is required.")
    private String apiKey;

    @Schema(description = "Platform", requiredMode = Schema.RequiredMode.REQUIRED, example = "OpenAI")
    @NotEmpty(message = "Platform is required.")
    private String platform;

    @Schema(description = "Custom API Address.", example = "https://aip.baidubce.com")
    private String url;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    private Integer status;

}