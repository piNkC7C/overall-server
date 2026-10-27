package cn.iocoder.yudao.module.member.controller.app.signin.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Check-in rule response VO.")
@Data
public class AppMemberSignInConfigRespVO {

    @Schema(description = "Check-in day X.", requiredMode = Schema.RequiredMode.REQUIRED, example = "7")
    private Integer day;

    @Schema(description = "Bonus points.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer point;

}
