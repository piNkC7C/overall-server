package cn.iocoder.yudao.module.member.controller.app.signin.vo.record;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Check-in record response VO.")
@Data
public class AppMemberSignInRecordRespVO {

    @Schema(description = "Check-in day.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer day;

    @Schema(description = "Check-in score.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer point;

    @Schema(description = "Check-in XP.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer experience;

    @Schema(description = "Check-in Time", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
