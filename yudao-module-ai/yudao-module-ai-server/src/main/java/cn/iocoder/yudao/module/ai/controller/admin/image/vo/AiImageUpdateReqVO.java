package cn.iocoder.yudao.module.ai.controller.admin.image.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - AI image generationupdate request.")
@Data
public class AiImageUpdateReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15583")
    @NotNull(message = "Code is required.")
    private Long id;

    @Schema(description = "Is not Publish.", example = "true")
    private Boolean publicStatus;

}