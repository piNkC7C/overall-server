package cn.iocoder.yudao.module.member.controller.app.level.vo.level;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "User App - member level response.")
@Data
public class AppMemberLevelRespVO {

    @Schema(description = "Level name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String name;

    @Schema(description = "Level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer level;

    @Schema(description = "Upgrade experience.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer experience;

    @Schema(description = "Discount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "98")
    private Integer discountPercent;

    @Schema(description = "Level Icon.", example = "https://www.iocoder.cn/yudao.jpg")
    private String icon;

    @Schema(description = "Level background image.", example = "https://www.iocoder.cn/yudao.jpg")
    private String backgroundUrl;

}
