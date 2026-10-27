package cn.iocoder.yudao.module.im.controller.admin.face.vo.useritem;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "IM person emoji create request.")
@Data
public class ImFaceUserItemSaveReqVO {

    @Schema(description = "Sticker Image URL.", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "https://cdn.example.com/face/user/abc.gif")
    @NotBlank(message = "Sticker Image URL is required.")
    @Size(max = 512, message = "Sticker Image URL length cannot exceed 512.")
    private String url;

    @Schema(description = "Emoji Name", example = "Dog")
    @Size(max = 64, message = "Emoji Name length cannot exceed 64.")
    private String name;

    @Schema(description = "Render width (pixels).", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    @NotNull(message = "Render width cannot be empty.")
    @Min(value = 1, message = "Render width cannot be less than 1 pixel.")
    @Max(value = 2048, message = "Render width cannot be greater than 2048 pixels.")
    private Integer width;

    @Schema(description = "Render height (pixels).", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    @NotNull(message = "Render height cannot be empty.")
    @Min(value = 1, message = "Render height cannot be less than 1 pixel.")
    @Max(value = 2048, message = "Render height cannot be greater than 2048 pixels.")
    private Integer height;

}
