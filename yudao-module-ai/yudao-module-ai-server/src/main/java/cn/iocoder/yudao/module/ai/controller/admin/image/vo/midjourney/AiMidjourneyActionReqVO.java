package cn.iocoder.yudao.module.ai.controller.admin.image.vo.midjourney;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "AI image generation action (Midjourney) request VO.")
@Data
public class AiMidjourneyActionReqVO {

    @Schema(description = "Image code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Image code is required.")
    private Long id;

    @Schema(description = "Action code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "MJ::JOB::variation::4::06aa3e66-0e97-49cc-8201-e0295d883de4")
    @NotEmpty(message = "Action code is required.")
    private String customId;

}
