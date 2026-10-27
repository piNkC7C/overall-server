package cn.iocoder.yudao.module.im.controller.admin.manager.face.vo.item;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "IM sticker item response VO.")
@Data
public class ImFacePackItemRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long id;

    @Schema(description = "Sticker pack ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long packId;

    @Schema(description = "Sticker Image URL.", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "https://cdn.example.com/face/pack/cat-001.png")
    private String url;

    @Schema(description = "Emoji Name", example = "Dog")
    private String name;

    @Schema(description = "Render width (pixels).", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    private Integer width;

    @Schema(description = "Render height (pixels).", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    private Integer height;

    @Schema(description = "Sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer sort;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status; // See CommonStatusEnum enum class

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
