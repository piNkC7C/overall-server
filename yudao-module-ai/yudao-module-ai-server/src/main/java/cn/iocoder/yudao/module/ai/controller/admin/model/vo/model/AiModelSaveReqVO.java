package cn.iocoder.yudao.module.ai.controller.admin.model.vo.model;

import cn.iocoder.yudao.module.ai.enums.model.AiModelTypeEnum;
import cn.iocoder.yudao.module.ai.enums.model.AiPlatformEnum;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - API model create / edit request.")
@Data
public class AiModelSaveReqVO {

    @Schema(description = "Code.", example = "2630")
    private Long id;

    @Schema(description = "API key ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "22042")
    @NotNull(message = "API key ID cannot be empty.")
    private Long keyId;

    @Schema(description = "Model name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    @NotEmpty(message = "Model name is required.")
    private String name;

    @Schema(description = "Model key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "gpt-3.5-turbo-0125")
    @NotEmpty(message = "Model key is required.")
    private String model;

    @Schema(description = "ModelPlatform.", requiredMode = Schema.RequiredMode.REQUIRED, example = "OpenAI")
    @NotEmpty(message = "ModelPlatform is required.")
    @InEnum(AiPlatformEnum.class)
    private String platform;

    @Schema(description = "Model type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Model type is required.")
    @InEnum(AiModelTypeEnum.class)
    private Integer type;

    @Schema(description = "Sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @InEnum(CommonStatusEnum.class)
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "Temperature", example = "1")
    private Double temperature;

    @Schema(description = "Maximum tokens per reply.", example = "4096")
    private Integer maxTokens;

    @Schema(description = "Maximum context messages.", example = "8192")
    private Integer maxContexts;

}