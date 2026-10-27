package cn.iocoder.yudao.module.promotion.controller.app.bargain.vo.help;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "User App - bargain assist response.")
@Data
public class AppBargainHelpRespVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long userId;

    @Schema(description = "Assist user Nickname.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private String nickname;

    @Schema(description = "Assist user Avatar.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private String avatar;

    @Schema(description = "Assist user bargain amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer reducePrice;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private LocalDateTime createTime;

}
