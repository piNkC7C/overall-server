package cn.iocoder.yudao.module.ai.controller.admin.image.vo;

import cn.iocoder.yudao.module.ai.framework.ai.core.model.midjourney.api.MidjourneyApi;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Schema(description = "Admin - AI image generation response.")
@Data
public class AiImageRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long userId;

    @Schema(description = "Platform", requiredMode = Schema.RequiredMode.REQUIRED, example = "OpenAI")
    private String platform;  // See AiPlatformEnum enum

    @Schema(description = "Model.", requiredMode = Schema.RequiredMode.REQUIRED, example = "stable-diffusion-v1-6")
    private String model;

    @Schema(description = "Prompt", requiredMode = Schema.RequiredMode.REQUIRED, example = "A little penguin in Antarctica")
    private String prompt;

    @Schema(description = "Image width.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer width;

    @Schema(description = "ImageHeight.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer height;

    @Schema(description = "Image generationstatus.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer status;

    @Schema(description = "Is not Publish.", requiredMode = Schema.RequiredMode.REQUIRED, example = "public")
    private Boolean publicStatus;

    @Schema(description = "ImageAddress.", example = "https://www.iocoder.cn/1.png")
    private String picUrl;

    @Schema(description = "Image error message.", example = "ImageError info.")
    private String errorMessage;

    @Schema(description = "Draw parameters.")
    private Map<String, String> options;

    @Schema(description = "Mj buttons.")
    private List<MidjourneyApi.Button> buttons;

    @Schema(description = "Complete time.")
    private LocalDateTime finishTime;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
