package cn.iocoder.yudao.module.ai.controller.admin.music.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "AI update my music request VO.")
@Data
public class AiMusicUpdateMyReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15583")
    @NotNull(message = "Code is required.")
    private Long id;

    @Schema(description = "Music name.", example = "Brightest star")
    private String title;

}