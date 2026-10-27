package cn.iocoder.yudao.module.member.controller.app.signin.vo.record;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Personal check-in stats response VO.")
@Data
public class AppMemberSignInRecordSummaryRespVO {

    @Schema(description = "Total check-in days.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer totalDay;

    @Schema(description = "Consecutive check-in day X.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Integer continuousDay;

    @Schema(description = "Checked in today.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean todaySignIn;

}
