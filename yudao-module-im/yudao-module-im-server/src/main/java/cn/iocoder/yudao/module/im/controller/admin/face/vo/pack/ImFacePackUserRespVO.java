package cn.iocoder.yudao.module.im.controller.admin.face.vo.pack;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "App sticker pack response VO.")
@Data
public class ImFacePackUserRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Sticker pack name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Kitty")
    private String name;

    @Schema(description = "Sticker packIcon.", example = "https://cdn.example.com/face/pack/cat.png")
    private String icon;

    @Schema(description = "Emoji list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Item> items;

    @Schema(description = "App sticker item.")
    @Data
    public static class Item {

        @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
        private Long id;

        @Schema(description = "Sticker Image URL.", requiredMode = Schema.RequiredMode.REQUIRED,
                example = "https://cdn.example.com/face/pack/cat-001.png")
        private String url;

        @Schema(description = "Emoji Name", example = "Dog")
        private String name;

        @Schema(description = "Render width (pixels).", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
        private Integer width;

        @Schema(description = "Render height (pixels).", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
        private Integer height;

    }

}
