package cn.iocoder.yudao.module.ai.controller.admin.image.vo.midjourney;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - AI 绘画生成（Midjourney） Request VO")
@Data
public class AiMidjourneyImagineReqVO {

    @Schema(description = "提示词", requiredMode = Schema.RequiredMode.REQUIRED, example = "China Shenlong")
    @NotEmpty(message = "Prompt is required!")
    private String prompt;

    @Schema(description = "模型编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Model code is required.")
    private Long modelId;

    @Schema(description = "图片宽度", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Image width cannot be empty.")
    private Integer width;

    @Schema(description = "图片高度", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "ImageHeight is required.")
    private Integer height;

    @Schema(description = "版本号", requiredMode = Schema.RequiredMode.REQUIRED, example = "6.0")
    @NotEmpty(message = "Version is required.")
    private String version;

    @Schema(description = "参考图", example = "https://www.iocoder.cn/x.png")
    private String referImageUrl;

}
