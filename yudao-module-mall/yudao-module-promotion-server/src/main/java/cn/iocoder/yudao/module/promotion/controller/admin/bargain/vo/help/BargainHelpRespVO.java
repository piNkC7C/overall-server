package cn.iocoder.yudao.module.promotion.controller.admin.bargain.vo.help;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "Admin - bargain assist response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BargainHelpRespVO extends BargainHelpBaseVO {

    @Schema(description = "Bargain assist code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "25860")
    private Long id;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    // ========== 用户相关 ==========

    @Schema(description = "Nickname", example = "John")
    private String nickname;

    @Schema(description = "UserAvatar.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xxx.jpg")
    private String avatar;

}
