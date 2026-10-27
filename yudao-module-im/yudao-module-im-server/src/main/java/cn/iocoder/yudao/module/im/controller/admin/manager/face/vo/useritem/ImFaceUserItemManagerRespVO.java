package cn.iocoder.yudao.module.im.controller.admin.manager.face.vo.useritem;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - IM user emoji response.")
@Data
public class ImFaceUserItemManagerRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4096")
    private Long id;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long userId;

    @Schema(description = "Nickname.", example = "John.")
    private String userNickname;

    @Schema(description = "Sticker Image URL.", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "https://cdn.example.com/face/user/abc.gif")
    private String url;

    @Schema(description = "Emoji Name", example = "Dog")
    private String name;

    @Schema(description = "Render width (pixels).", example = "200")
    private Integer width;

    @Schema(description = "Render height (pixels).", example = "200")
    private Integer height;

    @Schema(description = "Add time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
