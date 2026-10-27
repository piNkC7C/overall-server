package cn.iocoder.yudao.module.im.controller.admin.face.vo.useritem;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "IM person emoji response.")
@Data
public class ImFaceUserItemRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4096")
    private Long id;

    @Schema(description = "Sticker Image URL.", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "https://cdn.example.com/face/user/abc.gif")
    private String url;

    @Schema(description = "Emoji Name", example = "Dog")
    private String name;

    @Schema(description = "Render width (pixels).", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    private Integer width;

    @Schema(description = "Render height (pixels).", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    private Integer height;

}
