package cn.iocoder.yudao.module.trade.controller.admin.base.system.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "User simple info VO.")
@Data
public class UserSimpleBaseVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Nickname", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String nickname;

    @Schema(description = "UserAvatar.", example = "https://www.iocoder.cn/1.png")
    private String avatar;

}