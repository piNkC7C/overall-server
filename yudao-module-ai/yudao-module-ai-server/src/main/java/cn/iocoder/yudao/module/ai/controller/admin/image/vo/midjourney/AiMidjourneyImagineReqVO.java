package cn.iocoder.yudao.module.ai.controller.admin.image.vo.midjourney;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - AI image generationgenerate (Midjourney) request.")
@Data
public class AiMidjourneyImagineReqVO {

    @Schema(description = "Prompt", requiredMode = Schema.RequiredMode.REQUIRED, example = "China Shenlong")
    @NotEmpty(message = "Prompt is required!")
    private String prompt;

    @Schema(description = "Model code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Model code is required.")
    private Long modelId;

    @Schema(description = "Image width.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Image width cannot be empty.")
    private Integer width;

    @Schema(description = "ImageHeight.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "ImageHeight is required.")
    private Integer height;

    @Schema(description = "Version.", requiredMode = Schema.RequiredMode.REQUIRED, example = "6.0")
    @NotEmpty(message = "Version is required.")
    private String version;

    @Schema(description = "Reference image.", example = "https://www.iocoder.cn/x.png")
    private String referImageUrl;

}
