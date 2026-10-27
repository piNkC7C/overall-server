package cn.iocoder.yudao.module.ai.controller.admin.model.vo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - AI model response.")
@Data
public class AiModelRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2630")
    private Long id;

    @Schema(description = "API key ID.", example = "22042")
    private Long keyId;

    @Schema(description = "Model name.", example = "John.")
    private String name;

    @Schema(description = "Model key.", example = "gpt-3.5-turbo-0125")
    private String model;

    @Schema(description = "ModelPlatform.", example = "OpenAI")
    private String platform;

    @Schema(description = "Model type.", example = "1")
    private Integer type;

    @Schema(description = "Sort.", example = "1")
    private Integer sort;

    @Schema(description = "Status.", example = "2")
    private Integer status;

    @Schema(description = "Temperature", example = "1")
    private Double temperature;

    @Schema(description = "Maximum tokens per reply.", example = "4096")
    private Integer maxTokens;

    @Schema(description = "Maximum context messages.", example = "8192")
    private Integer maxContexts;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}