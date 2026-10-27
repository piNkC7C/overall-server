package cn.iocoder.yudao.module.im.controller.admin.manager.face.vo.pack;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - IM sticker pack response.")
@Data
public class ImFacePackRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Sticker pack name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Kitty")
    private String name;

    @Schema(description = "Sticker packIcon.", example = "https://cdn.example.com/face/pack/cat.png")
    private String icon;

    @Schema(description = "Sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer sort;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status; // See CommonStatusEnum enum class

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
